package com.example.igonan.Controller;

import com.example.igonan.Service.UserService;
import com.example.igonan.dto.UserDTO;
import com.example.igonan.mindmapper.Usermapper;
import com.example.igonan.util.loggedInSession;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class userController {

    @Autowired
    Usermapper usermapper;

    private UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/idcheck")
    @ResponseBody
    public Object malware(HttpServletRequest rq) {

        String id = rq.getParameter("id");
        //String id = "zxc";
        List<UserDTO> list = userService.getOneUser(id);
        if (list.isEmpty()) {
            System.out.println("사용 가능한 아이디 ");

            return null;
        }
        return list;
    }

    @RequestMapping(value = "/loginsuccess")
    @ResponseBody
    public loggedInSession logedin(HttpServletRequest rq, HttpSession hs) {
        String userid = rq.getParameter("id");
      loggedInSession resultname = (userService.loginUser(userid));
        //hs.setattribute("username",resultname);
        System.out.println(resultname.getName());

        return resultname;
    }
/*
    @RequestMapping(value = "/loginsuccess")
    @ResponseBody
    public loggedInSession logedin(HttpServletRequest rq, HttpSession hs) {
        String userid = rq.getParameter("id");
      loggedInSession resultname = (userService.loginUser(userid));
        //hs.setattribute("username",resultname);
        System.out.println(resultname.getName());

        return resultname;
    }



 */

    @ResponseBody
    @RequestMapping(value = "/userlist") //데이터가 보내지는 주소와 메소드 설정
    public Object joinuserlist() { // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
        //유기견의 이름으로 검색하여 db에서 데이터를 찾아옴

        List<UserDTO> list = userService.getUsersList(); // List에 select 결과 list를 담음


        return list; // Ajax로 넘겨줄 select 결과값

    }
}
/*
@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;


   // @return null 로그인 실패

public Member login(String loginId, String password) {
    return memberRepository.findByLoginId(loginId)
            .filter(m -> m.getPassword().equals(password))
            .orElse(null);
}
}
// 로그인의 핵심 비즈니스 로직은 회원을 조회한 다음에 파라미터로 넘어온 password와 비교해서, 같으면 회원을 반환하고, 다르면 null을 반환한다!

 */
/*



StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
{
   "result":[
      {
         "searchView":{
            "divFlag":"ARTICLE",
            "lodID":"4740152",
            "title":"기후변화 시나리오에 의한 외래식물 실망초(Conyza bonariensis)의 서식지 분포 예측",
            "author":[
               "이**",
               "오**",
               "홍**",
               "나**",
               "나**",
               "김**",
               "손**"
            ],
            "journalName":"한국기후변화학회지",
            "orgName":"한국기후변화학회",
            "pubYear":"2015",
            "uci":"G901:A-0003859654",
            "doi":null,
            "lang":"kor",
            "keyword":[
               "Invasive Alien Plant",
               "Conyza bonariensis",
               "Climate Change",
               "MaxEnt"
            ],
            "abst":"This study was conducted to predict the changes of potential distribution for invasive alien plant, Conyza bonariensis in Korea. C. bonariensis was found in southern Korea (Jeju, south coast, southwest coast). The habitats of C. bonariensis were roadside, bare ground, farm area, and pasture, where the interference by human was severe. Due to the seed characteristics of Compositae, C. bonariensis take long scattering distance and it will easily spread by movement of wind, vehicles and people. C. canadensis in same Conyza genus has already spread on a national scale and it is difficult to manage. We used maximum entropy modeling (MaxEnt) for analyzing the environmental influences on C.\nbonariensis distribution and projecting on two different RCP scenarios, RCP 4.5 and RCP 8.5. The results of our study indicated annual mean temperature, elevation and temperature seasonality had higher contribution for C. bonariensis potential distribution. Area under curve (AUC) values of the model was 0.9. Under future climate scenario, the constructed model predicted that potential distribution of C. bonariensis will be increased by 338% on RCP 4.5 and 769% on RCP 8.5 in 2100s.\n",
            "toc":null,
            "degreeType":null,
            "major":null,
            "advisor":null,
            "graduateSchool":null,
            "confermentYear":null,
            "docUrl":null
         }
      }
   ]
}



 		JSONParser parser = new JSONParser();
                JSONObject jsonObjects = (JSONObject) parser.parse(response.toString());
                System.out.println("jsonObjects > " + jsonObjects);

                JSONObject jobj1 = new JSONObject(jsonObjects);
                JSONArray jobj2 = (JSONArray) jobj1.get("result");
                System.out.println("jobj2 > " + jobj2+" , jobj2.size() > "+jobj2.size());


                for (int i = 0; i < jobj2.size(); i++) {
                    JSONObject jobj3 = (JSONObject) jobj2.get(i);
                    System.out.println("jobj3 > " + jobj3);

                    jobj3.get("searchView");
                    System.out.println("searchView > " + jobj3.get("searchView"));

                    JSONObject jobj4 = (JSONObject) jobj3.get("searchView");
                    System.out.println("jobj4 > " + jobj4);

                    String title = (String) jobj4.get("title");
                    String pubYear = (String) jobj4.get("pubYear");
                    String abst = (String) jobj4.get("abst");
                    System.out.println("title > " + title + " , pubYear > " + pubYear);
                    System.out.println("abst > " + abst);


                    JSONArray jobj7 = (JSONArray) jobj4.get("keyword");
                    System.out.println("jobj7 >> " + jobj7);

                }
 */





