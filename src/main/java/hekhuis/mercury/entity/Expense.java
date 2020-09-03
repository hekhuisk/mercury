package hekhuis.mercury.entity;

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

    private int paymentSourceID;
    private int subCategoryID;
    private int mainCategoryID;
    private int budgetID;

//    @Embedded
//    private Money cost;
    private ZonedDateTime expenseDate;
    //@Column(name = "description")
    private String description;
    //@Column(name = "major_purchase")
    private boolean majorPurchase;

    public Expense() {}

    public Expense(Money cost, String description, boolean majorPurchase) {
//        this.cost = cost;
        this.description = description;
        this.majorPurchase = majorPurchase;
    }

    public long getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(long expenseID) {
        this.expenseID = expenseID;
    }

//    public Money getCost() {
//        return cost;
//    }
//
//    public void setCost(Money cost) {
//        this.cost = cost;
//    }

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
