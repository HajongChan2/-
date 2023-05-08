package com.example.igonan.Controller;


import com.example.igonan.Service.PetDogService;
import com.example.igonan.Service.ProductService;
import com.example.igonan.dto.PetdogDTO;
import com.example.igonan.dto.ProductDTO;
import com.example.igonan.mindmapper.PetDogmapper;
import com.example.igonan.mindmapper.Productmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {



    @Autowired
    Productmapper productmapper;

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // 상품 전체 리스트 출력
    @RequestMapping(value = "/productlist", method = { RequestMethod.POST }) //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody // 자바 객체를 HTTP 응답 본문의 객체로 변환
    public Object productList(){
        //상품의 전체 리스트를 db에서 가져온다
        List<ProductDTO> list = productService.getProductList();// List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }
/*
    // 특정 상품의 데이터만 출력 (상품의 이름으로 검색하여 출력)
    @RequestMapping(value = "/oneproduct") //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody
    public Object productOne(@RequestParam("productname") String productName)throws IOException { // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
        //상품의 이름으로 검색하여 db에서 데이터를 찾아옴
        // 웹에서 보내진 파라미터 값을 변수에 저장 여기선 임시로 '군번줄'로 설정
        List<ProductDTO> list = productService.getOneProduct(productName); // List에 select 결과 list를 담음

        return list; // Ajax    로 넘겨줄 select 결과값

    }
*/
    @ResponseBody
    @RequestMapping(value = "/product/detail/{param}", method = { RequestMethod.GET }) //데이터가 보내지는 주소와 메소드 설정
    public Object productOne(@PathVariable("param")String parameter){

        List<ProductDTO> list = productService.getOneProduct(parameter); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }

    @RequestMapping(value = "/petcesary/{productType}") //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody
    public Object productType(@PathVariable String productType)throws IOException { // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
        //상품의 이름으로 검색하여 db에서 데이터를 찾아옴
        // 웹에서 보내진 파라미터 값을 변수에 저장 여기선 임시로 '군번줄'로 설정
        int prType = 1;

        switch (productType){
            case "tag":
                prType = 1;
                //Integer.parseInt(productType);
                break;

            case "chip" :
                prType = 2;
                break;

            case "etc" :
                prType = 3;
                break;
        }
        List<ProductDTO> list = productService.getOnProductType(prType); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }
    /*

     @RequestMapping("/product/detail") //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody
    public List<ProductDTO> getOneProduct(@RequestParam("name") String name)throws IOException {
        //상품의 이름으로 검색하여 db에서 데이터를 찾아옴
        List<ProductDTO> list = petDogService.getOneProduct(name);

        return list; // Ajax로 넘겨줄 select 결과값

    }



     */

}
