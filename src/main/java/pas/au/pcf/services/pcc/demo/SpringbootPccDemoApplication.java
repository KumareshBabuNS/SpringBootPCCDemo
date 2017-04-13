package pas.au.pcf.services.pcc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import pas.au.pcf.services.pcc.demo.domain.Employee;
import pas.au.pcf.services.pcc.demo.repo.EmployeeRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableGemfireRepositories(basePackageClasses = pas.au.pcf.services.pcc.demo.repo.EmployeeRepository.class)
public class SpringbootPccDemoApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPccDemoApplication.class, args);
	}

	/*
	@PostConstruct
	public void init()
	{
		employeeRepository.save(new Employee("1", "pas", "apicella"));
		employeeRepository.save(new Employee("2", "lucia", "apicella"));
		employeeRepository.save(new Employee("3", "lucas", "apicella"));
		employeeRepository.save(new Employee("4", "siena", "apicella"));
	}
	*/
}
