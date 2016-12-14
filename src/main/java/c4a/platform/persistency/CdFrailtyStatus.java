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
@Table(name = "cd_frailty_status", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdFrailtyStatus.findAll", query = "SELECT c FROM CdFrailtyStatus c"),
    @NamedQuery(name = "CdFrailtyStatus.findByFrailtyStatus", query = "SELECT c FROM CdFrailtyStatus c WHERE c.frailtyStatus = :frailtyStatus"),
    @NamedQuery(name = "CdFrailtyStatus.findByFrailtyStatusDescription", query = "SELECT c FROM CdFrailtyStatus c WHERE c.frailtyStatusDescription = :frailtyStatusDescription")})
public class CdFrailtyStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "frailty_status")
    private String frailtyStatus;
    @Size(max = 255)
    @Column(name = "frailty_status_description")
    private String frailtyStatusDescription;
   

    public CdFrailtyStatus() {
    }

    public CdFrailtyStatus(String frailtyStatus) {
        this.frailtyStatus = frailtyStatus;
    }

    public String getFrailtyStatus() {
        return frailtyStatus;
    }

    public void setFrailtyStatus(String frailtyStatus) {
        this.frailtyStatus = frailtyStatus;
    }

    public String getFrailtyStatusDescription() {
        return frailtyStatusDescription;
    }

    public void setFrailtyStatusDescription(String frailtyStatusDescription) {
        this.frailtyStatusDescription = frailtyStatusDescription;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frailtyStatus != null ? frailtyStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdFrailtyStatus)) {
            return false;
        }
        CdFrailtyStatus other = (CdFrailtyStatus) object;
        if ((this.frailtyStatus == null && other.frailtyStatus != null) || (this.frailtyStatus != null && !this.frailtyStatus.equals(other.frailtyStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CdFrailtyStatus[ frailtyStatus=" + frailtyStatus + " ]";
    }
    
}
