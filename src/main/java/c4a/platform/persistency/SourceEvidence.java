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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "source_evidence", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SourceEvidence.findAll", query = "SELECT s FROM SourceEvidence s"),
    @NamedQuery(name = "SourceEvidence.findByGeriatricFactorId", query = "SELECT s FROM SourceEvidence s WHERE s.geriatricFactorId = :geriatricFactorId"),
    @NamedQuery(name = "SourceEvidence.findByTextEvidence", query = "SELECT s FROM SourceEvidence s WHERE s.textEvidence = :textEvidence"),
    @NamedQuery(name = "SourceEvidence.findByUploaded", query = "SELECT s FROM SourceEvidence s WHERE s.uploaded = :uploaded")})
public class SourceEvidence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "geriatric_factor_id")
    private Long geriatricFactorId;
    @Size(max = 2147483647)
    @Column(name = "text_evidence")
    private String textEvidence;
    @Lob
    @Column(name = "multimedia_evidence")
    private byte[] multimediaEvidence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uploaded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploaded;
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @ManyToOne
    private UserInRole authorId;
    @JoinColumn(name = "geriatric_factor_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private GeriatricFactorValue geriatricFactorValue;

    public SourceEvidence() {
    }

    public SourceEvidence(Long geriatricFactorId) {
        this.geriatricFactorId = geriatricFactorId;
    }

    public SourceEvidence(Long geriatricFactorId, Date uploaded) {
        this.geriatricFactorId = geriatricFactorId;
        this.uploaded = uploaded;
    }

    public Long getGeriatricFactorId() {
        return geriatricFactorId;
    }

    public void setGeriatricFactorId(Long geriatricFactorId) {
        this.geriatricFactorId = geriatricFactorId;
    }

    public String getTextEvidence() {
        return textEvidence;
    }

    public void setTextEvidence(String textEvidence) {
        this.textEvidence = textEvidence;
    }

    public byte[] getMultimediaEvidence() {
        return multimediaEvidence;
    }

    public void setMultimediaEvidence(byte[] multimediaEvidence) {
        this.multimediaEvidence = multimediaEvidence;
    }

    public Date getUploaded() {
        return uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    public UserInRole getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UserInRole authorId) {
        this.authorId = authorId;
    }

    public GeriatricFactorValue getGeriatricFactorValue() {
        return geriatricFactorValue;
    }

    public void setGeriatricFactorValue(GeriatricFactorValue geriatricFactorValue) {
        this.geriatricFactorValue = geriatricFactorValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geriatricFactorId != null ? geriatricFactorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SourceEvidence)) {
            return false;
        }
        SourceEvidence other = (SourceEvidence) object;
        if ((this.geriatricFactorId == null && other.geriatricFactorId != null) || (this.geriatricFactorId != null && !this.geriatricFactorId.equals(other.geriatricFactorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.SourceEvidence[ geriatricFactorId=" + geriatricFactorId + " ]";
    }
    
}
