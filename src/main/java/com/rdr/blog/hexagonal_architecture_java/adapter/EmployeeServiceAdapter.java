package com.rdr.blog.hexagonal_architecture_java.adapter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rdr.blog.hexagonal_architecture_java.domain.Employee;
import com.rdr.blog.hexagonal_architecture_java.port.EmployeeRepositoryPort;

@Service
public class EmployeeServiceAdapter implements EmployeeRepositoryPort {
  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  @Override
  public void create(String name, String role, long salary) {
    Employee employee = new Employee();
    employee.setName(name);
    employee.setRole(role);
    employee.setSalary(salary);

    entityManager.persist(employee);
  }

  @Override
  public Employee getEmployee(Integer userId) {
    return entityManager.find(Employee.class, userId);
  }
}
