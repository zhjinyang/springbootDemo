package com.codeyancy.cn.controller;

import com.codeyancy.cn.entity.Employee;
import com.codeyancy.cn.service.EmployeeService;
import com.codeyancy.cn.utils.http.AxiosResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Zjy
 * @date 2021/4/12 19:59
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;




    @GetMapping
    public AxiosResult<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();
        return AxiosResult.success(employees);
    }

    @GetMapping("{id}")
    public AxiosResult<Employee> findById(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        return AxiosResult.success(employee);
    }

    @PostMapping
    public AxiosResult<Void> add(@RequestBody Employee employee) {
        employeeService.add(employee);
        return AxiosResult.success();
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Employee employee) {
        employeeService.update(employee);
        return AxiosResult.success();
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return AxiosResult.success();
    }


}
