package pas.au.pcf.services.pcc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pas.au.pcf.services.pcc.demo.repo.EmployeeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class EmployeeController
{
    private static Log logger = LogFactory.getLog(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) throws Exception
    {
        logger.info("Invoking Employee Controller to get all employees from PCC service...");

        model.addAttribute("employees", employeeRepository.findAll());

        return "employees";
    }

}
