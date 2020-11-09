package hekhuis.mercury.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_sources")
public class PaymentSource extends AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_source_id")
    private long paymentSourceID;

    @Column(name = "user_id", nullable = false)
    private long userID;

    @Column(name = "website")
    private String website;
    @Column(name = "name", nullable = false)
    private String name;

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
}
