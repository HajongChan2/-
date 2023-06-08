package com.example.igonan.Service;

import com.example.igonan.dto.ImageDTO;
import com.example.igonan.dto.PetdogDTO;
import com.example.igonan.mindmapper.Imagemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageService {

    @Autowired
   private Imagemapper imp;


    public List<ImageDTO> getProductImageReturn(int igonanProductImageForeignNumber) { // DB에서 조회된 모든 유기견의 정보를 리턴하는 getAbanDogList
        List<ImageDTO> productimagelist = imp.productImageReturn(igonanProductImageForeignNumber);// 모든 유기견의 정보를 List abanDogList에 담음
        return productimagelist;// abanDogList 를 리턴하여 데이터 전달

    }

    public List<ImageDTO> getabanDogImageReturn(int igonanDogImageForeignNumber) { // DB에서 조회된 모든 유기견의 정보를 리턴하는 getAbanDogList
        List<ImageDTO> abanDogimagelist = imp.abandogImageReturn(igonanDogImageForeignNumber);// 모든 유기견의 정보를 List abanDogList에 담음
        return abanDogimagelist;// abanDogList 를 리턴하여 데이터 전달

    }

}
