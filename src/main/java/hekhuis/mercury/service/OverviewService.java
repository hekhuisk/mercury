package hekhuis.mercury.service;

import hekhuis.mercury.entity.Overview;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.category.CategoryGrouping;
import hekhuis.mercury.entity.category.CategoryType;
import hekhuis.mercury.entity.category.MainCategoryMonthlyTotals;
import hekhuis.mercury.entity.category.SubCategory;
import hekhuis.mercury.entity.category.SubCategoryMonthlyTotals;
import hekhuis.mercury.repository.SubCategoryYearlyTotalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class OverviewService {

    @Autowired
    private SubCategoryYearlyTotalsRepository subCategoryYearlyTotalsRepository;

    @Autowired
    private CategoryService categoryService;

    private SubCategoryMonthlyTotals getSubCategoryMonthlyTotals(long mainCategoryID, long subCategoryID, CategoryType categoryType, int year) {
        SubCategoryMonthlyTotals subCategoryMonthlyTotals = subCategoryYearlyTotalsRepository.findByMainCategoryIDAndSubCategoryIDAndYear(mainCategoryID, subCategoryID, year);
        if (subCategoryMonthlyTotals == null) {
            createSubCategoryYearlyTotalsForYear(mainCategoryID, subCategoryID, categoryType, year);
        }
        subCategoryMonthlyTotals = subCategoryYearlyTotalsRepository.findByMainCategoryIDAndSubCategoryIDAndYear(mainCategoryID, subCategoryID, year);
        return subCategoryMonthlyTotals;
    }

    private void createSubCategoryYearlyTotalsForYear(long mainCategoryID, long subCategoryID, CategoryType categoryType, int year) {
        SubCategoryMonthlyTotals subCategoryMonthlyTotals = new SubCategoryMonthlyTotals(mainCategoryID, subCategoryID, year, categoryType);
        subCategoryYearlyTotalsRepository.save(subCategoryMonthlyTotals);
    }

    public void addAmount(long mainCategoryID, long subCategoryID, CategoryType categoryType, int year, Month month, BigDecimal amount) throws Exception {
        SubCategoryMonthlyTotals subCategoryMonthlyTotals = getSubCategoryMonthlyTotals(mainCategoryID, subCategoryID, categoryType, year);

        switch (month) {
            case JANUARY:
                subCategoryMonthlyTotals.setJanuaryTotal(subCategoryMonthlyTotals.getJanuaryTotal().add(amount));
                break;
            case FEBRUARY:
                subCategoryMonthlyTotals.setFebruaryTotal(subCategoryMonthlyTotals.getFebruaryTotal().add(amount));
                break;
            case MARCH:
                subCategoryMonthlyTotals.setMarchTotal(subCategoryMonthlyTotals.getMarchTotal().add(amount));
                break;
            case APRIL:
                subCategoryMonthlyTotals.setAprilTotal(subCategoryMonthlyTotals.getAprilTotal().add(amount));
                break;
            case MAY:
                subCategoryMonthlyTotals.setMayTotal(subCategoryMonthlyTotals.getMayTotal().add(amount));
                break;
            case JUNE:
                subCategoryMonthlyTotals.setJuneTotal(subCategoryMonthlyTotals.getJuneTotal().add(amount));
                break;
            case JULY:
                subCategoryMonthlyTotals.setJulyTotal(subCategoryMonthlyTotals.getJulyTotal().add(amount));
                break;
            case AUGUST:
                subCategoryMonthlyTotals.setAugustTotal(subCategoryMonthlyTotals.getAugustTotal().add(amount));
                break;
            case SEPTEMBER:
                subCategoryMonthlyTotals.setSeptemberTotal(subCategoryMonthlyTotals.getSeptemberTotal().add(amount));
                break;
            case OCTOBER:
                subCategoryMonthlyTotals.setOctoberTotal(subCategoryMonthlyTotals.getOctoberTotal().add(amount));
                break;
            case NOVEMBER:
                subCategoryMonthlyTotals.setNovemberTotal(subCategoryMonthlyTotals.getNovemberTotal().add(amount));
                break;
            case DECEMBER:
                subCategoryMonthlyTotals.setDecemberTotal(subCategoryMonthlyTotals.getDecemberTotal().add(amount));
                break;
            default:
                throw new Exception("Invalid month");
        }

        subCategoryMonthlyTotals.setYearlyTotal(subCategoryMonthlyTotals.getYearlyTotal().add(amount));

        subCategoryYearlyTotalsRepository.save(subCategoryMonthlyTotals);
    }

    public void removeAmount(long mainCategoryID, long subCategoryID, CategoryType categoryType, int year, Month month, BigDecimal amount) throws Exception {
        SubCategoryMonthlyTotals subCategoryMonthlyTotals = getSubCategoryMonthlyTotals(mainCategoryID, subCategoryID, categoryType, year);

        switch (month) {
            case JANUARY:
                subCategoryMonthlyTotals.setJanuaryTotal(subCategoryMonthlyTotals.getJanuaryTotal().subtract(amount));
                break;
            case FEBRUARY:
                subCategoryMonthlyTotals.setFebruaryTotal(subCategoryMonthlyTotals.getFebruaryTotal().subtract(amount));
                break;
            case MARCH:
                subCategoryMonthlyTotals.setMarchTotal(subCategoryMonthlyTotals.getMarchTotal().subtract(amount));
                break;
            case APRIL:
                subCategoryMonthlyTotals.setAprilTotal(subCategoryMonthlyTotals.getAprilTotal().subtract(amount));
                break;
            case MAY:
                subCategoryMonthlyTotals.setMayTotal(subCategoryMonthlyTotals.getMayTotal().subtract(amount));
                break;
            case JUNE:
                subCategoryMonthlyTotals.setJuneTotal(subCategoryMonthlyTotals.getJuneTotal().subtract(amount));
                break;
            case JULY:
                subCategoryMonthlyTotals.setJulyTotal(subCategoryMonthlyTotals.getJulyTotal().subtract(amount));
                break;
            case AUGUST:
                subCategoryMonthlyTotals.setAugustTotal(subCategoryMonthlyTotals.getAugustTotal().subtract(amount));
                break;
            case SEPTEMBER:
                subCategoryMonthlyTotals.setSeptemberTotal(subCategoryMonthlyTotals.getSeptemberTotal().subtract(amount));
                break;
            case OCTOBER:
                subCategoryMonthlyTotals.setOctoberTotal(subCategoryMonthlyTotals.getOctoberTotal().subtract(amount));
                break;
            case NOVEMBER:
                subCategoryMonthlyTotals.setNovemberTotal(subCategoryMonthlyTotals.getNovemberTotal().subtract(amount));
                break;
            case DECEMBER:
                subCategoryMonthlyTotals.setDecemberTotal(subCategoryMonthlyTotals.getDecemberTotal().subtract(amount));
                break;
            default:
                throw new Exception("Invalid month");
        }

        subCategoryMonthlyTotals.setYearlyTotal(subCategoryMonthlyTotals.getYearlyTotal().subtract(amount));

        subCategoryYearlyTotalsRepository.save(subCategoryMonthlyTotals);
    }

    private List<MainCategoryMonthlyTotals> getMainCategoryMonthlyTotalsForCategoryType(int year, CategoryType categoryType, User user) throws Exception {
        List<MainCategoryMonthlyTotals> monthlyTotals = new ArrayList<>();

        for (CategoryGrouping categoryGrouping : categoryService.getCategoryGroupingsByType(categoryType, user)) {
            long mainCategoryID = categoryGrouping.getMainCategory().getMainCategoryID();

            List<SubCategoryMonthlyTotals> subCategoryMonthlyTotalsList = new ArrayList<>();

            for (SubCategory subCategory : categoryGrouping.getSubCategories()) {
                long subCategoryID = subCategory.getSubCategoryID();
                SubCategoryMonthlyTotals subCategoryMonthlyTotals = getSubCategoryMonthlyTotals(mainCategoryID, subCategoryID, categoryGrouping.getCategoryType(), year);
                subCategoryMonthlyTotalsList.add(subCategoryMonthlyTotals);
            }

            MainCategoryMonthlyTotals mainCategoryMonthlyTotals = new MainCategoryMonthlyTotals(mainCategoryID, categoryType, subCategoryMonthlyTotalsList);
            monthlyTotals.add(mainCategoryMonthlyTotals);
        }

        return monthlyTotals;
    }

    public Overview getOverviewForYear(int year, User user) throws Exception {
        List<MainCategoryMonthlyTotals> expenseMonthlyTotals = getMainCategoryMonthlyTotalsForCategoryType(year, CategoryType.EXPENSE, user);
        List<MainCategoryMonthlyTotals> incomeMonthlyTotals = getMainCategoryMonthlyTotalsForCategoryType(year, CategoryType.INCOME, user);

        return new Overview(year, expenseMonthlyTotals, incomeMonthlyTotals);
    }
}
