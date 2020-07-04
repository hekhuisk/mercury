package hekhuis.mercury.entity.display;

import hekhuis.mercury.entity.category.CategoryType;

import java.util.List;

public class MainCategoryYearlyView extends YearlyRowView {

    private int mainCategoryID;

    private List<SubCategoryYearlyView> subCategoryYearlyViews;

    private CategoryType categoryType;
}
