package com.codeyancy.cn.mapper;

import com.codeyancy.cn.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/12 19:19
 */
public interface EmployeeMapper {

    @Select("select * from employee")
    List<Employee> findAll();

    @Select("select * from employee where employee_id = #{id}")
    Employee findById(Long id);

    @Select("select * from employee where employee_email=#{email}")
    Employee findEmployeeByEmail(String email);

    @Insert("insert into employee (employee_name,employee_img,employee_email,employee_dept,employee_time) " +
            "values (#{employeeName},#{employeeImg},#{employeeEmail},#{employeeDept},#{employeeTime})")
    void add(Employee employee);

    @Update("update employee set employee_name=#{employeeName},employee_img=#{employeeImg}," +
            "employee_email=#{employeeEmail},employee_dept=#{employeeDept},employee_time=#{employeeTime} where employee_id=#{employeeId}")
    void update(Employee employee);

    @Delete("delete from employee where employee_id = #{id}")
    void delete(Long id);


}
