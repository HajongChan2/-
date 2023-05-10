package com.example.igonan.mindmapper;

import com.example.igonan.dto.AbandogDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Mapper
@Transactional
public interface AbanDogmapper {

    @Select("select * from ad_dog;")
    List<AbandogDTO> abanDogList();
    // 모든 유기견의 정보를 List에 담음

    @Select("select * from ad_dog ad where ad.ad_name = #{dogname} ;")
    List<AbandogDTO> findOneDog(String dogname);
    // 특정 유기견의 정보를 List에 담음

    Integer mindAbanDogInsert(String name,int age, String area,
                              String sex,String size,String spec,String vac,String neut,
                              String dead,String memo,String gallery);

    @Select("select * from ad_dog order by ad_dead;")
    List<AbandogDTO> mainAbandogList();
}

