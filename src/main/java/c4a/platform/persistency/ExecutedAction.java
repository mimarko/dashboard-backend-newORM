/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "executed_action", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExecutedAction.findAll", query = "SELECT e FROM ExecutedAction e"),
    @NamedQuery(name = "ExecutedAction.findById", query = "SELECT e FROM ExecutedAction e WHERE e.id = :id"),
    @NamedQuery(name = "ExecutedAction.findByDate", query = "SELECT e FROM ExecutedAction e WHERE e.date = :date"),
    @NamedQuery(name = "ExecutedAction.findByRating", query = "SELECT e FROM ExecutedAction e WHERE e.rating = :rating"),
    @NamedQuery(name = "ExecutedAction.findBySensorId", query = "SELECT e FROM ExecutedAction e WHERE e.sensorId = :sensorId"),
    @NamedQuery(name = "ExecutedAction.findByPayload", query = "SELECT e FROM ExecutedAction e WHERE e.payload = :payload"),
    @NamedQuery(name = "ExecutedAction.findByExtraInformation", query = "SELECT e FROM ExecutedAction e WHERE e.extraInformation = :extraInformation")})
public class ExecutedAction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "rating")
    private Integer rating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sensor_id")
    private int sensorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "payload")
    private String payload;
    @Size(max = 255)
    @Column(name = "extra_information")
    private String extraInformation;
    @JoinColumn(name = "user_in_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserInRole userInRoleId;
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location locationId;
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    @ManyToOne
    private Activity activityId;
    @JoinColumn(name = "action_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Action actionId;

    public ExecutedAction() {
    }

    public ExecutedAction(Long id) {
        this.id = id;
    }

    public ExecutedAction(Long id, Date date, int sensorId, String payload) {
        this.id = id;
        this.date = date;
        this.sensorId = sensorId;
        this.payload = payload;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getExtraInformation() {
        return extraInformation;
    }

    public void setExtraInformation(String extraInformation) {
        this.extraInformation = extraInformation;
    }

    public UserInRole getUserInRoleId() {
        return userInRoleId;
    }

    public void setUserInRoleId(UserInRole userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
    }

    public Action getActionId() {
        return actionId;
    }

    public void setActionId(Action actionId) {
        this.actionId = actionId;
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
        if (!(object instanceof ExecutedAction)) {
            return false;
        }
        ExecutedAction other = (ExecutedAction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.ExecutedAction[ id=" + id + " ]";
    }
    
}
