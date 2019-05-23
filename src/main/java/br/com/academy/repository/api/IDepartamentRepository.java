package br.com.academy.repository.api;

import br.com.academy.model.Departament;
import br.com.academy.repository.settings.ApiUrls;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Path;

public interface IDepartamentRepository {

    @GET(ApiUrls.DEPARTAMENT)
    Call<List<Departament>> list();

    @GET(ApiUrls.DEPARTAMENT + "{id}/")
    Call<Departament> retrieve(@Path("id") Integer id);

}
