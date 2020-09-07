package hekhuis.mercury.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
public class Expense extends AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long expenseID;

    private long paymentSourceID;
    private long subCategoryID;
    private long mainCategoryID;
    private long budgetID;

    @Embedded
    private Money amount;
    private ZonedDateTime expenseDate;
    //@Column(name = "description")
    private String description;
    //@Column(name = "major_purchase")
    private boolean majorPurchase;

    public Expense() {}

    public Expense(Money amount, String description, boolean majorPurchase) {
        this.amount = amount;
        this.description = description;
        this.majorPurchase = majorPurchase;
    }

    public long getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(long expenseID) {
        this.expenseID = expenseID;
    }

    public long getPaymentSourceID() {
        return paymentSourceID;
    }

    public void setPaymentSourceID(long paymentSourceID) {
        this.paymentSourceID = paymentSourceID;
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

    public long getBudgetID() {
        return budgetID;
    }

    public void setBudgetID(long budgetID) {
        this.budgetID = budgetID;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public ZonedDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(ZonedDateTime expenseDate) {
        this.expenseDate = expenseDate;
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
