package cn.wuvvu.fudaoyuan.mapper;

import cn.wuvvu.fudaoyuan.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper {

    Student findStudentById(int id);

    Student findStudentByCode(String code);
}
