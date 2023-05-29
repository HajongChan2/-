package com.example.igonan.Service;



import com.example.igonan.dto.UserDTO;

import com.example.igonan.mindmapper.Usermapper;
import com.example.igonan.util.loggedInSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private Usermapper ump;

    public List<UserDTO> getUsersList(){
        List<UserDTO> getUserList= ump.userlist();
        return getUserList;
    }
    public List<UserDTO> getOneUser(String userid){
        List<UserDTO> getoneuser = ump.OneUser(userid);
        //     System.out.println(oneBuy.getuPhone());

        return getoneuser;
    }


    public loggedInSession loginUser(String userid){
        loggedInSession getusername = ump.userlogin(userid);

        return getusername;
    }


    public UserDTO userUpdate(String name,String pw,String phone,String addr,String saddr,String userid){
        UserDTO userupdate = ump.userinfoupdate(name,pw,phone,addr,saddr,userid);

        return userupdate;
    }

}
