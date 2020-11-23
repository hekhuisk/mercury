package hekhuis.mercury.entity;

import hekhuis.mercury.entity.category.MainCategoryMonthlyTotals;

import java.math.BigDecimal;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Overview {

    private int year;

    private List<MainCategoryMonthlyTotals> expenseMonthlyTotals;
    private List<MainCategoryMonthlyTotals> incomeMonthlyTotals;

    private Map<Month, BigDecimal> expenseTotalMonthlyTotals;
    private Map<Month, BigDecimal> incomeTotalMonthlyTotals;

    private BigDecimal expenseYearlyTotal;
    private BigDecimal incomeYearlyTotal;

    public Overview(int year, List<MainCategoryMonthlyTotals> expenseMonthlyTotals, List<MainCategoryMonthlyTotals> incomeMonthlyTotals) {
        this.year = year;
        this.expenseMonthlyTotals = expenseMonthlyTotals;
        this.incomeMonthlyTotals = incomeMonthlyTotals;

        expenseTotalMonthlyTotals = new HashMap<>();

        for (Month month : Month.values()) {
            expenseTotalMonthlyTotals.put(month, BigDecimal.valueOf(0.00));
        }

        for (MainCategoryMonthlyTotals mcmt : expenseMonthlyTotals) {
            Map<Month, BigDecimal> monthlyTotals = mcmt.getMonthlyTotals();

            expenseTotalMonthlyTotals.replace(Month.JANUARY, expenseTotalMonthlyTotals.get(Month.JANUARY).add(monthlyTotals.get(Month.JANUARY)));
            expenseTotalMonthlyTotals.replace(Month.FEBRUARY, expenseTotalMonthlyTotals.get(Month.FEBRUARY).add(monthlyTotals.get(Month.FEBRUARY)));
            expenseTotalMonthlyTotals.replace(Month.MARCH, expenseTotalMonthlyTotals.get(Month.MARCH).add(monthlyTotals.get(Month.MARCH)));
            expenseTotalMonthlyTotals.replace(Month.APRIL, expenseTotalMonthlyTotals.get(Month.APRIL).add(monthlyTotals.get(Month.APRIL)));
            expenseTotalMonthlyTotals.replace(Month.MAY, expenseTotalMonthlyTotals.get(Month.MAY).add(monthlyTotals.get(Month.MAY)));
            expenseTotalMonthlyTotals.replace(Month.JUNE, expenseTotalMonthlyTotals.get(Month.JUNE).add(monthlyTotals.get(Month.JUNE)));
            expenseTotalMonthlyTotals.replace(Month.JULY, expenseTotalMonthlyTotals.get(Month.JULY).add(monthlyTotals.get(Month.JULY)));
            expenseTotalMonthlyTotals.replace(Month.AUGUST, expenseTotalMonthlyTotals.get(Month.AUGUST).add(monthlyTotals.get(Month.AUGUST)));
            expenseTotalMonthlyTotals.replace(Month.SEPTEMBER, expenseTotalMonthlyTotals.get(Month.SEPTEMBER).add(monthlyTotals.get(Month.SEPTEMBER)));
            expenseTotalMonthlyTotals.replace(Month.OCTOBER, expenseTotalMonthlyTotals.get(Month.OCTOBER).add(monthlyTotals.get(Month.OCTOBER)));
            expenseTotalMonthlyTotals.replace(Month.NOVEMBER, expenseTotalMonthlyTotals.get(Month.NOVEMBER).add(monthlyTotals.get(Month.NOVEMBER)));
            expenseTotalMonthlyTotals.replace(Month.DECEMBER, expenseTotalMonthlyTotals.get(Month.DECEMBER).add(monthlyTotals.get(Month.DECEMBER)));
        }

        expenseYearlyTotal = BigDecimal.valueOf(0.00);

        for (BigDecimal monthlyTotal : expenseTotalMonthlyTotals.values()) {
            expenseYearlyTotal = expenseYearlyTotal.add(monthlyTotal);
        }

        incomeTotalMonthlyTotals = new HashMap<>();

        for (Month month : Month.values()) {
            incomeTotalMonthlyTotals.put(month, BigDecimal.valueOf(0.00));
        }

        for (MainCategoryMonthlyTotals mcmt : incomeMonthlyTotals) {
            Map<Month, BigDecimal> monthlyTotals = mcmt.getMonthlyTotals();

            incomeTotalMonthlyTotals.replace(Month.JANUARY, incomeTotalMonthlyTotals.get(Month.JANUARY).add(monthlyTotals.get(Month.JANUARY)));
            incomeTotalMonthlyTotals.replace(Month.FEBRUARY, incomeTotalMonthlyTotals.get(Month.FEBRUARY).add(monthlyTotals.get(Month.FEBRUARY)));
            incomeTotalMonthlyTotals.replace(Month.MARCH, incomeTotalMonthlyTotals.get(Month.MARCH).add(monthlyTotals.get(Month.MARCH)));
            incomeTotalMonthlyTotals.replace(Month.APRIL, incomeTotalMonthlyTotals.get(Month.APRIL).add(monthlyTotals.get(Month.APRIL)));
            incomeTotalMonthlyTotals.replace(Month.MAY, incomeTotalMonthlyTotals.get(Month.MAY).add(monthlyTotals.get(Month.MAY)));
            incomeTotalMonthlyTotals.replace(Month.JUNE, incomeTotalMonthlyTotals.get(Month.JUNE).add(monthlyTotals.get(Month.JUNE)));
            incomeTotalMonthlyTotals.replace(Month.JULY, incomeTotalMonthlyTotals.get(Month.JULY).add(monthlyTotals.get(Month.JULY)));
            incomeTotalMonthlyTotals.replace(Month.AUGUST, incomeTotalMonthlyTotals.get(Month.AUGUST).add(monthlyTotals.get(Month.AUGUST)));
            incomeTotalMonthlyTotals.replace(Month.SEPTEMBER, incomeTotalMonthlyTotals.get(Month.SEPTEMBER).add(monthlyTotals.get(Month.SEPTEMBER)));
            incomeTotalMonthlyTotals.replace(Month.OCTOBER, incomeTotalMonthlyTotals.get(Month.OCTOBER).add(monthlyTotals.get(Month.OCTOBER)));
            incomeTotalMonthlyTotals.replace(Month.NOVEMBER, incomeTotalMonthlyTotals.get(Month.NOVEMBER).add(monthlyTotals.get(Month.NOVEMBER)));
            incomeTotalMonthlyTotals.replace(Month.DECEMBER, incomeTotalMonthlyTotals.get(Month.DECEMBER).add(monthlyTotals.get(Month.DECEMBER)));
        }

        incomeYearlyTotal = BigDecimal.valueOf(0.00);

        for (BigDecimal monthlyTotal : incomeTotalMonthlyTotals.values()) {
            incomeYearlyTotal = incomeYearlyTotal.add(monthlyTotal);
        }
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

    public Map<Month, BigDecimal> getExpenseTotalMonthlyTotals() {
        return expenseTotalMonthlyTotals;
    }

    public void setExpenseTotalMonthlyTotals(Map<Month, BigDecimal> expenseTotalMonthlyTotals) {
        this.expenseTotalMonthlyTotals = expenseTotalMonthlyTotals;
    }

    public Map<Month, BigDecimal> getIncomeTotalMonthlyTotals() {
        return incomeTotalMonthlyTotals;
    }

    public void setIncomeTotalMonthlyTotals(Map<Month, BigDecimal> incomeTotalMonthlyTotals) {
        this.incomeTotalMonthlyTotals = incomeTotalMonthlyTotals;
    }

    public BigDecimal getExpenseYearlyTotal() {
        return expenseYearlyTotal;
    }

    public void setExpenseYearlyTotal(BigDecimal expenseYearlyTotal) {
        this.expenseYearlyTotal = expenseYearlyTotal;
    }

    public BigDecimal getIncomeYearlyTotal() {
        return incomeYearlyTotal;
    }

    public void setIncomeYearlyTotal(BigDecimal incomeYearlyTotal) {
        this.incomeYearlyTotal = incomeYearlyTotal;
    }
}
