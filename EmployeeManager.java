
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Lambda tutorial on list class
 */
public class EmployeeManager {
  private static EmployeeManager instance;
  private List<String> employees;

  public EmployeeManager() {
    createEmployeeList();
  }

/** Singleton pattern
  public static EmployeeManager getInstance() {
    if (instance == null) {
      synchronized (EmployeeManager.class) {
        if (instance == null) {
          instance = new EmployeeManager();

        }
      }
    }
    return instance;
  }
  **/

  private void createEmployeeList() {
    if (employees == null) {
      employees = Arrays.asList("mike", "john", "william", "joseph", "vivian", "venus");
    }
  }

  public List<String> getEmployees() {
    return this.employees;
  }


  public void printAll(){
    this.employees.stream().sorted().forEach(System.out::println);
  }

  public void reverseSortList(){
    this.employees.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
  }

  public List<String> addToList(List<String> newEmployees){
    return Stream.concat(this.employees.stream(), newEmployees.stream())
                 .collect(Collectors.toList());
  }

  public void printNewList(List<String> modifiedList){
    modifiedList.parallelStream().sorted().forEach(System.out::println);
  }

}
