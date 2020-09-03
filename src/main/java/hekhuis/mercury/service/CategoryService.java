package hekhuis.mercury.service;

import hekhuis.mercury.dao.CategoryDAO;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.category.CategoryGrouping;
import hekhuis.mercury.entity.category.CategoryType;
import hekhuis.mercury.entity.category.MainCategory;
import hekhuis.mercury.entity.category.SubCategory;
import hekhuis.mercury.util.SecurityUtil;

import java.util.List;

public class CategoryService {

    public static final CategoryDAO categoryDAO = new CategoryDAO();

    public void createMainCategory(MainCategory mainCategory, User user) throws Exception {
        SecurityUtil.validateUserCanEditBudget(user, mainCategory.getBudgetID());
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
