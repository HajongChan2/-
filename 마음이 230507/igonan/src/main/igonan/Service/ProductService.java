package com.example.igonan.Service;


import com.example.igonan.dto.PetdogDTO;
import com.example.igonan.dto.ProductDTO;
import com.example.igonan.mindmapper.Productmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    Productmapper productmapper;


    public List<ProductDTO> getProductList() { // DB에서 조회된 모든 유기견의 정보를 리턴하는 getAbanDogList
        List<ProductDTO> ProductList = productmapper.productList();// 모든 유기견의 정보를 List abanDogList에 담음
        return ProductList;// abanDogList 를 리턴하여 데이터 전달

    }

    public List<ProductDTO> getOneProduct(String productName) { // DB에서 조회된 특정 유기견의 정보를 리턴하는 getOneDog
        List<ProductDTO> oneProduct = productmapper.findOneProduct(productName);// 특정 유기견의 정보를 List oneDog에 담음
        return oneProduct; // oneDog 를 리턴하여 데이터 전달
    }


    public List<ProductDTO> getOnProductType(int prtype) { // DB에서 조회된 특정 유기견의 정보를 리턴하는 getOneDog
        List<ProductDTO> productType = productmapper.findOneType(prtype);// 특정 유기견의 정보를 List oneDog에 담음
        return productType; // oneDog 를 리턴하여 데이터 전달
    }

    public List<ProductDTO> getMainProductList() { // DB에서 조회된 모든 유기견의 정보를 리턴하는 getAbanDogList
        List<ProductDTO> ProductList = productmapper.mainProductList();// 모든 유기견의 정보를 List abanDogList에 담음
        return ProductList;// abanDogList 를 리턴하여 데이터 전달

    }
}
