package br.com.academy.repository.implementation;

import br.com.academy.model.Departament;
import br.com.academy.repository.api.IDepartamentRepository;
import br.com.academy.repository.settings.Repository;
import retrofit2.Call;

import java.util.List;
import java.util.Objects;

public class DepartamentRepository extends Repository {

    private static DepartamentRepository instance;
    private final IDepartamentRepository repository = super.getRetrofitInstance().create(IDepartamentRepository.class);

    public static DepartamentRepository getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DepartamentRepository();
        }
        return instance;
    }

    public List<Departament> list() {
        Call<List<Departament>> call = this.repository.list();
        return super.getEntityList(call);
    }

    public Departament retrieve(Integer id) {
        Call<Departament> call = this.repository.retrieve(id);
        return super.getEntity(call);
    }

}
