/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academy.repository.settings;

import br.com.academy.configuration.Configurations;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Repository {

    protected Retrofit retrofit;
    private final RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.create();
    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS zzz").create();

    public Retrofit getRetrofitInstance() {
        if (Objects.isNull(retrofit)) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Configurations.API_SERVER + Configurations.API_PATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(rxAdapter)
                    .client(okHttpClient())
                    .build();

        }
        return retrofit;
    }

    protected <T> T getEntity(Call<T> call) {
        Response<T> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        if (!response.isSuccessful()) {
            throw new RuntimeException(response.message());
        }

        return response.body();
    }

    protected <T> T getEntityList(Call<T> call) {
        Response<T> response = null;
        try {
            // synchronous call
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        if (!response.isSuccessful()) {
            throw new RuntimeException(response.message());
        }

        return response.body();
    }

    private OkHttpClient okHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor((chain) -> {
            final Request original = chain.request();
            Request.Builder _builder = original.newBuilder().method(original.method(), original.body());
            Request request = _builder.build();
            return chain.proceed(request);
        });
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        return builder.build();
    }

}
