/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "cd_detection_variable", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdDetectionVariable.findAll", query = "SELECT c FROM CdDetectionVariable c"),
    @NamedQuery(name = "CdDetectionVariable.findById", query = "SELECT c FROM CdDetectionVariable c WHERE c.id = :id"),
    @NamedQuery(name = "CdDetectionVariable.findByDetectionVariableName", query = "SELECT c FROM CdDetectionVariable c WHERE c.detectionVariableName = :detectionVariableName"),
    @NamedQuery(name = "CdDetectionVariable.findByValidFrom", query = "SELECT c FROM CdDetectionVariable c WHERE c.validFrom = :validFrom"),
    @NamedQuery(name = "CdDetectionVariable.findByValidTo", query = "SELECT c FROM CdDetectionVariable c WHERE c.validTo = :validTo"),
    @NamedQuery(name = "CdDetectionVariable.findByDerivationWeight", query = "SELECT c FROM CdDetectionVariable c WHERE c.derivationWeight = :derivationWeight")})
public class CdDetectionVariable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "detection_variable_name")
    private String detectionVariableName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valid_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;
    @Column(name = "valid_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validTo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "derivation_weight")
    private BigDecimal derivationWeight;
   
    @JoinColumn(name = "detection_variable_type", referencedColumnName = "detection_variable_type")
    @ManyToOne(optional = false)
    private CdDetectionVariableType detectionVariableType;
   
    @JoinColumn(name = "derived_detection_variable_id", referencedColumnName = "id")
    @ManyToOne
    private CdDetectionVariable derivedDetectionVariableId;
   

    public CdDetectionVariable() {
    }

    public CdDetectionVariable(Integer id) {
        this.id = id;
    }

    public CdDetectionVariable(Integer id, String detectionVariableName, Date validFrom) {
        this.id = id;
        this.detectionVariableName = detectionVariableName;
        this.validFrom = validFrom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetectionVariableName() {
        return detectionVariableName;
    }

    public void setDetectionVariableName(String detectionVariableName) {
        this.detectionVariableName = detectionVariableName;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public BigDecimal getDerivationWeight() {
        return derivationWeight;
    }

    public void setDerivationWeight(BigDecimal derivationWeight) {
        this.derivationWeight = derivationWeight;
    }

   

    public CdDetectionVariableType getDetectionVariableType() {
        return detectionVariableType;
    }

    public void setDetectionVariableType(CdDetectionVariableType detectionVariableType) {
        this.detectionVariableType = detectionVariableType;
    }

  
    public CdDetectionVariable getDerivedDetectionVariableId() {
        return derivedDetectionVariableId;
    }

    public void setDerivedDetectionVariableId(CdDetectionVariable derivedDetectionVariableId) {
        this.derivedDetectionVariableId = derivedDetectionVariableId;
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
        if (!(object instanceof CdDetectionVariable)) {
            return false;
        }
        CdDetectionVariable other = (CdDetectionVariable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CdDetectionVariable[ id=" + id + " ]";
    }
    
}
