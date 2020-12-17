package com.example.springboot.repository;

import com.example.springboot.model.AuditLogs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogsRepository extends CrudRepository<AuditLogs , Integer> {
}
