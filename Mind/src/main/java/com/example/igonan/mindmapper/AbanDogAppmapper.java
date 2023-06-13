package com.example.igonan.mindmapper;

import com.example.igonan.dto.AbandogAppDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface AbanDogAppmapper {

    @Select("select * from abandog_app a where a.num = #{appuserid};")
    List<AbandogAppDTO> abanDogAppList(String appuserid);
    // 모든 유기견의 정보를 List에 담음

}

