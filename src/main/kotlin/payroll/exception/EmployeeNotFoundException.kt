package payroll.exception

class EmployeeNotFoundException(id: Long) : RuntimeException("Could not find employee $id")