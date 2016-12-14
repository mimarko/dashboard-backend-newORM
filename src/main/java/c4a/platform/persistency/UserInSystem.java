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
@Table(name = "user_in_system", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInSystem.findAll", query = "SELECT u FROM UserInSystem u"),
    @NamedQuery(name = "UserInSystem.findById", query = "SELECT u FROM UserInSystem u WHERE u.id = :id"),
    @NamedQuery(name = "UserInSystem.findByUsername", query = "SELECT u FROM UserInSystem u WHERE u.username = :username"),
    @NamedQuery(name = "UserInSystem.findByPassword", query = "SELECT u FROM UserInSystem u WHERE u.password = :password"),
    @NamedQuery(name = "UserInSystem.findByDisplayName", query = "SELECT u FROM UserInSystem u WHERE u.displayName = :displayName"),
    @NamedQuery(name = "UserInSystem.findByCreatedDate", query = "SELECT u FROM UserInSystem u WHERE u.createdDate = :createdDate")})
public class UserInSystem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
   

    public UserInSystem() {
    }

    public UserInSystem(Long id) {
        this.id = id;
    }

    public UserInSystem(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        if (!(object instanceof UserInSystem)) {
            return false;
        }
        UserInSystem other = (UserInSystem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.UserInSystem[ id=" + id + " ]";
    }
    
}
