package cn.wuvvu.fudaoyuan.mapper;

import cn.wuvvu.fudaoyuan.model.Admin;
import cn.wuvvu.fudaoyuan.model.Student;
import cn.wuvvu.fudaoyuan.model.Teacher;
import cn.wuvvu.fudaoyuan.model.Team;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {

    Admin getAdminById(int id);

    Admin getAdminByUsername(String username);

    List<Teacher> listTeacher();

    Teacher getTeacherById(int id);

    Teacher getTeacherByCode(String code);

    List<Team> listTeam();

    Team getTeamById(int id);

    Team getTeamByName(String name);

    List<Student> listStudent();

    Student getStudentById(int id);

    Student getStudentByCode(String code);
}
