package hekhuis.mercury.entity;

import java.time.ZonedDateTime;

public class Expense extends AuditData {

    private int ID;

    private Money cost;
    private PaymentSource paymentSource;
    private ZonedDateTime expenseDate;
    private int categoryID;
    private int budgetID;
}
