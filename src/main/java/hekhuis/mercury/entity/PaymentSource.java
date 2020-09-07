package hekhuis.mercury.entity;

import java.time.ZonedDateTime;

public class PaymentSource extends AuditData {

    private long paymentSourceID;
    private long userID;

    private String website;
    private String name;
    private ZonedDateTime expirationDate;

    public long getPaymentSourceID() {
        return paymentSourceID;
    }

    public void setPaymentSourceID(long paymentSourceID) {
        this.paymentSourceID = paymentSourceID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ZonedDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
