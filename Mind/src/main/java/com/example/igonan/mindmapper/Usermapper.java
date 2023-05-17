package com.example.igonan.mindmapper;
import com.example.igonan.dto.UserDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface Usermapper {


    @Select("select * from users;")
    List<UserDTO> userlist();
    // 모든 애완견의 정보를 List에 담음

    @Select("select * from users u where u.id = #{userid} ;")
    List<UserDTO> OneUser(String userid);

    Integer mindjoinUserInsert(String name,String id,String pw, String phone,String addr, String saddr);

}
