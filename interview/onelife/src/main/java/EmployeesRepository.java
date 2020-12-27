import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EmployeesRepository {
    private List<Employee> employees = new ArrayList<>(0);


    EmployeesRepository(List<Employee> employees){
        this.employees.addAll(employees);
    }
    EmployeesRepository(Employee [] employees){
        Arrays.stream(employees).forEach(this.employees::add);
        
    }
    public Employee findById(int id ){
        return employees.stream().filter(e -> e.getId()==id).findFirst().orElseThrow();
    }


}
