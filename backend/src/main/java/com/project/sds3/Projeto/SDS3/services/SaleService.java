package com.project.sds3.Projeto.SDS3.services;

import com.project.sds3.Projeto.SDS3.dto.SaleDTO;
import com.project.sds3.Projeto.SDS3.dto.SaleSuccessDTO;
import com.project.sds3.Projeto.SDS3.dto.SaleSumDTO;
import com.project.sds3.Projeto.SDS3.entities.Sale;
import com.project.sds3.Projeto.SDS3.repositories.SaleRepository;
import com.project.sds3.Projeto.SDS3.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = saleRepository.findAll(pageable);

        return result.map(sale -> new SaleDTO(sale));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return saleRepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        return saleRepository.successGroupedBySeller();
    }

}
