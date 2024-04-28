package net.shreya.emsbackend.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.shreya.emsbackend.dto.EmployeeDto;
import net.shreya.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //Build ADD Employee Rest API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build GET Employee Rest API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeId(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    //Build Get ALL Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return  ResponseEntity.ok(employees);
    }

    //Build update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Build Delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")  Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("employee deleted successfully");
    }

}
