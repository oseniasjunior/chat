package br.com.academy.repository.implementation;

import br.com.academy.dto.CreateChatDTO;
import br.com.academy.model.Chat;
import br.com.academy.repository.api.IChatRepository;
import br.com.academy.repository.settings.Repository;
import retrofit2.Call;

import java.util.Objects;

public class ChatRepository extends Repository {

    private static ChatRepository instance;
    private final IChatRepository repository = super.getRetrofitInstance().create(IChatRepository.class);

    public static ChatRepository getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ChatRepository();
        }
        return instance;
    }

    public Chat getOrCreate(CreateChatDTO users) {
        Call<Chat> call = this.repository.getOrCreate(users);
        return super.getEntity(call);
    }

}
