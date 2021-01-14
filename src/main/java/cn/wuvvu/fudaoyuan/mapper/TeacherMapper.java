package cn.wuvvu.fudaoyuan.mapper;

import cn.wuvvu.fudaoyuan.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper {

    Teacher findTeacherById(int id);

    Teacher findTeacherByCode(String code);
}
