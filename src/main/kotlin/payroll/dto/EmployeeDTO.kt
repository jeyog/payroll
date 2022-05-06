package payroll.dto

import payroll.entity.Employee

data class EmployeeDTO(
        var id: Long,
        var name: String,
        var role: String
) {
    constructor(employee: Employee) : this(employee.id!!, employee.name, employee.role)
}