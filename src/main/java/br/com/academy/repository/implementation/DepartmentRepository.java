package br.com.academy.repository.implementation;

import br.com.academy.model.Department;
import br.com.academy.repository.settings.Repository;
import retrofit2.Call;

import java.util.List;
import java.util.Objects;
import br.com.academy.repository.api.IDepartmentRepository;

public class DepartmentRepository extends Repository {

    private static DepartmentRepository instance;
    private final IDepartmentRepository repository = super.getRetrofitInstance().create(IDepartmentRepository.class);

    public static DepartmentRepository getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DepartmentRepository();
        }
        return instance;
    }

    public List<Department> list() {
        Call<List<Department>> call = this.repository.list();
        return super.getEntityList(call);
    }

    public Department retrieve(Integer id) {
        Call<Department> call = this.repository.retrieve(id);
        return super.getEntity(call);
    }

}
