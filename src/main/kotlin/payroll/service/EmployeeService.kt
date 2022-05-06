package payroll.service

import org.springframework.stereotype.Service
import payroll.dto.EmployeeDTO
import payroll.entity.Employee
import payroll.exception.EmployeeNotFoundException
import payroll.repository.EmployeeRepository

@Service
class EmployeeService(
        val employeeRepository: EmployeeRepository
) {
    fun newEmployee(newEmployee: EmployeeDTO): EmployeeDTO {
        var employee = Employee(newEmployee)
        employee = employeeRepository.save(employee)
        return EmployeeDTO(employee)
    }

    fun all(): List<EmployeeDTO> {
        return employeeRepository.findAll().map { employee -> EmployeeDTO(employee) }
    }

    fun one(id: Long): EmployeeDTO {
        val employee = employeeRepository.findById(id).orElseThrow {
            throw EmployeeNotFoundException(id)
        }
        return EmployeeDTO(employee)
    }

    fun replaceEmployee(id: Long, newEmployee: EmployeeDTO): EmployeeDTO {
        var employee = Employee(id, newEmployee.name, newEmployee.role)
        employee = employeeRepository.save(employee)
        return EmployeeDTO(employee)
    }

    fun deleteEmployee(id: Long) {
        employeeRepository.deleteById(id)
    }
}