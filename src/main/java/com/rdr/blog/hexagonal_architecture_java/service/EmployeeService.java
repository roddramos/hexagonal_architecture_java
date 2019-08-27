package com.rdr.blog.hexagonal_architecture_java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdr.blog.hexagonal_architecture_java.domain.Employee;
import com.rdr.blog.hexagonal_architecture_java.port.EmployeeRepositoryPort;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepositoryPort employeeRepository;

  public void create(String name, String role, long salary) {
    employeeRepository.create(name, role, salary);
  }

  public Employee view(Integer userId) {
    return employeeRepository.getEmployee(userId);
  }
}
