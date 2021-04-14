package com.codeyancy.cn.service;

import com.codeyancy.cn.entity.Employee;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/12 19:57
 */
public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Long id);

    void add(Employee employee);

    void update(Employee employee);

    void delete(Long id);

    Employee findEmployeeByEmail(String email);

}
