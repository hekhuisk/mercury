package hekhuis.mercury.entity;

import java.time.LocalDate;

public class Income extends AuditData {

    private long incomeID;

    private long subCategoryID;
    private long mainCategoryID;
    private long userID;

    private Money amount;
    private LocalDate incomeDate;
    private String description;

    public long getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(long incomeID) {
        this.incomeID = incomeID;
    }

    public long getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(long subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public long getMainCategoryID() {
        return mainCategoryID;
    }

    public void setMainCategoryID(long mainCategoryID) {
        this.mainCategoryID = mainCategoryID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
