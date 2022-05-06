package payroll.entity

import payroll.dto.EmployeeDTO
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Employee(
        @Id @GeneratedValue val id: Long? = null,
        val name: String,
        val role: String
) {
    constructor(employeeDTO: EmployeeDTO) : this(name = employeeDTO.name, role = employeeDTO.role)
}