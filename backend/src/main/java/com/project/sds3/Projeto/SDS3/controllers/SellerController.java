package com.project.sds3.Projeto.SDS3.controllers;

import com.project.sds3.Projeto.SDS3.dto.SellerDTO;
import com.project.sds3.Projeto.SDS3.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService service;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll() {
        List<SellerDTO> list = service.findAll();

        return ResponseEntity.ok(list);
    }
}
