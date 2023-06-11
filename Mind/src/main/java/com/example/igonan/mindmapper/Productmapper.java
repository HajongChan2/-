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

    @Select("select * from product pr where pr.pr_num = #{productNum} ;")
    List<ProductDTO> findOneProduct(int productNum);
    // 특정 상품의 정보를 List에 담음

    @Select("select * from product pr where pr.pr_name = #{productName} ;")
    List<ProductDTO> findOneProductName(String productName);

    @Select("select * from product pr where pr.pr_type = #{productType} ;")
    List<ProductDTO> findOneType(int productType);

    @Select("select * from product order by pr_count asc limit 6;")
    List<ProductDTO> mainProductList();

    @Select("select * from product pr where pr.pr_name=#{productName} order by pr.pr_num desc limit 1;")
    ProductDTO productImageWireNumberReturn(String productName);


    Integer mindProductInsert(String name,int price,int count,String memo,int dpay,int type,String gall,String seller,String content);

    Integer mindProductImageInsert(int num,String imgsrc);


    @Select("select * from product pr where pr.pr_name = #{productName} ;")
    ProductDTO findOneProductNameass(String productName);
}
