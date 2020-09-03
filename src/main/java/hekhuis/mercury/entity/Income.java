package hekhuis.mercury.entity;

import java.time.ZonedDateTime;

public class Income extends AuditData {

    private int incomeID;

    private int paymentSourceID;
    private int subCategoryID;
    private int mainCategoryID;
    private int budgetID;

    private Money amount;
    private ZonedDateTime incomeDate;
    private String description;
}
