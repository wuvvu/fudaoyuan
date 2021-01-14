package cn.wuvvu.fudaoyuan.service;

import cn.wuvvu.fudaoyuan.mapper.AdminMapper;
import cn.wuvvu.fudaoyuan.model.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminMapper adminMapper;

    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public void loginCheck(Admin adminInput) {
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


    }


}
