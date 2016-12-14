/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "assessment", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assessment.findAll", query = "SELECT a FROM Assessment a"),
    @NamedQuery(name = "Assessment.findById", query = "SELECT a FROM Assessment a WHERE a.id = :id"),
    @NamedQuery(name = "Assessment.findByAssessmentComment", query = "SELECT a FROM Assessment a WHERE a.assessmentComment = :assessmentComment"),
    @NamedQuery(name = "Assessment.findByDataValidityStatus", query = "SELECT a FROM Assessment a WHERE a.dataValidityStatus = :dataValidityStatus"),
    @NamedQuery(name = "Assessment.findByCreated", query = "SELECT a FROM Assessment a WHERE a.created = :created"),
    @NamedQuery(name = "Assessment.findByUpdated", query = "SELECT a FROM Assessment a WHERE a.updated = :updated")})
public class Assessment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "assessment_comment")
    private String assessmentComment;
    @Column(name = "data_validity_status")
    private Character dataValidityStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

  
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @ManyToOne
    private UserInRole authorId;
    @JoinColumn(name = "risk_status", referencedColumnName = "risk_status")
    @ManyToOne
    private CdRiskStatus riskStatus;

    public Assessment() {
    }

    public Assessment(Integer id) {
        this.id = id;
    }

    public Assessment(Integer id, Date created) {
        this.id = id;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssessmentComment() {
        return assessmentComment;
    }

    public void setAssessmentComment(String assessmentComment) {
        this.assessmentComment = assessmentComment;
    }

    public Character getDataValidityStatus() {
        return dataValidityStatus;
    }

    public void setDataValidityStatus(Character dataValidityStatus) {
        this.dataValidityStatus = dataValidityStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

 
    public UserInRole getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UserInRole authorId) {
        this.authorId = authorId;
    }

    public CdRiskStatus getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(CdRiskStatus riskStatus) {
        this.riskStatus = riskStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assessment)) {
            return false;
        }
        Assessment other = (Assessment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.Assessment[ id=" + id + " ]";
    }
    
}
