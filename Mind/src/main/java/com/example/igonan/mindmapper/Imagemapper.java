package com.example.igonan.mindmapper;

import com.example.igonan.dto.AbandogDTO;
import com.example.igonan.dto.ImageDTO;
import com.example.igonan.dto.PaymentDTO;
import com.example.igonan.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
@Mapper
@Transactional
public interface Imagemapper {

    @Select("select * from abandog_image where f_num = #{dogNumber};")
    List<ImageDTO> abandogImageReturn(int dogNumber);

    @Select("select * from product_image where f_num = #{productNumber};")
    List<ImageDTO> productImageReturn(int productNumber);

    @Select("select * from pet_image where f_num = #{dogNumber};")
    List<ImageDTO> petDogImageReturn(int dogNumber);





}
