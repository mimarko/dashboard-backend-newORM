/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
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
@Table(name = "cd_typical_period", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdTypicalPeriod.findAll", query = "SELECT c FROM CdTypicalPeriod c"),
    @NamedQuery(name = "CdTypicalPeriod.findByTypicalPeriod", query = "SELECT c FROM CdTypicalPeriod c WHERE c.typicalPeriod = :typicalPeriod"),
    @NamedQuery(name = "CdTypicalPeriod.findByPeriodDescription", query = "SELECT c FROM CdTypicalPeriod c WHERE c.periodDescription = :periodDescription")})
public class CdTypicalPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "typical_period")
    private String typicalPeriod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "period_description")
    private String periodDescription;
    //@Lob
    //@Column(name = "typical_duration")
    //private byte[] typicalDuration;
   

    public CdTypicalPeriod() {
    }

    public CdTypicalPeriod(String typicalPeriod) {
        this.typicalPeriod = typicalPeriod;
    }

    public CdTypicalPeriod(String typicalPeriod, String periodDescription) {
        this.typicalPeriod = typicalPeriod;
        this.periodDescription = periodDescription;
    }

    public String getTypicalPeriod() {
        return typicalPeriod;
    }

    public void setTypicalPeriod(String typicalPeriod) {
        this.typicalPeriod = typicalPeriod;
    }

    public String getPeriodDescription() {
        return periodDescription;
    }

    public void setPeriodDescription(String periodDescription) {
        this.periodDescription = periodDescription;
    }

    //public byte[] getTypicalDuration() {
    //    return typicalDuration;
    //}

    //public void setTypicalDuration(byte[] typicalDuration) {
    //    this.typicalDuration = typicalDuration;
    //}

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typicalPeriod != null ? typicalPeriod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdTypicalPeriod)) {
            return false;
        }
        CdTypicalPeriod other = (CdTypicalPeriod) object;
        if ((this.typicalPeriod == null && other.typicalPeriod != null) || (this.typicalPeriod != null && !this.typicalPeriod.equals(other.typicalPeriod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CdTypicalPeriod[ typicalPeriod=" + typicalPeriod + " ]";
    }
    
}
