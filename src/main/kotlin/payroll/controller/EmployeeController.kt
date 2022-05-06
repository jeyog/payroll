package payroll.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import payroll.dto.EmployeeDTO
import payroll.service.EmployeeService

@RestController
@RequestMapping("employees")
class EmployeeController(
        val employeeService: EmployeeService
) {
    @GetMapping
    fun all(): List<EmployeeDTO> {
        return employeeService.all()
    }

    @PostMapping
    fun newEmployee(@RequestBody newEmployeeDTO: EmployeeDTO): EmployeeDTO {
        return employeeService.newEmployee(newEmployeeDTO)
    }

    @GetMapping("{id}")
    fun one(@PathVariable id: Long): EmployeeDTO {
        return employeeService.one(id)
    }

    @PutMapping("{id}")
    fun replaceEmployee(@PathVariable id: Long, @RequestBody newEmployeeDTO: EmployeeDTO): EmployeeDTO {
        return employeeService.replaceEmployee(id, newEmployeeDTO)
    }

    @DeleteMapping("{id}")
    fun deleteEmployee(@PathVariable id: Long) {
        employeeService.deleteEmployee(id)
    }
}