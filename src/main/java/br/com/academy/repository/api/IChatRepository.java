package br.com.academy.repository.api;

import br.com.academy.dto.CreateChatDTO;
import br.com.academy.model.Chat;
import br.com.academy.repository.settings.ApiUrls;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IChatRepository {

    @POST(ApiUrls.CHAT + "get_or_create/")
    Call<Chat> getOrCreate(@Body CreateChatDTO users);

}
