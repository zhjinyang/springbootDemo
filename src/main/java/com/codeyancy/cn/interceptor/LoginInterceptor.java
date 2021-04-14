package com.codeyancy.cn.interceptor;

import com.codeyancy.cn.utils.exception.LoginException;
import com.codeyancy.cn.utils.http.EnumStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Zjy
 * @date 2021/4/13 11:37
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object employee = request.getSession().getAttribute("employee");
        if (employee == null) {
            throw new LoginException(EnumStatus.NO_LOGIN);
//            response.sendRedirect("login.html");
        }
        return true;
    }
}
