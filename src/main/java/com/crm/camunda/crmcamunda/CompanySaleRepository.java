package com.crm.camunda.crmcamunda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompanySaleRepository extends JpaRepository<CompanySale, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE CompanySale cs SET cs.status = 0 " +
            "WHERE cs.id = :id")
    void setLead(@Param("id") Long id);
}
