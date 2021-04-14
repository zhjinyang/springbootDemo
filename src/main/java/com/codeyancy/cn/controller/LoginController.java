package com.codeyancy.cn.controller;

import com.codeyancy.cn.entity.Employee;
import com.codeyancy.cn.service.EmployeeService;
import com.codeyancy.cn.utils.EmailService;
import com.codeyancy.cn.utils.http.AxiosResult;
import com.codeyancy.cn.utils.http.EnumStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Zjy
 * @date 2021/4/13 9:42
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //获取邮箱验证码
    @GetMapping("getEmailCode")
    public AxiosResult<String> getCode(String email) {
        //根据邮箱查询用户是否存在
        Employee employee = employeeService.findEmployeeByEmail(email);
        //生成6位验证码
        String code = UUID.randomUUID().toString().substring(0, 6);

        if (!StringUtils.isEmpty(employee)) {
            //如果存在这个员工，返回邮箱验证码
            emailService.sendMail(email,code);
            //验证码存入redis  2分钟有效
            stringRedisTemplate.opsForValue().set(email,code,2, TimeUnit.MINUTES);

            return AxiosResult.success(code);
        }
        //员工不存在
        System.out.println("员工不存在");
        return AxiosResult.error(EnumStatus.NO_EMPLOYEE);
    }

    //登录
    @PostMapping("doLogin")
    public AxiosResult<String> doLogin(HttpSession httpSession,String email, String code){
            //如果员工存在，查看Redis是否存在，员工邮箱
            if(stringRedisTemplate.hasKey(email)){
                String redisCode = stringRedisTemplate.opsForValue().get(email);
                if(redisCode.equals(code)){
                    //成功
                    Employee employee = employeeService.findEmployeeByEmail(email);
                    //把用户信息存入session
                    httpSession.setAttribute("employee",employee);
                    return AxiosResult.success(EnumStatus.OK);
                }else {
                    //验证码不匹配
                    return AxiosResult.error(EnumStatus.CODE_ERROR);
                }
            }
            //redis不存在这个邮箱，验证码过时了
            return AxiosResult.error(EnumStatus.CODE_TIMEOUT);
        }



}
