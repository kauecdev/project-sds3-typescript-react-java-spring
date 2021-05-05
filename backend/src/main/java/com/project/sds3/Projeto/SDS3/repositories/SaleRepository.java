package com.project.sds3.Projeto.SDS3.repositories;

import com.project.sds3.Projeto.SDS3.dto.SaleSuccessDTO;
import com.project.sds3.Projeto.SDS3.dto.SaleSumDTO;
import com.project.sds3.Projeto.SDS3.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.project.sds3.Projeto.SDS3.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
            + "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.project.sds3.Projeto.SDS3.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
            + "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();

}
