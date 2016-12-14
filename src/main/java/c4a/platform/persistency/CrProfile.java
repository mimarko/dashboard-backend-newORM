/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "cr_profile", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrProfile.findAll", query = "SELECT c FROM CrProfile c"),
    @NamedQuery(name = "CrProfile.findById", query = "SELECT c FROM CrProfile c WHERE c.id = :id"),
    @NamedQuery(name = "CrProfile.findByRefHeight", query = "SELECT c FROM CrProfile c WHERE c.refHeight = :refHeight"),
    @NamedQuery(name = "CrProfile.findByRefWeight", query = "SELECT c FROM CrProfile c WHERE c.refWeight = :refWeight"),
    @NamedQuery(name = "CrProfile.findByRefMeanBloodPressure", query = "SELECT c FROM CrProfile c WHERE c.refMeanBloodPressure = :refMeanBloodPressure"),
    @NamedQuery(name = "CrProfile.findByDate", query = "SELECT c FROM CrProfile c WHERE c.date = :date"),
    @NamedQuery(name = "CrProfile.findByBirthDate", query = "SELECT c FROM CrProfile c WHERE c.birthDate = :birthDate"),
    @NamedQuery(name = "CrProfile.findByGender", query = "SELECT c FROM CrProfile c WHERE c.gender = :gender")})
public class CrProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ref_height")
    private Float refHeight;
    @Column(name = "ref_weight")
    private Float refWeight;
    @Column(name = "ref_mean_blood_pressure")
    private BigDecimal refMeanBloodPressure;
    @Column(name = "date")
    @Temporal(TemporalType.TIME)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private boolean gender;
    @JoinColumn(name = "user_in_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserInRole userInRoleId;

    public CrProfile() {
    }

    public CrProfile(Integer id) {
        this.id = id;
    }

    public CrProfile(Integer id, Date birthDate, boolean gender) {
        this.id = id;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getRefHeight() {
        return refHeight;
    }

    public void setRefHeight(Float refHeight) {
        this.refHeight = refHeight;
    }

    public Float getRefWeight() {
        return refWeight;
    }

    public void setRefWeight(Float refWeight) {
        this.refWeight = refWeight;
    }

    public BigDecimal getRefMeanBloodPressure() {
        return refMeanBloodPressure;
    }

    public void setRefMeanBloodPressure(BigDecimal refMeanBloodPressure) {
        this.refMeanBloodPressure = refMeanBloodPressure;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public UserInRole getUserInRoleId() {
        return userInRoleId;
    }

    public void setUserInRoleId(UserInRole userInRoleId) {
        this.userInRoleId = userInRoleId;
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
        if (!(object instanceof CrProfile)) {
            return false;
        }
        CrProfile other = (CrProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CrProfile[ id=" + id + " ]";
    }
    
}
