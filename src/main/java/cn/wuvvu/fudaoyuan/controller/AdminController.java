package cn.wuvvu.fudaoyuan.controller;

import cn.wuvvu.fudaoyuan.model.Admin;
import cn.wuvvu.fudaoyuan.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

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

    @PostMapping("/loginCheck")
    @ResponseBody
    public int loginCheck(Admin adminInput, HttpSession httpSession) {
        return adminService.loginCheck(adminInput, httpSession);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        Enumeration em = session.getAttributeNames();
        while(em.hasMoreElements()) {
            session.removeAttribute(em.nextElement().toString());
        }
        return "redirect:/admin/login";
    }

    @RequestMapping("/main")
    public String main() {
        return "admin/main";
    }

    @RequestMapping("/listAdmin")
    public ModelAndView listAdmin() {
        ModelAndView mav = new ModelAndView("admin/admin/list");
        mav.addObject("adminList", adminService.listAdmin());
        return mav;
    }

    @GetMapping("/addAdmin")
    public String addAdmin() {
        return "admin/admin/add";
    }

    @PostMapping("/addAdmin")
    @ResponseBody
    public int addAdmin(Admin admin) {
        return adminService.addAdmin(admin);
    }

    @GetMapping("/modifyAdmin")
    public ModelAndView modifyAdmin(@RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView();
        Admin admin = adminService.getAdminById(id);
        if (admin == null) {
            mav.setViewName("redirect:/admin/listAdmin");
            return mav;
        }
        mav.setViewName("admin/admin/modify");
        mav.addObject("admin", admin);
        return mav;
    }

    @PostMapping("/modifyAdmin")
    @ResponseBody
    public int modifyAdmin(Admin admin) {
        return adminService.modifyAdmin(admin);
    }

    @PostMapping("/resetAdminPassword")
    @ResponseBody
    public int resetAdminPassword(@RequestParam("id") int id) {
        return adminService.resetAdminPasswordById(id);
    }

    @PostMapping("/deleteAdmin")
    @ResponseBody
    public int deleteAdmin(@RequestParam("id") int id) {
        return adminService.deleteAdminById(id);
    }




}
