package payroll.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import payroll.entity.Employee
import payroll.repository.EmployeeRepository

@Configuration
class LoadDatabase(
        val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)
) {
    @Bean
    fun initDatabase(repository: EmployeeRepository) = CommandLineRunner {
        log.info("Preloading " + repository.save(Employee(
                name = "Bilbo Baggins",
                role = "burglar"
        )))
        log.info("Preloading " + repository.save(Employee(
                name = "Frodo Baggins",
                role = "thief"
        )))
    }
}