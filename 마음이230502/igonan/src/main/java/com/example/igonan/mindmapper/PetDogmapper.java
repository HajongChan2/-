package com.example.igonan.mindmapper;

import com.example.igonan.dto.PetdogDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface PetDogmapper {


    @Select("select * from pd_dog;")
    List<PetdogDTO> PetDogList();
    // 모든 애완견의 정보를 List에 담음

    @Select("select * from pd_dog pd where pd.pd_name = #{dogname} ;")
    List<PetdogDTO> findOnePet(String dogname);
    // 특정 애완견의 정보를 List에 담음

   /* Integer mindAbanDogInsert(String name,int age, String area,
                              String sex,String size,String spec,String vac,String neut,
                              String dead,String memo,String gallery);
                              */

}

