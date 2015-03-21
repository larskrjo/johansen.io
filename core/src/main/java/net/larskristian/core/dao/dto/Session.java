package net.larskristian.core.dao.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Lars K. Johansen
 */
@Entity
@Table(name = "Session")
public class Session implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "char")
    private String id;

    @Column(name = "externalId", columnDefinition = "char")
    private String externalId;

    @Column(name = "userId", columnDefinition = "char")
    private String userId;

    @Column(name = "appType")
    @Enumerated(EnumType.STRING)
    private AppType appType;

    @Column(name = "createdDate")
    @Type(type = "timestamp")
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AppType getAppType() {
        return appType;
    }

    public void setAppType(AppType appType) {
        this.appType = appType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Session other = (Session) obj;
        return Objects.equal(this.id, other.id)
                && Objects.equal(this.externalId, other.externalId)
                && Objects.equal(this.userId, other.userId)
                && Objects.equal(this.appType, other.appType)
                && Objects.equal(this.createDate, other.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                this.id,
                this.externalId,
                this.userId,
                this.appType,
                this.createDate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("externalId", externalId)
                .add("userId", userId)
                .add("appType", appType)
                .add("createdDate", createDate)
                .toString();

    }
}
