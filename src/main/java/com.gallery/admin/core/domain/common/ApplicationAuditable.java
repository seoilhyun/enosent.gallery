package com.gallery.admin.core.domain.common;

import com.gallery.admin.core.domain.system.User;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 27.
 * Time: 오후 1:17
 * To change this template use File | Settings | File Templates.
 */

@MappedSuperclass
public abstract class ApplicationAuditable implements Auditable<User, Long> {


    @ManyToOne(fetch= FetchType.LAZY)
    private User createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne(fetch=FetchType.LAZY)
    private User lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Override
    public User getCreatedBy() {
        return createdBy;
    }
    @Override
    public void setCreatedBy(final User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public DateTime getCreatedDate() {
        return null == createdDate ? null : new DateTime(createdDate);
    }
    @Override
    public void setCreatedDate(final DateTime createdDate) {
        this.createdDate = null == createdDate ? null : createdDate.toDate();
    }

    @Override
    public User getLastModifiedBy() {
        return lastModifiedBy;
    }
    @Override
    public void setLastModifiedBy(final User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public DateTime getLastModifiedDate() {
        return null == lastModifiedDate ? null : new DateTime(lastModifiedDate);
    }
    @Override
    public void setLastModifiedDate(final DateTime lastModifiedDate) {
        this.lastModifiedDate = null == lastModifiedDate ? null : lastModifiedDate.toDate();
    }

    @Override
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += null == getId() ? 0 : getId().hashCode() * 31;
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;

        if (this == obj)
            return true;

        if (!getClass().equals(obj.getClass()))
            return false;

        ApplicationAuditable that = (ApplicationAuditable) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());
    }
}
