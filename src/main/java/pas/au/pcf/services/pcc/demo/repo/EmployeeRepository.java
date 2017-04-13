package pas.au.pcf.services.pcc.demo.repo;

import org.springframework.data.gemfire.repository.GemfireRepository;
import pas.au.pcf.services.pcc.demo.domain.Employee;

/**
 * Created by pasapicella on 4/13/17.
 */
public interface EmployeeRepository extends GemfireRepository<Employee, String>
{
}
