package hekhuis.mercury.dao;

import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.category.CategoryGrouping;
import hekhuis.mercury.entity.category.CategoryType;
import hekhuis.mercury.entity.category.MainCategory;
import hekhuis.mercury.entity.category.SubCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDAO {

    public static Map<Integer, MainCategory> mainCategoryMap = new HashMap<>();
    public static Map<Integer, SubCategory> subCategoryMap = new HashMap<>();

    public void createMainCategory(MainCategory mainCategory, User user) {

    }

    public void createSubCategory(SubCategory subCategory, User user) {

    }

    public CategoryGrouping getCategoryGroupingByType() {
        return null;
    }

    public List<CategoryGrouping> getCategoryGroupingsByType(CategoryType categoryType, int budgetID, User user) {
        return null;
    }
}
