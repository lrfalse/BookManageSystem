package com.sdxmxy.bookmanage.controller;

import com.sdxmxy.bookmanage.entity.Admin;
import com.sdxmxy.bookmanage.service.AdminService;
import com.sdxmxy.bookmanage.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class PassportController {

    @Value("${token.key}")
    private String key;

    @Autowired
    private AdminService adminService;

    @RequestMapping("reindex")
    public String reindex(HttpServletRequest request){
        String originUrl = request.getParameter("originUrl");
        request.setAttribute("originUrl",originUrl);
        return "index";
    }

    /*
        userInfo :前提 页面的name 名称必须跟实体类的属性名保存一致！
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(Admin admin, HttpServletRequest request){
        /*
            String key = "ATGUIGU";
            String salt = "192.168.100.1"; 做为服务器的Ip地址
         */
        String salt = "192.168.100.1"; // 192.168.100.1
        // 判断
        if (admin!=null){
            Admin byId = adminService.getById(admin.getId());
            if (byId!=null){
                // 制作token！
                HashMap<String, Object> map = new HashMap<>();
                map.put("adminId",byId.getId());

                String token = JwtUtil.encode(key, map, salt);
                System.out.println("newToken:"+token);
                return token; // token
            }else {
                return "fail";
            }
        }
        return "fail";
    }

    // 用户认证！在控制器verify?token=xxx&currentIp=salt
    @RequestMapping("verify")
    @ResponseBody
    public String verify(HttpServletRequest request){
        // 认证需要得到 服务器ip 地址  salt，还需要得到 token
        String token = request.getParameter("token");
        String currentIp = request.getParameter("currentIp");
        // 准备解密操作
        Map<String, Object> map = JwtUtil.decode(token, key, currentIp);
        if (map!=null && map.size()>0){
            // 利用String  userId = map.get("userId")
            String adminId = (String) map.get("adminId");
            //  跟session 做比较
            HttpSession session = request.getSession();
            Admin adminIdSession = (Admin) session.getAttribute(adminId);
            if (adminIdSession!=null){
                return "success";
            }else {
                return "fail";
            }
        }
        return "fail";

    }


}
