package cn.wuvvu.fudaoyuan.controller;

import cn.wuvvu.fudaoyuan.model.Admin;
import cn.wuvvu.fudaoyuan.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(Admin adminInput, HttpSession session) {
        ModelAndView mav = new ModelAndView("redirect:/admin/login");
        return mav;
    }



}
