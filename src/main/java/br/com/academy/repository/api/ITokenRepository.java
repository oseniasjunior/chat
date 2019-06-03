package br.com.academy.repository.api;

import br.com.academy.dto.TokenDTO;
import br.com.academy.dto.LoginDTO;
import br.com.academy.repository.settings.ApiUrls;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ITokenRepository {

    @POST(ApiUrls.TOKEN)
    Call<TokenDTO> getToken(@Body LoginDTO userDTO);

}
