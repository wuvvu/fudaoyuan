package cn.wuvvu.fudaoyuan.service;

import cn.wuvvu.fudaoyuan.mapper.AdminMapper;
import cn.wuvvu.fudaoyuan.model.Admin;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminService {

    private final AdminMapper adminMapper;

    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    private Admin admin;

    public Admin getAdminById(int id) {
        return adminMapper.getAdminById(id);
    }

    public int loginCheck(Admin adminInput, HttpSession httpSession) {
        /*String adminInputUsername;
        if(adminInput == null || (adminInputUsername = adminInput.getUsername()) == null || adminInputUsername.equals("")) {
            return 0;
        }
        Admin adminCheck = adminMapper.getAdminByUsername(adminInputUsername);
        if(adminCheck != null) {
            if(adminCheck.getPassword().equals(adminInput.getPassword())) {


                mav.setViewName("redirect:/newAdmin/index");
                //mav.addObject("admin", adminCheck);
                session.setAttribute("admin", adminCheck);
                this.admin = (Admin) session.getAttribute("admin");
            }
            else { //password not correct
                mav.setViewName("redirect:/admin/login");
            }
        }*/

        Admin adminCheck = adminMapper.getAdminByUsername(adminInput.getUsername());
        if (adminCheck == null) { // 用户不存在
            return -1;
        }
        if (!adminCheck.getPassword().equals(adminInput.getPassword())) { // 密码不正确
            return -2;
        }
        this.admin = adminCheck;
        httpSession.setAttribute("admin", this.admin);
        return 0;
    }

    public List<Admin> listAdmin() {
        return adminMapper.listAdmin();
    }

    public int addAdmin(Admin admin) {
        if(adminMapper.getAdminByUsername(admin.getUsername()) == null) {
            return adminMapper.addAdmin(admin);
        }
        return -1;
    }

    public int modifyAdmin(Admin admin) {
        return adminMapper.modifyAdmin(admin);
    }

    public int resetAdminPasswordById(int id) {
        Admin admin = getAdminById(id);
        if (admin == null) {
            return 0;
        }
        return adminMapper.resetAdminPassword(admin);
    }

    public int deleteAdminById(int id) {
        return adminMapper.deleteAdminById(id);
    }
}
