package com.example.igonan.Service;

import com.example.igonan.dto.AbandogAppDTO;
import com.example.igonan.mindmapper.AbanDogAppmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbanDogAppService {

    @Autowired
    private AbanDogAppmapper ada;

    public  List<AbandogAppDTO> getMainAbanDogAppList(String appuserid) {

        List<AbandogAppDTO> abanDogAppList = ada.abanDogAppList(appuserid);
        return abanDogAppList;

    }

}


