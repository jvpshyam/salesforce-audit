package com.example.springboot.repository;

import com.example.springboot.model.AuditLogs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuditLogsRepository extends CrudRepository<AuditLogs , Integer> {

    @Query("from AuditLogs e where e.createdDate BETWEEN :startDate AND :endDate")
    List<AuditLogs> findByCreatedDates(Date startDate , Date endDate);

    @Query("from AuditLogs e where e.createdDate BETWEEN :startDate AND :endDate")
    List<AuditLogs> findByCreatedDate(Date startDate);
}
