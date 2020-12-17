package com.example.springboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "setupaudittrail")
public class AuditLogs implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pk_id")
    private Integer pk_id;
    @Column(name = "id")
    private String id;
    @Column(name = "action")
    private String action;
    @Column(name = "section")
    private String section;
    @Column(name = "createdbyid")
    private String createdById;
    @Column(name = "display")
    private String display;
    @Column(name = "delegateuser")
    private String delegateUser;
    @Column(name = "responsiblenamespaceprefix")
    private String responsibleNamespacePrefix;
    @Column(name = "createdbycontext")
    private String createdByContext;
    @Column(name = "createdbyissuer")
    private String createdByIssuer;
    @Column(name = "createddate")
    private Date createdDate;

    public AuditLogs() {
    }

    @Override
    public String toString() {
        return "AuditLogs{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", section='" + section + '\'' +
                ", createdById='" + createdById + '\'' +
                ", display='" + display + '\'' +
                ", delegateUser='" + delegateUser + '\'' +
                ", responsibleNamespacePrefix='" + responsibleNamespacePrefix + '\'' +
                ", createdByContext='" + createdByContext + '\'' +
                ", createdByIssuer='" + createdByIssuer + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public Integer getPk_id() {
        return pk_id;
    }

    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDelegateUser() {
        return delegateUser;
    }

    public void setDelegateUser(String delegateUser) {
        this.delegateUser = delegateUser;
    }

    public String getResponsibleNamespacePrefix() {
        return responsibleNamespacePrefix;
    }

    public void setResponsibleNamespacePrefix(String responsibleNamespacePrefix) {
        this.responsibleNamespacePrefix = responsibleNamespacePrefix;
    }

    public String getCreatedByContext() {
        return createdByContext;
    }

    public void setCreatedByContext(String createdByContext) {
        this.createdByContext = createdByContext;
    }

    public String getCreatedByIssuer() {
        return createdByIssuer;
    }

    public void setCreatedByIssuer(String createdByIssuer) {
        this.createdByIssuer = createdByIssuer;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
