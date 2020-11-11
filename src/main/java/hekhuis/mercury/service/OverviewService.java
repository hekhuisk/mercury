package hekhuis.mercury.service;

import hekhuis.mercury.entity.category.CategoryType;
import hekhuis.mercury.entity.category.SubCategoryYearlyTotals;
import hekhuis.mercury.repository.SubCategoryYearlyTotalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Month;

@Service
public class OverviewService {

    @Autowired
    private SubCategoryYearlyTotalsRepository subCategoryYearlyTotalsRepository;

    private void createSubCategoryYearlyTotalsForYear(long mainCategoryID, long subCategoryID, CategoryType categoryType, int year) {
        SubCategoryYearlyTotals subCategoryYearlyTotals = new SubCategoryYearlyTotals(mainCategoryID, subCategoryID, year, categoryType);
        subCategoryYearlyTotalsRepository.save(subCategoryYearlyTotals);
    }

    public void addAmount(long mainCategoryID, long subCategoryID, CategoryType categoryType, int year, Month month, BigDecimal amount) throws Exception {
        SubCategoryYearlyTotals subCategoryYearlyTotals = subCategoryYearlyTotalsRepository.findByMainCategoryIDAndSubCategoryIDAndYear(mainCategoryID, subCategoryID, year);
        if (subCategoryYearlyTotals == null) {
            createSubCategoryYearlyTotalsForYear(mainCategoryID, subCategoryID, categoryType, year);
        }
        subCategoryYearlyTotals = subCategoryYearlyTotalsRepository.findByMainCategoryIDAndSubCategoryIDAndYear(mainCategoryID, subCategoryID, year);

        switch (month) {
            case JANUARY:
                subCategoryYearlyTotals.setJanuaryTotal(subCategoryYearlyTotals.getJanuaryTotal().add(amount));
                break;
            case FEBRUARY:
                subCategoryYearlyTotals.setFebruaryTotal(subCategoryYearlyTotals.getFebruaryTotal().add(amount));
                break;
            case MARCH:
                subCategoryYearlyTotals.setMarchTotal(subCategoryYearlyTotals.getMarchTotal().add(amount));
                break;
            case APRIL:
                subCategoryYearlyTotals.setAprilTotal(subCategoryYearlyTotals.getAprilTotal().add(amount));
                break;
            case MAY:
                subCategoryYearlyTotals.setMayTotal(subCategoryYearlyTotals.getMayTotal().add(amount));
                break;
            case JUNE:
                subCategoryYearlyTotals.setJuneTotal(subCategoryYearlyTotals.getJuneTotal().add(amount));
                break;
            case JULY:
                subCategoryYearlyTotals.setJulyTotal(subCategoryYearlyTotals.getJulyTotal().add(amount));
                break;
            case AUGUST:
                subCategoryYearlyTotals.setAugustTotal(subCategoryYearlyTotals.getAugustTotal().add(amount));
                break;
            case SEPTEMBER:
                subCategoryYearlyTotals.setSeptemberTotal(subCategoryYearlyTotals.getSeptemberTotal().add(amount));
                break;
            case OCTOBER:
                subCategoryYearlyTotals.setOctoberTotal(subCategoryYearlyTotals.getOctoberTotal().add(amount));
                break;
            case NOVEMBER:
                subCategoryYearlyTotals.setNovemberTotal(subCategoryYearlyTotals.getNovemberTotal().add(amount));
                break;
            case DECEMBER:
                subCategoryYearlyTotals.setDecemberTotal(subCategoryYearlyTotals.getDecemberTotal().add(amount));
                break;
            default:
                throw new Exception("Invalid month");
        }

        subCategoryYearlyTotals.setYearlyTotal(subCategoryYearlyTotals.getYearlyTotal().add(amount));

        subCategoryYearlyTotalsRepository.save(subCategoryYearlyTotals);
    }

    public void removeAmount(long mainCategoryID, long subCategoryID, CategoryType categoryType, int year, Month month, BigDecimal amount) throws Exception {
        SubCategoryYearlyTotals subCategoryYearlyTotals = subCategoryYearlyTotalsRepository.findByMainCategoryIDAndSubCategoryIDAndYear(mainCategoryID, subCategoryID, year);
        if (subCategoryYearlyTotals == null) {
            createSubCategoryYearlyTotalsForYear(mainCategoryID, subCategoryID, categoryType, year);
        }
        subCategoryYearlyTotals = subCategoryYearlyTotalsRepository.findByMainCategoryIDAndSubCategoryIDAndYear(mainCategoryID, subCategoryID, year);

        switch (month) {
            case JANUARY:
                subCategoryYearlyTotals.setJanuaryTotal(subCategoryYearlyTotals.getJanuaryTotal().subtract(amount));
                break;
            case FEBRUARY:
                subCategoryYearlyTotals.setFebruaryTotal(subCategoryYearlyTotals.getFebruaryTotal().subtract(amount));
                break;
            case MARCH:
                subCategoryYearlyTotals.setMarchTotal(subCategoryYearlyTotals.getMarchTotal().subtract(amount));
                break;
            case APRIL:
                subCategoryYearlyTotals.setAprilTotal(subCategoryYearlyTotals.getAprilTotal().subtract(amount));
                break;
            case MAY:
                subCategoryYearlyTotals.setMayTotal(subCategoryYearlyTotals.getMayTotal().subtract(amount));
                break;
            case JUNE:
                subCategoryYearlyTotals.setJuneTotal(subCategoryYearlyTotals.getJuneTotal().subtract(amount));
                break;
            case JULY:
                subCategoryYearlyTotals.setJulyTotal(subCategoryYearlyTotals.getJulyTotal().subtract(amount));
                break;
            case AUGUST:
                subCategoryYearlyTotals.setAugustTotal(subCategoryYearlyTotals.getAugustTotal().subtract(amount));
                break;
            case SEPTEMBER:
                subCategoryYearlyTotals.setSeptemberTotal(subCategoryYearlyTotals.getSeptemberTotal().subtract(amount));
                break;
            case OCTOBER:
                subCategoryYearlyTotals.setOctoberTotal(subCategoryYearlyTotals.getOctoberTotal().subtract(amount));
                break;
            case NOVEMBER:
                subCategoryYearlyTotals.setNovemberTotal(subCategoryYearlyTotals.getNovemberTotal().subtract(amount));
                break;
            case DECEMBER:
                subCategoryYearlyTotals.setDecemberTotal(subCategoryYearlyTotals.getDecemberTotal().subtract(amount));
                break;
            default:
                throw new Exception("Invalid month");
        }

        subCategoryYearlyTotals.setYearlyTotal(subCategoryYearlyTotals.getYearlyTotal().subtract(amount));

        subCategoryYearlyTotalsRepository.save(subCategoryYearlyTotals);
    }
}
