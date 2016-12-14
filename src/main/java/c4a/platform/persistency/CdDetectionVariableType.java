/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cd_detection_variable_type", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdDetectionVariableType.findAll", query = "SELECT c FROM CdDetectionVariableType c"),
    @NamedQuery(name = "CdDetectionVariableType.findByDetectionVariableType", query = "SELECT c FROM CdDetectionVariableType c WHERE c.detectionVariableType = :detectionVariableType"),
    @NamedQuery(name = "CdDetectionVariableType.findByDetectionVariableTypeDescription", query = "SELECT c FROM CdDetectionVariableType c WHERE c.detectionVariableTypeDescription = :detectionVariableTypeDescription")})
public class CdDetectionVariableType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "detection_variable_type")
    private String detectionVariableType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "detection_variable_type_description")
    private String detectionVariableTypeDescription;
    

    public CdDetectionVariableType() {
    }

    public CdDetectionVariableType(String detectionVariableType) {
        this.detectionVariableType = detectionVariableType;
    }

    public CdDetectionVariableType(String detectionVariableType, String detectionVariableTypeDescription) {
        this.detectionVariableType = detectionVariableType;
        this.detectionVariableTypeDescription = detectionVariableTypeDescription;
    }

    public String getDetectionVariableType() {
        return detectionVariableType;
    }

    public void setDetectionVariableType(String detectionVariableType) {
        this.detectionVariableType = detectionVariableType;
    }

    public String getDetectionVariableTypeDescription() {
        return detectionVariableTypeDescription;
    }

    public void setDetectionVariableTypeDescription(String detectionVariableTypeDescription) {
        this.detectionVariableTypeDescription = detectionVariableTypeDescription;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detectionVariableType != null ? detectionVariableType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdDetectionVariableType)) {
            return false;
        }
        CdDetectionVariableType other = (CdDetectionVariableType) object;
        if ((this.detectionVariableType == null && other.detectionVariableType != null) || (this.detectionVariableType != null && !this.detectionVariableType.equals(other.detectionVariableType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CdDetectionVariableType[ detectionVariableType=" + detectionVariableType + " ]";
    }
    
}
