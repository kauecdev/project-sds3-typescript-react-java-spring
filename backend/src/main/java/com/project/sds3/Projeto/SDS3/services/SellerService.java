package com.project.sds3.Projeto.SDS3.services;

import com.project.sds3.Projeto.SDS3.dto.SellerDTO;
import com.project.sds3.Projeto.SDS3.entities.Seller;
import com.project.sds3.Projeto.SDS3.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<SellerDTO> findAll() {
        List<Seller> result = sellerRepository.findAll();

        return result.stream().map(seller -> new SellerDTO(seller)).collect(Collectors.toList());
    }

}
