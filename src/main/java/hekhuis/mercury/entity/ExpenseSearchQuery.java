package hekhuis.mercury.entity;

import java.time.ZonedDateTime;

public class ExpenseSearchQuery {

    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    private int paymentSourceID;
    private int subCategoryID;
    private int mainCategoryID;
    private int budgetID;

    private String description;
    private boolean majorPurchase;
}
