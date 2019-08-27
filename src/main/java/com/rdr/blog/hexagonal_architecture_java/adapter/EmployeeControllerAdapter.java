package com.rdr.blog.hexagonal_architecture_java.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rdr.blog.hexagonal_architecture_java.domain.Employee;
import com.rdr.blog.hexagonal_architecture_java.port.EmployeeUIPort;
import com.rdr.blog.hexagonal_architecture_java.service.EmployeeService;

@RestController
@RequestMapping("/employees/")
public class EmployeeControllerAdapter implements EmployeeUIPort {
  @Autowired
  private EmployeeService employeeService;

  @Override
  public void create(@RequestBody Employee request) {
    employeeService.create(request.getName(), request.getRole(), request.getSalary());
  }

  @Override
  public Employee view(@PathVariable Integer id) {
    Employee employee = employeeService.view(id);
    return employee;
  }
}
