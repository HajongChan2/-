package com.example.igonan.mindmapper;
import com.example.igonan.dto.UserDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface Usermapper {


    @Select("select * from user;")
    List<UserDTO> userlist();
    // 모든 애완견의 정보를 List에 담음

    @Select("select * from user u where u.id = #{userid} ;")
    List<UserDTO> OneUser(String userid);
}
