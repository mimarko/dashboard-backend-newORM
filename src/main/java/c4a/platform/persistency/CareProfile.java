/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "care_profile", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CareProfile.findAll", query = "SELECT c FROM CareProfile c"),
    @NamedQuery(name = "CareProfile.findByUserInRoleId", query = "SELECT c FROM CareProfile c WHERE c.userInRoleId = :userInRoleId"),
    @NamedQuery(name = "CareProfile.findByIndividualSummary", query = "SELECT c FROM CareProfile c WHERE c.individualSummary = :individualSummary"),
    @NamedQuery(name = "CareProfile.findByAttentionStatus", query = "SELECT c FROM CareProfile c WHERE c.attentionStatus = :attentionStatus"),
    @NamedQuery(name = "CareProfile.findByInterventionStatus", query = "SELECT c FROM CareProfile c WHERE c.interventionStatus = :interventionStatus"),
    @NamedQuery(name = "CareProfile.findByLastInterventionDate", query = "SELECT c FROM CareProfile c WHERE c.lastInterventionDate = :lastInterventionDate"),
    @NamedQuery(name = "CareProfile.findByCreated", query = "SELECT c FROM CareProfile c WHERE c.created = :created"),
    @NamedQuery(name = "CareProfile.findByLastUpdated", query = "SELECT c FROM CareProfile c WHERE c.lastUpdated = :lastUpdated")})
public class CareProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_in_role_id")
    private Long userInRoleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "individual_summary")
    private String individualSummary;
    @Column(name = "attention_status")
    private Character attentionStatus;
    @Column(name = "intervention_status")
    private Character interventionStatus;
    @Column(name = "last_intervention_date")
    @Temporal(TemporalType.DATE)
    private Date lastInterventionDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "id")
    @ManyToOne
    private UserInRole lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserInRole createdBy;
    @JoinColumn(name = "user_in_role_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserInRole userInRole;

    public CareProfile() {
    }

    public CareProfile(Long userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    public CareProfile(Long userInRoleId, String individualSummary, Date created) {
        this.userInRoleId = userInRoleId;
        this.individualSummary = individualSummary;
        this.created = created;
    }

    public Long getUserInRoleId() {
        return userInRoleId;
    }

    public void setUserInRoleId(Long userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    public String getIndividualSummary() {
        return individualSummary;
    }

    public void setIndividualSummary(String individualSummary) {
        this.individualSummary = individualSummary;
    }

    public Character getAttentionStatus() {
        return attentionStatus;
    }

    public void setAttentionStatus(Character attentionStatus) {
        this.attentionStatus = attentionStatus;
    }

    public Character getInterventionStatus() {
        return interventionStatus;
    }

    public void setInterventionStatus(Character interventionStatus) {
        this.interventionStatus = interventionStatus;
    }

    public Date getLastInterventionDate() {
        return lastInterventionDate;
    }

    public void setLastInterventionDate(Date lastInterventionDate) {
        this.lastInterventionDate = lastInterventionDate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public UserInRole getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(UserInRole lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public UserInRole getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserInRole createdBy) {
        this.createdBy = createdBy;
    }

    public UserInRole getUserInRole() {
        return userInRole;
    }

    public void setUserInRole(UserInRole userInRole) {
        this.userInRole = userInRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userInRoleId != null ? userInRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CareProfile)) {
            return false;
        }
        CareProfile other = (CareProfile) object;
        if ((this.userInRoleId == null && other.userInRoleId != null) || (this.userInRoleId != null && !this.userInRoleId.equals(other.userInRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CareProfile[ userInRoleId=" + userInRoleId + " ]";
    }
    
}
