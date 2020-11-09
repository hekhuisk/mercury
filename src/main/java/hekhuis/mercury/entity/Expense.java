package hekhuis.mercury.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense extends AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "expense_id")
    private long expenseID;

    @Column(name = "payment_source_id", nullable = false)
    private long paymentSourceID;

    @Column(name = "sub_category_id", nullable = false)
    private long subCategoryID;

    @Column(name = "main_category_id", nullable = false)
    private long mainCategoryID;

    @Column(name = "user_id", nullable = false)
    private long userID;

    @Embedded
    private Money amount;

    @Column(name = "expense_date", nullable = false)
    private LocalDate expenseDate;

    @Column(name = "description")
    private String description;

    @Column(name = "major_purchase")
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

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
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
