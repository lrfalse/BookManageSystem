package com.sdxmxy.bookmanage.controller;

import com.sdxmxy.bookmanage.config.LoginRequire;
import com.sdxmxy.bookmanage.entity.Admin;
import com.sdxmxy.bookmanage.service.AdminService;
import com.sdxmxy.bookmanage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @LoginRequire(autoRedirect = true)
    @RequestMapping("admin_main")
    public String admin_main(){
        return "admin_main";
    }

    @LoginRequire(autoRedirect = false)
    @ResponseBody
    @RequestMapping("api/loginCheck")
    public R loginCheck(Admin admin, HttpSession session){
        if(admin==null){
            return R.error().message("用户不存在");
        }
        Admin byId = adminService.getById(admin.getId());
        if(byId==null){
            return R.error().message("密码错误");
        }
        session.setAttribute("adminId",byId.getId());
        session.setAttribute("nickName",byId.getNickName());
        return R.ok();
    }

    @LoginRequire(autoRedirect = true)
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("adminId");
        return "index";
    }
}
