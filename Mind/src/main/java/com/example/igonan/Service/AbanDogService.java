package com.example.igonan.Service;

import com.example.igonan.dto.AbandogDTO;
import com.example.igonan.mindmapper.AbanDogmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbanDogService {

    @Autowired
    private AbanDogmapper adm; // mapper에서 선언된 @select(bean)를 이용하기 위해 Autowired를 통해 의존성 주입

    public  List<AbandogDTO> getAbanDogList() { // DB에서 조회된 모든 유기견의 정보를 리턴하는 getAbanDogList
        List<AbandogDTO> abanDogList = adm.abanDogList();// 모든 유기견의 정보를 List abanDogList에 담음
        return abanDogList;// abanDogList 를 리턴하여 데이터 전달

    }

    public List<AbandogDTO> getOneDog(String dogname) { // DB에서 조회된 특정 유기견의 정보를 리턴하는 getOneDog
        List<AbandogDTO> oneDog = adm.findOneDog(dogname);// 특정 유기견의 정보를 List oneDog에 담음
        return oneDog; // oneDog 를 리턴하여 데이터 전달
    }

    public  List<AbandogDTO> getMainAbanDogList() { // DB에서 조회된 모든 유기견의 정보를 리턴하는 getAbanDogList
        List<AbandogDTO> abanDogList = adm.mainAbandogList();// 모든 유기견의 정보를 List abanDogList에 담음
        return abanDogList;// abanDogList 를 리턴하여 데이터 전달

    }

}


