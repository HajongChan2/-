package com.example.igonan.mindmapper;

import com.example.igonan.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface Productmapper {


    @Select("select * from product;")
    List<ProductDTO> productList();
    // 모든 상품의 정보를 List에 담음

    @Select("select * from product pr where pr.pr_name = #{productName} ;")
    List<ProductDTO> findOneProduct(String productName);
    // 특정 상품의 정보를 List에 담음

    @Select("select * from product pr where pr.pr_type = #{productType} ;")
    List<ProductDTO> findOneType(int productType);

}
