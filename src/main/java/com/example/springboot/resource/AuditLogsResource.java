package com.example.springboot.resource;


import com.example.springboot.model.AuditLogs;
import com.example.springboot.repository.AuditLogsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/auditlogs")
@RestController
public class AuditLogsResource {

    Logger logger = LoggerFactory.getLogger(AuditLogsResource.class);

    @Autowired
    AuditLogsRepository auditLogsRepository;

    @GetMapping("/all")
    public List<AuditLogs> getAuditLogs() {
        List<AuditLogs> auditLogs = new ArrayList<AuditLogs>();
        Iterable<AuditLogs> auditLogsItr = auditLogsRepository.findAll();
        auditLogsItr.forEach(x -> auditLogs.add(x));
        return auditLogs;
    }

    @GetMapping("/{id}")
    public AuditLogs getAuditLogs(@PathVariable("id") Integer id) {
        logger.info("Path param id #######" + id);
        AuditLogs auditLogs = null;
        Optional<AuditLogs> optionalAuditLogs = auditLogsRepository.findById(id);
        if (optionalAuditLogs.isPresent()) {
            auditLogs = optionalAuditLogs.get();
        }
        return auditLogs;
    }

    @GetMapping("/date")
    public List<AuditLogs> getAuditLogsByDate(@RequestParam("date") String date /*, @RequestParam("endDate") String endDate*/) {
        String startDate = date+"T00:00:00.000+0000";
        logger.info("Query param startDate ####### " + startDate );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String endDate = date+"T23:59:00.000+0000";
        logger.info("Query param endDate ####### " + endDate );
        Date startDateSql = null;
        Date endDateSql = null;
        try {
             startDateSql = simpleDateFormat.parse(startDate);
             endDateSql = simpleDateFormat.parse(endDate);
             logger.info("Query param Date sql ####### " + startDateSql + "endDate ##### " +endDateSql);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        AuditLogs auditLogs = null;
        List<AuditLogs> optionalAuditLogs = auditLogsRepository.findByCreatedDates(startDateSql , endDateSql);
        return optionalAuditLogs;
    }

    @PostMapping("/save")
    public AuditLogs saveAuditLogs(@RequestBody AuditLogs auditLogs) {
        AuditLogs dbAuditLogs = auditLogsRepository.save(auditLogs);
        return dbAuditLogs;
    }


    @DeleteMapping("/{id}")
    public void deleteAuditLogs(@PathVariable("id") Integer id) {
        auditLogsRepository.deleteById(id);
    }

}

