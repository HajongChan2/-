package com.example.igonan.Controller;


import com.example.igonan.Service.ImageService;
import com.example.igonan.Service.ProductService;
import com.example.igonan.dto.ImageDTO;
import com.example.igonan.dto.ProductDTO;
import com.example.igonan.mindmapper.Imagemapper;
import com.example.igonan.mindmapper.Productmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageController {


    @Autowired
    Imagemapper imagemapper;

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }




    @RequestMapping(value = "/productimagelist/{param}", method = { RequestMethod.POST })
    @ResponseBody
    public Object productimagelist(@PathVariable("param")int whatIsproductNumber){

        List<ImageDTO> list = imageService.getProductImageReturn(whatIsproductNumber);

        return list;

    }

    @RequestMapping(value = "/abandogimagelist/{param}", method = { RequestMethod.POST })
    @ResponseBody
    public Object abandogimagelist(@PathVariable("param")int  whatIsDogsNumber){

        List<ImageDTO> list = imageService.getabanDogImageReturn(whatIsDogsNumber);

        return list;

    }

}
