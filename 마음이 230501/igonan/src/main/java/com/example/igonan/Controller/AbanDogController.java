package com.example.igonan.Controller;

import com.example.igonan.Service.AbanDogService;
import com.example.igonan.dto.AbandogDTO;
import com.example.igonan.mindmapper.AbanDogmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class AbanDogController {

    @Autowired
    AbanDogmapper adm;

    private AbanDogService abanDogService;

    public AbanDogController(AbanDogService abanDogService) {
        this.abanDogService = abanDogService;
    }

    @GetMapping("/dogs")
    public List<AbandogDTO> AllDogs() {
        return abanDogService.getAbanDogList();

    }

    @GetMapping("/dog")
    public List<AbandogDTO> oneDog() {
        String dogname = "아롱이";
        return abanDogService.getOneDog(dogname);

    }

    // 유기견 전체 리스트 출력
    @RequestMapping(value = "/doglist", method = {RequestMethod.POST}) //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody // 자바 객체를 HTTP 응답 본문의 객체로 변환
    public Object abandoglist() {
        //유기견의 전체 리스트를 db에서 가져온다
        List<AbandogDTO> list = abanDogService.getAbanDogList(); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }

    // 특정 유기견의 데이터만 출력 (유기견의 이름으로 검색하여 출력)
/*
    @GetMapping("/abandog/detail") //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody
    public List<AbandogDTO> abandogone(@RequestParam String dogname) { // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능

        List<AbandogDTO> list = abanDogService.getOneDog(dogname); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }
*/
/*
    @ResponseBody
    @RequestMapping(value = "/abandog/detail", method = { RequestMethod.POST }) //데이터가 보내지는 주소와 메소드 설정
    public Object abandogone() { // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
        //유기견의 이름으로 검색하여 db에서 데이터를 찾아옴
        String dogname = "아롱이";
        // 웹에서 보내진 파라미터 값을 변수에 저장 여기선 임시로 '아롱이'로 설정
        List<AbandogDTO> list = abanDogService.getOneDog(dogname); // List에 select 결과 list를 담음

        return list;
    }
*/

    @ResponseBody
    @RequestMapping(value = "/abandog/detail/{param}", method = { RequestMethod.GET }) //데이터가 보내지는 주소와 메소드 설정
    public Object abandogone(@PathVariable("param")String parameter){ // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
        //유기견의 이름으로 검색하여 db에서 데이터를 찾아옴

        List<AbandogDTO> list = abanDogService.getOneDog(parameter); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }


/*
 @ResponseBody
 @RequestMapping("/sample/path/{param}")
 public String samplePath(@PathVariable("param")String parameter){

        return "Request Path Parameter : "+parameter;
        }*/

/*
    @RequestMapping(value = "/abandog/detail", method = { RequestMethod.POST }) //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody
    public List<AbandogDTO> abandogone(@RequestParam("dogname") String dogname)throws IOException { // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
        //유기견의 이름으로 검색하여 db에서 데이터를 찾아옴
        List<AbandogDTO> list = abanDogService.getOneDog(dogname);

        return list; // Ajax로 넘겨줄 select 결과값


*/


}