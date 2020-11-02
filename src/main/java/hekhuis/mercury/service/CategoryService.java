package hekhuis.mercury.service;

import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.category.CategoryGrouping;
import hekhuis.mercury.entity.category.CategoryType;
import hekhuis.mercury.entity.category.MainCategory;
import hekhuis.mercury.entity.category.SubCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    private static Map<Long, MainCategory> mainCategoryMap = new HashMap<>();
    private static Map<Long, SubCategory> subCategoryMap = new HashMap<>();

    private static long newMainCategoryID = 1;
    private static long newSubCategoryID = 1;

    public List<CategoryGrouping> getCategoryGroupingsByType(CategoryType categoryType, User user) throws Exception {
        if (categoryType == null || user == null) {
            throw new Exception("Invalid parameters");
        }

        List<CategoryGrouping> categoryGroupings = new ArrayList<>();

        List<MainCategory> mainCategories = new ArrayList<>();

        // Find all the main categories for the user
        for (MainCategory mainCategory : mainCategoryMap.values()) {
            if (mainCategory.getUserID() == user.getUserID() && mainCategory.getCategoryType() == categoryType) {
                mainCategories.add(mainCategory);
            }
        }

        for (MainCategory mainCategory : mainCategories) {
            CategoryGrouping categoryGrouping = new CategoryGrouping();
            categoryGrouping.setCategoryType(categoryType);
            categoryGrouping.setMainCategory(mainCategory);

            List<SubCategory> subCategories = new ArrayList<>();

            for (SubCategory subCategory : subCategoryMap.values()) {
                if (subCategory.getMainCategoryID() == mainCategory.getMainCategoryID()) {
                    subCategories.add(subCategory);
                }
            }

            categoryGrouping.setSubCategories(subCategories);

            categoryGroupings.add(categoryGrouping);
        }

        return categoryGroupings;
    }

    public MainCategory saveMainCategory(MainCategory mainCategory, User user) throws Exception {
        if (mainCategory == null || user == null) {
            throw new Exception("Invalid parameters");
        }

        MainCategory existingMainCategory = mainCategoryMap.get(mainCategory.getMainCategoryID());
        if (existingMainCategory != null) {
            if (existingMainCategory.getMainCategoryID() != mainCategory.getMainCategoryID()) {
                throw new Exception("Invalid main category ID");
            }
            validateUserCanAccessMainCategory(existingMainCategory.getMainCategoryID(), user);
            mainCategoryMap.replace(existingMainCategory.getMainCategoryID(), mainCategory);
        } else {
            mainCategory.setUserID(user.getUserID());
            mainCategory.setMainCategoryID(newMainCategoryID++);
            mainCategoryMap.put(mainCategory.getMainCategoryID(), mainCategory);
        }

        return mainCategory;
    }

    public void validateUserCanAccessMainCategory(long mainCategoryID, User user) throws Exception {
        MainCategory mainCategory = mainCategoryMap.get(mainCategoryID);
        if (mainCategory.getUserID() != user.getUserID()) {
            throw new Exception("User does not have access to this main category");
        }
    }

    public SubCategory saveSubCategory(SubCategory subCategory, User user) throws Exception {
        if (subCategory == null || user == null) {
            throw new Exception("Invalid parameters");
        }

        validateUserCanAccessMainCategory(subCategory.getMainCategoryID(), user);

        SubCategory existingSubCategory = subCategoryMap.get(subCategory.getSubCategoryID());
        if (existingSubCategory != null) {
            if (existingSubCategory.getSubCategoryID() != subCategory.getSubCategoryID()) {
                throw new Exception("Invalid sub category ID");
            }
            subCategoryMap.replace(existingSubCategory.getSubCategoryID(), subCategory);
        } else {
            subCategory.setSubCategoryID(newSubCategoryID++);
            subCategoryMap.put(subCategory.getSubCategoryID(), subCategory);
        }

        return subCategory;
    }
}
