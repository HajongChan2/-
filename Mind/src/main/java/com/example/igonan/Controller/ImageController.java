package com.example.igonan.Controller;


import com.example.igonan.Service.ImageService;
import com.example.igonan.Service.ProductService;
import com.example.igonan.mindmapper.Imagemapper;
import com.example.igonan.mindmapper.Productmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {


    @Autowired
    Imagemapper imagemapper;

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }




}
