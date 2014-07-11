package com.springapp.mvc;

import com.springapp.model.Employee;
import com.springapp.util.EmpRestURIConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

    @RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
    public
    @ResponseBody
    Employee getDummyEmployee() {
        LOGGER.info("Start getDummyEmployee");
        Employee emp = new Employee();
        emp.setId(9999);
        emp.setName("Dummy");
        emp.setCreatedDate(new Date());
        empData.put(9999, emp);
        return emp;
    }

    @RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
    public
    @ResponseBody
    Employee getEmployee(@PathVariable("id") int empId) {
        LOGGER.info("GetEmployee. ID : " + empId);

        return empData.get(empId);
    }

    @RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
    public
    @ResponseBody
    List<Employee> getAllEmployees() {
        LOGGER.info("Start getAllEmployees!");
        LOGGER.info("Start getAllEmployees!");
        List<Employee> employees = new ArrayList<Employee>();
        Set<Integer> empIdKeys = empData.keySet();
        for (Integer i : empIdKeys) {
            employees.add(empData.get(i));
        }
        return employees;
    }

    @RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
    public
    @ResponseBody
    Employee createEmployee(@RequestBody Employee emp) {
        LOGGER.info("CreateEmployee!");
        emp.setCreatedDate(new Date());
        empData.put(emp.getId(), emp);
        return emp;
    }

    @RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
    public
    @ResponseBody
    Employee deleteEmployee(@PathVariable("id") int empId) {
        LOGGER.info("DeleteEmployee!");
        Employee emp = empData.get(empId);
        empData.remove(empId);
        return emp;
    }

}
