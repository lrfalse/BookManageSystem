package com.sdxmxy.bookmanage.config;

import com.sdxmxy.bookmanage.utils.CookieUtil;
import com.sdxmxy.bookmanage.utils.HttpClientUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

// 做拦截器！
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    // 进入控制器之前执行！
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        String adminId = (String) session.getAttribute("adminId");
        if(!StringUtils.isEmpty(adminId)){
           return true;
        }else {
            // 在拦截器中获取类上的自定义注解
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            LoginRequire methodAnnotation = handlerMethod.getMethodAnnotation(LoginRequire.class);
            if (methodAnnotation != null) {
                // 认证失败！需要登录则跳转到登录页面
                if (methodAnnotation.autoRedirect()) {
                    // 必须登录 autoRedirect = true; 获取当前的url
                    String requestURL = request.getRequestURL().toString();
                    String encodeURL = URLEncoder.encode(requestURL, "UTF-8");
                    // 远程调用登录控制器 {}
                    // String url = HttpClientUtil.doGet(WebConst.LOGIN_ADDRESS + "?originUrl=" + encodeURL);
//                    System.out.println(url);
                    // 将页面信息重定向到页面
                    response.sendRedirect("http://localhost:8081/index?originUrl=" + encodeURL);
                    return true;
                }
            }else{
                return true;
            }
        }
        return true;
    }
}