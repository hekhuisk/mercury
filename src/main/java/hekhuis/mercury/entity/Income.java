package hekhuis.mercury.entity;

import java.time.ZonedDateTime;

public class Income extends AuditData {

    private long incomeID;

    private long paymentSourceID;
    private long subCategoryID;
    private long mainCategoryID;
    private long budgetID;

    private Money amount;
    private ZonedDateTime incomeDate;
    private String description;
}
