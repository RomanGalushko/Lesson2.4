package pro.sky.Lesson.Controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.Lesson.Data.Employee;
import pro.sky.Lesson.Service.DepartmentService;
import pro.sky.Lesson.Service.Impl.DepartmentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final DepartmentService departmentService;

    public EmployeeController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public List<Employee> allEmloyee() {
        return departmentService.allEmployee();
    }

    @GetMapping("/add")
    public Employee addEmployeeToList(@RequestParam String firstName, @RequestParam String lastName,
                                     @RequestParam Integer departmentId, @RequestParam Integer salary) {
        return departmentService.addEmployee(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployeeFromList(@RequestParam String firstName, @RequestParam String lastName) {
        return departmentService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployeeInList(@RequestParam String firstName, @RequestParam String lastName) {
        return departmentService.findEmployee(firstName, lastName);
    }

    @GetMapping("/departments/max-salary")
    public List<Employee> employeeMaxSalaryList(@RequestParam Integer departmentId) {
        return departmentService.employeeMaxSalary(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public List<Employee> employeeMinSalaryList(@RequestParam Integer departmentId) {
        return departmentService.employeeMinSalary(departmentId);
    }

    @GetMapping(value = {"/departments/all", "/departments/all/{departmentId}"})
    public List<Employee> employeeAllDepartmentIdList(@PathVariable(required = false) String departmentId) {
        if (departmentId != null) {
            return departmentService.employeeAllDepartmentId(Integer.valueOf(departmentId));
        } else {
            return departmentService.allEmployeeByDepartments();
        }
    }
}