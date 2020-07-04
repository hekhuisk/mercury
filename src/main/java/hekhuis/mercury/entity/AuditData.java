package hekhuis.mercury.entity;

import java.time.ZonedDateTime;

public abstract class AuditData {

    protected ZonedDateTime createDate;
    protected ZonedDateTime modifiedDate;

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(ZonedDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
