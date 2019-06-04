package br.com.academy.repository.api;

import br.com.academy.model.ChatMessage;
import br.com.academy.repository.settings.ApiUrls;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IChatMessageRepository {

    @GET(ApiUrls.CHAT_MESSAGE)
    Call<List<ChatMessage>> list(@Query("chat") Integer chat);

}
