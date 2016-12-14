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
@Table(name = "cd_role", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdRole.findAll", query = "SELECT c FROM CdRole c"),
    @NamedQuery(name = "CdRole.findById", query = "SELECT c FROM CdRole c WHERE c.id = :id"),
    @NamedQuery(name = "CdRole.findByRoleName", query = "SELECT c FROM CdRole c WHERE c.roleName = :roleName"),
    @NamedQuery(name = "CdRole.findByRoleAbbreviation", query = "SELECT c FROM CdRole c WHERE c.roleAbbreviation = :roleAbbreviation"),
    @NamedQuery(name = "CdRole.findByRoleDescription", query = "SELECT c FROM CdRole c WHERE c.roleDescription = :roleDescription"),
    @NamedQuery(name = "CdRole.findByValidFrom", query = "SELECT c FROM CdRole c WHERE c.validFrom = :validFrom"),
    @NamedQuery(name = "CdRole.findByValidTo", query = "SELECT c FROM CdRole c WHERE c.validTo = :validTo")})
public class CdRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "role_name")
    private String roleName;
    @Size(max = 3)
    @Column(name = "role_abbreviation")
    private String roleAbbreviation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "role_description")
    private String roleDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valid_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;
    @Column(name = "valid_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validTo;
   

    public CdRole() {
    }

    public CdRole(Integer id) {
        this.id = id;
    }

    public CdRole(Integer id, String roleName, String roleDescription, Date validFrom) {
        this.id = id;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.validFrom = validFrom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleAbbreviation() {
        return roleAbbreviation;
    }

    public void setRoleAbbreviation(String roleAbbreviation) {
        this.roleAbbreviation = roleAbbreviation;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
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

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdRole)) {
            return false;
        }
        CdRole other = (CdRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CdRole[ id=" + id + " ]";
    }
    
}
