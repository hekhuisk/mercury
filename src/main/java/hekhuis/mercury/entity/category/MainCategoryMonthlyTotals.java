package hekhuis.mercury.entity.category;

import java.math.BigDecimal;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainCategoryMonthlyTotals {

    private CategoryType categoryType;
    private long mainCategoryID;
    private List<SubCategoryMonthlyTotals> subCategoryMonthlyTotals;
    private Map<Month, BigDecimal> monthlyTotals;
    private BigDecimal yearlyTotal;

    public MainCategoryMonthlyTotals(long mainCategoryID, CategoryType categoryType, List<SubCategoryMonthlyTotals> subCategoryMonthlyTotals) {
        this.mainCategoryID = mainCategoryID;
        this.categoryType = categoryType;
        this.subCategoryMonthlyTotals = subCategoryMonthlyTotals;

        monthlyTotals = new HashMap<>();

        for (Month month : Month.values()) {
            monthlyTotals.put(month, BigDecimal.valueOf(0.00));
        }

        for (SubCategoryMonthlyTotals scmt : subCategoryMonthlyTotals) {
            monthlyTotals.replace(Month.JANUARY, monthlyTotals.get(Month.JANUARY).add(scmt.getJanuaryTotal()));
            monthlyTotals.replace(Month.FEBRUARY, monthlyTotals.get(Month.FEBRUARY).add(scmt.getFebruaryTotal()));
            monthlyTotals.replace(Month.MARCH, monthlyTotals.get(Month.MARCH).add(scmt.getMarchTotal()));
            monthlyTotals.replace(Month.APRIL, monthlyTotals.get(Month.APRIL).add(scmt.getAprilTotal()));
            monthlyTotals.replace(Month.MAY, monthlyTotals.get(Month.MAY).add(scmt.getMayTotal()));
            monthlyTotals.replace(Month.JUNE, monthlyTotals.get(Month.JUNE).add(scmt.getJuneTotal()));
            monthlyTotals.replace(Month.JULY, monthlyTotals.get(Month.JULY).add(scmt.getJulyTotal()));
            monthlyTotals.replace(Month.AUGUST, monthlyTotals.get(Month.AUGUST).add(scmt.getAugustTotal()));
            monthlyTotals.replace(Month.SEPTEMBER, monthlyTotals.get(Month.SEPTEMBER).add(scmt.getSeptemberTotal()));
            monthlyTotals.replace(Month.OCTOBER, monthlyTotals.get(Month.OCTOBER).add(scmt.getOctoberTotal()));
            monthlyTotals.replace(Month.NOVEMBER, monthlyTotals.get(Month.NOVEMBER).add(scmt.getNovemberTotal()));
            monthlyTotals.replace(Month.DECEMBER, monthlyTotals.get(Month.DECEMBER).add(scmt.getDecemberTotal()));
        }

        yearlyTotal = BigDecimal.valueOf(0.00);
        for (BigDecimal monthlyTotal : monthlyTotals.values()) {
            yearlyTotal = yearlyTotal.add(monthlyTotal);
        }
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public long getMainCategoryID() {
        return mainCategoryID;
    }

    public void setMainCategoryID(long mainCategoryID) {
        this.mainCategoryID = mainCategoryID;
    }

    public List<SubCategoryMonthlyTotals> getSubCategoryMonthlyTotals() {
        return subCategoryMonthlyTotals;
    }

    public void setSubCategoryMonthlyTotals(List<SubCategoryMonthlyTotals> subCategoryMonthlyTotals) {
        this.subCategoryMonthlyTotals = subCategoryMonthlyTotals;
    }

    public Map<Month, BigDecimal> getMonthlyTotals() {
        return monthlyTotals;
    }

    public void setMonthlyTotals(Map<Month, BigDecimal> monthlyTotals) {
        this.monthlyTotals = monthlyTotals;
    }

    public BigDecimal getYearlyTotal() {
        return yearlyTotal;
    }

    public void setYearlyTotal(BigDecimal yearlyTotal) {
        this.yearlyTotal = yearlyTotal;
    }
}
