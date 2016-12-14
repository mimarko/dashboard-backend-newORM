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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "user_in_role", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInRole.findAll", query = "SELECT u FROM UserInRole u"),
    @NamedQuery(name = "UserInRole.findById", query = "SELECT u FROM UserInRole u WHERE u.id = :id"),
    @NamedQuery(name = "UserInRole.findByValidFrom", query = "SELECT u FROM UserInRole u WHERE u.validFrom = :validFrom"),
    @NamedQuery(name = "UserInRole.findByValidTo", query = "SELECT u FROM UserInRole u WHERE u.validTo = :validTo"),
    @NamedQuery(name = "UserInRole.findByPilotSourceUserId", query = "SELECT u FROM UserInRole u WHERE u.pilotSourceUserId = :pilotSourceUserId")})
public class UserInRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "valid_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;
    @Column(name = "valid_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validTo;
    @Size(max = 20)
    @Column(name = "pilot_source_user_id")
    private String pilotSourceUserId;
   
    @JoinColumn(name = "user_in_system_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserInSystem userInSystemId;
    @JoinColumn(name = "pilot_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pilot pilotId;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CdRole roleId;
  
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userInRole")
    private CareProfile careProfile;
   

    public UserInRole() {
    }

    public UserInRole(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPilotSourceUserId() {
        return pilotSourceUserId;
    }

    public void setPilotSourceUserId(String pilotSourceUserId) {
        this.pilotSourceUserId = pilotSourceUserId;
    }

   

    public UserInSystem getUserInSystemId() {
        return userInSystemId;
    }

    public void setUserInSystemId(UserInSystem userInSystemId) {
        this.userInSystemId = userInSystemId;
    }

    public Pilot getPilotId() {
        return pilotId;
    }

    public void setPilotId(Pilot pilotId) {
        this.pilotId = pilotId;
    }

    public CdRole getRoleId() {
        return roleId;
    }

    public void setRoleId(CdRole roleId) {
        this.roleId = roleId;
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
        if (!(object instanceof UserInRole)) {
            return false;
        }
        UserInRole other = (UserInRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.UserInRole[ id=" + id + " ]";
    }
    
}
