package com.rdr.blog.hexagonal_architecture_java.port;

import com.rdr.blog.hexagonal_architecture_java.domain.Employee;

public interface EmployeeRepositoryPort {
  void create(String name, String role, long salary);

  Employee getEmployee(Integer userId);
}
