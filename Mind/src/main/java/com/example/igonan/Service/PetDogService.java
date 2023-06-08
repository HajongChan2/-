package com.example.igonan.Service;

import com.example.igonan.dto.PetdogDTO;
import com.example.igonan.mindmapper.PetDogmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetDogService {


    @Autowired
    private PetDogmapper pdm; // mapper에서 선언된 @select(bean)를 이용하기 위해 Autowired를 통해 의존성 주입

    public List<PetdogDTO> getPetdogList() { // DB에서 조회된 모든 반려견의 정보를 리턴하는 getAbanDogList
        List<PetdogDTO> PetDogList = pdm.PetDogList();// 모든 반려견의 정보를 List abanDogList에 담음
        return PetDogList;// PetDogList 를 리턴하여 데이터 전달

    }

    public List<PetdogDTO> getOnePet(int dogdog) { // DB에서 조회된 특정 반려견의 정보를 리턴하는 getOneDog
        List<PetdogDTO> onePetDog = pdm.findOnePet(dogdog);// 특정 반려견의 정보를 List onePetDog에 담음
        return onePetDog; // onePetDog 를 리턴하여 데이터 전달
    }
}
