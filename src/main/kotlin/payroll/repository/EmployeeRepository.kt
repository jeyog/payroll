package payroll.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import payroll.entity.Employee

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long> {
}