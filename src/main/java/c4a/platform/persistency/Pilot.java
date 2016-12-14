/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "pilot", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pilot.findAll", query = "SELECT p FROM Pilot p"),
    @NamedQuery(name = "Pilot.findById", query = "SELECT p FROM Pilot p WHERE p.id = :id"),
    @NamedQuery(name = "Pilot.findByName", query = "SELECT p FROM Pilot p WHERE p.name = :name"),
    @NamedQuery(name = "Pilot.findByPilotCode", query = "SELECT p FROM Pilot p WHERE p.pilotCode = :pilotCode"),
    @NamedQuery(name = "Pilot.findByPopulationSize", query = "SELECT p FROM Pilot p WHERE p.populationSize = :populationSize")})
public class Pilot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "pilot_code")
    private String pilotCode;
    @Column(name = "population_size")
    private BigInteger populationSize;
   

    public Pilot() {
    }

    public Pilot(Integer id) {
        this.id = id;
    }

    public Pilot(Integer id, String pilotCode) {
        this.id = id;
        this.pilotCode = pilotCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPilotCode() {
        return pilotCode;
    }

    public void setPilotCode(String pilotCode) {
        this.pilotCode = pilotCode;
    }

    public BigInteger getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(BigInteger populationSize) {
        this.populationSize = populationSize;
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
        if (!(object instanceof Pilot)) {
            return false;
        }
        Pilot other = (Pilot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.Pilot[ id=" + id + " ]";
    }
    
}
