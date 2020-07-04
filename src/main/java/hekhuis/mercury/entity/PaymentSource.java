package hekhuis.mercury.entity;

import java.time.ZonedDateTime;

public class PaymentSource extends AuditData {

    private int paymentSourceID;
    private String website;
    private String name;
    private ZonedDateTime expirationDate;
}
