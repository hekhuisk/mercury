package hekhuis.mercury.entity;

import java.time.YearMonth;
import java.util.HashMap;

public class MonthlyBudget extends Budget {

    private int ID;

    private YearMonth yearMonth;

    private Money totalIncome;
    private Money totalExpenses;

    // Key is Category ID
    private HashMap<Integer, Money> incomeCategoryTotals;
    private HashMap<Integer, Money> expenseCategoryTotals;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }


    public Money getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Money totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Money getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Money totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public HashMap<Integer, Money> getIncomeCategoryTotals() {
        return incomeCategoryTotals;
    }

    public void setIncomeCategoryTotals(HashMap<Integer, Money> incomeCategoryTotals) {
        this.incomeCategoryTotals = incomeCategoryTotals;
    }

    public HashMap<Integer, Money> getExpenseCategoryTotals() {
        return expenseCategoryTotals;
    }

    public void setExpenseCategoryTotals(HashMap<Integer, Money> expenseCategoryTotals) {
        this.expenseCategoryTotals = expenseCategoryTotals;
    }
}
