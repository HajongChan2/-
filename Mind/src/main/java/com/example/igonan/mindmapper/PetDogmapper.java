package com.example.igonan.mindmapper;

import com.example.igonan.dto.PetdogDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
@Transactional
public interface PetDogmapper {


    @Select("select * from pet_dog;")
    List<PetdogDTO> PetDogList();
    // 모든 애완견의 정보를 List에 담음

    @Select("select * from pet_dog pd where pd.pet_num = #{dognum} ;")
    List<PetdogDTO> findOnePet(int dognum);
    // 특정 애완견의 정보를 List에 담음

    @Select("select * from pet_dog order by pet_num desc limit 1;")
    PetdogDTO findOnePetNumber();
   /* Integer mindAbanDogInsert(String name,int age, String area,
                              String sex,String size,String spec,String vac,String neut,
                              String dead,String memo,String gallery);
                              */
   Integer mindAbanDogChangePetDogInsert(String name, int age, LocalDate idate,
                                         String sex, String size, String spec, String vac, String neut,
                                         String memo,String gall);
    Integer mindPetImageInsert(int num,String img_src);




}

