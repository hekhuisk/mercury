package hekhuis.mercury.entity;

import hekhuis.mercury.entity.category.MainCategoryMonthlyTotals;

import java.util.List;

public class Overview {

    private int year;

    private List<MainCategoryMonthlyTotals> expenseMonthlyTotals;
    private List<MainCategoryMonthlyTotals> incomeMonthlyTotals;

    public Overview(int year, List<MainCategoryMonthlyTotals> expenseMonthlyTotals, List<MainCategoryMonthlyTotals> incomeMonthlyTotals) {
        this.year = year;
        this.expenseMonthlyTotals = expenseMonthlyTotals;
        this.incomeMonthlyTotals = incomeMonthlyTotals;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<MainCategoryMonthlyTotals> getExpenseMonthlyTotals() {
        return expenseMonthlyTotals;
    }

    public void setExpenseMonthlyTotals(List<MainCategoryMonthlyTotals> expenseMonthlyTotals) {
        this.expenseMonthlyTotals = expenseMonthlyTotals;
    }

    public List<MainCategoryMonthlyTotals> getIncomeMonthlyTotals() {
        return incomeMonthlyTotals;
    }

    public void setIncomeMonthlyTotals(List<MainCategoryMonthlyTotals> incomeMonthlyTotals) {
        this.incomeMonthlyTotals = incomeMonthlyTotals;
    }
}
