package com.codeyancy.cn.service.impl;

import com.codeyancy.cn.entity.Employee;
import com.codeyancy.cn.mapper.EmployeeMapper;
import com.codeyancy.cn.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/12 19:58
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeMapper.findById(id);
    }

    @Override
    public void add(Employee employee) {
        employeeMapper.add(employee);

    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);

    }

    @Override
    public void delete(Long id) {
        employeeMapper.delete(id);

    }

    /**
     * 根据员工邮箱查询员工
     * @param email
     * @return
     */
    @Override
    public Employee findEmployeeByEmail(String email) {
        Employee employee = employeeMapper.findEmployeeByEmail(email);
        if(!StringUtils.isEmpty(employee)){
            return employee;
        }
        return null;
    }
}
