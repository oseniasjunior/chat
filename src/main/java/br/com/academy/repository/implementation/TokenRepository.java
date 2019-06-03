package br.com.academy.repository.implementation;

import br.com.academy.dto.TokenDTO;
import br.com.academy.dto.LoginDTO;
import br.com.academy.repository.api.ITokenRepository;
import br.com.academy.repository.settings.Repository;
import retrofit2.Call;

import java.util.Objects;

public class TokenRepository extends Repository {

    private static TokenRepository instance;
    private final ITokenRepository repository = super.getRetrofitInstance().create(ITokenRepository.class);

    public static TokenRepository getInstance() {
        if (Objects.isNull(instance)) {
            instance = new TokenRepository();
        }
        return instance;
    }

    public TokenDTO getToken(LoginDTO userDTO) {
        Call<TokenDTO> call = this.repository.getToken(userDTO);
        return super.getEntity(call);
    }

}
