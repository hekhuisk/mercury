package hekhuis.mercury.entity;

import java.time.ZonedDateTime;

public class Expense extends AuditData {

    private int expenseID;

    private Money cost;
    private int paymentSourceID;
    private ZonedDateTime expenseDate;
    private int subCategoryID;
    private int mainCategoryID;
    private int budgetID;

    private String description;
    private boolean majorPurchase;

    public int getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public Money getCost() {
        return cost;
    }

    public void setCost(Money cost) {
        this.cost = cost;
    }

    public ZonedDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(ZonedDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public int getMainCategoryID() {
        return mainCategoryID;
    }

    public void setMainCategoryID(int mainCategoryID) {
        this.mainCategoryID = mainCategoryID;
    }

    public int getBudgetID() {
        return budgetID;
    }

    public void setBudgetID(int budgetID) {
        this.budgetID = budgetID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMajorPurchase() {
        return majorPurchase;
    }

    public void setMajorPurchase(boolean majorPurchase) {
        this.majorPurchase = majorPurchase;
    }
}
