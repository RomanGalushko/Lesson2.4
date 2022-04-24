package pro.sky.Lesson.Controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.Lesson.Data.Employee;
import pro.sky.Lesson.Service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> allEmloyee() {
        return employeeService.allEmployee();
    }

    @GetMapping("/add")
    public boolean addEmployeeToList(@RequestParam String firstName, @RequestParam String lastName,
                                     @RequestParam Integer departmentId, @RequestParam Integer salary) {
        return employeeService.addEmployee(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/remove")
    public boolean removeEmployeeFromList(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public boolean findEmployeeInList(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/departments/max-salary")
    public List<Employee> employeeMaxSalaryList(@RequestParam Integer departmentId) {
        return employeeService.employeeMaxSalary(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public List<Employee> employeeMinSalaryList(@RequestParam Integer departmentId) {
        return employeeService.employeeMinSalary(departmentId);
    }

// не могу понять как реализовать возврат всех сотрудников отдела через URL /departments/all?departmentId=5

    @GetMapping(value = {"/departments/all", "/departments/all/{departmentId}"})
    public List<Employee> employeeAllDepartmentIdList(@PathVariable(required = false) String departmentId) {
        if (departmentId != null) {
            return employeeService.employeeAllDepartmentId(Integer.valueOf(departmentId));
        } else {
            return employeeService.allEmployeeByDepartments();
        }
    }
}