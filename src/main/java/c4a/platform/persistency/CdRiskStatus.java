/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "cd_risk_status", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdRiskStatus.findAll", query = "SELECT c FROM CdRiskStatus c"),
    @NamedQuery(name = "CdRiskStatus.findByRiskStatus", query = "SELECT c FROM CdRiskStatus c WHERE c.riskStatus = :riskStatus"),
    @NamedQuery(name = "CdRiskStatus.findByRiskStatusDescription", query = "SELECT c FROM CdRiskStatus c WHERE c.riskStatusDescription = :riskStatusDescription"),
    @NamedQuery(name = "CdRiskStatus.findByConfidenceRating", query = "SELECT c FROM CdRiskStatus c WHERE c.confidenceRating = :confidenceRating"),
    @NamedQuery(name = "CdRiskStatus.findByIconImagePath", query = "SELECT c FROM CdRiskStatus c WHERE c.iconImagePath = :iconImagePath")})
public class CdRiskStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "risk_status")
    private String riskStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "risk_status_description")
    private String riskStatusDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "confidence_rating")
    private BigDecimal confidenceRating;
    @Lob
    @Column(name = "icon_image")
    private byte[] iconImage;
    @Size(max = 200)
    @Column(name = "icon_image_path")
    private String iconImagePath;
   

    public CdRiskStatus() {
    }

    public CdRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    public CdRiskStatus(String riskStatus, String riskStatusDescription) {
        this.riskStatus = riskStatus;
        this.riskStatusDescription = riskStatusDescription;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    public String getRiskStatusDescription() {
        return riskStatusDescription;
    }

    public void setRiskStatusDescription(String riskStatusDescription) {
        this.riskStatusDescription = riskStatusDescription;
    }

    public BigDecimal getConfidenceRating() {
        return confidenceRating;
    }

    public void setConfidenceRating(BigDecimal confidenceRating) {
        this.confidenceRating = confidenceRating;
    }

    public byte[] getIconImage() {
        return iconImage;
    }

    public void setIconImage(byte[] iconImage) {
        this.iconImage = iconImage;
    }

    public String getIconImagePath() {
        return iconImagePath;
    }

    public void setIconImagePath(String iconImagePath) {
        this.iconImagePath = iconImagePath;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (riskStatus != null ? riskStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdRiskStatus)) {
            return false;
        }
        CdRiskStatus other = (CdRiskStatus) object;
        if ((this.riskStatus == null && other.riskStatus != null) || (this.riskStatus != null && !this.riskStatus.equals(other.riskStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CdRiskStatus[ riskStatus=" + riskStatus + " ]";
    }
    
}
