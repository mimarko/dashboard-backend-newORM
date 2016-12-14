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
@Table(name = "cd_data_source_type", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdDataSourceType.findAll", query = "SELECT c FROM CdDataSourceType c"),
    @NamedQuery(name = "CdDataSourceType.findByDataSourceType", query = "SELECT c FROM CdDataSourceType c WHERE c.dataSourceType = :dataSourceType"),
    @NamedQuery(name = "CdDataSourceType.findByDataSourceTypeDescription", query = "SELECT c FROM CdDataSourceType c WHERE c.dataSourceTypeDescription = :dataSourceTypeDescription"),
    @NamedQuery(name = "CdDataSourceType.findByObtrusive", query = "SELECT c FROM CdDataSourceType c WHERE c.obtrusive = :obtrusive")})
public class CdDataSourceType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "data_source_type")
    private String dataSourceType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "data_source_type_description")
    private String dataSourceTypeDescription;
    @Column(name = "obtrusive")
    private Boolean obtrusive;
   

    public CdDataSourceType() {
    }

    public CdDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public CdDataSourceType(String dataSourceType, String dataSourceTypeDescription) {
        this.dataSourceType = dataSourceType;
        this.dataSourceTypeDescription = dataSourceTypeDescription;
    }

    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public String getDataSourceTypeDescription() {
        return dataSourceTypeDescription;
    }

    public void setDataSourceTypeDescription(String dataSourceTypeDescription) {
        this.dataSourceTypeDescription = dataSourceTypeDescription;
    }

    public Boolean getObtrusive() {
        return obtrusive;
    }

    public void setObtrusive(Boolean obtrusive) {
        this.obtrusive = obtrusive;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataSourceType != null ? dataSourceType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdDataSourceType)) {
            return false;
        }
        CdDataSourceType other = (CdDataSourceType) object;
        if ((this.dataSourceType == null && other.dataSourceType != null) || (this.dataSourceType != null && !this.dataSourceType.equals(other.dataSourceType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CdDataSourceType[ dataSourceType=" + dataSourceType + " ]";
    }
    
}
