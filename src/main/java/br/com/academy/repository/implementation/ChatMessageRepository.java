package br.com.academy.repository.implementation;

import br.com.academy.model.Chat;
import br.com.academy.model.ChatMessage;
import br.com.academy.repository.api.IChatMessageRepository;
import br.com.academy.repository.settings.Repository;
import java.util.List;
import retrofit2.Call;

import java.util.Objects;

public class ChatMessageRepository extends Repository {

    private static ChatMessageRepository instance;
    private final IChatMessageRepository repository = super.getRetrofitInstance().create(IChatMessageRepository.class);

    public static ChatMessageRepository getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ChatMessageRepository();
        }
        return instance;
    }

    public List<ChatMessage> list(Integer chat) {
        Call<List<ChatMessage>> call = this.repository.list(chat);
        return super.getEntityList(call);
    }

}
