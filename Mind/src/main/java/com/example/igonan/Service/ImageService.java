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


    public List<ImageDTO> getProductImageReturn(int igonanProductImageForeignNumber) {
        List<ImageDTO> productimagelist = imp.productImageReturn(igonanProductImageForeignNumber);
        return productimagelist;

    }

    public List<ImageDTO> getabanDogImageReturn(int igonanDogImageForeignNumber) { 
        List<ImageDTO> abanDogimagelist = imp.abandogImageReturn(igonanDogImageForeignNumber);
        return abanDogimagelist;

    }

    public List<ImageDTO> getPetDogImageReturn(int igonanDogImageForeignNumber) {
        List<ImageDTO> petDogimagelist = imp.petDogImageReturn(igonanDogImageForeignNumber);
        return petDogimagelist;

    }


}
