package hekhuis.mercury.service;

import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.category.CategoryGrouping;
import hekhuis.mercury.entity.category.CategoryType;
import hekhuis.mercury.entity.category.MainCategory;
import hekhuis.mercury.entity.category.SubCategory;
import hekhuis.mercury.repository.MainCategoryRepository;
import hekhuis.mercury.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    private MainCategoryRepository mainCategoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    private static Map<Long, MainCategory> mainCategoryMap = new HashMap<>();
    private static Map<Long, SubCategory> subCategoryMap = new HashMap<>();

    private static long newMainCategoryID = 1;
    private static long newSubCategoryID = 1;

    public List<CategoryGrouping> getCategoryGroupingsByType(CategoryType categoryType, User user) throws Exception {
        if (categoryType == null || user == null) {
            throw new Exception("Invalid parameters");
        }

        List<CategoryGrouping> categoryGroupings = new ArrayList<>();

        List<MainCategory> mainCategories = mainCategoryRepository.findAllByUserIDAndAndCategoryType(user.getUserID(), categoryType);

        for (MainCategory mainCategory : mainCategories) {
            CategoryGrouping categoryGrouping = new CategoryGrouping();
            categoryGrouping.setCategoryType(categoryType);
            categoryGrouping.setMainCategory(mainCategory);

            List<SubCategory> subCategories = subCategoryRepository.findAllByMainCategoryID(mainCategory.getMainCategoryID());
            categoryGrouping.setSubCategories(subCategories);

            categoryGroupings.add(categoryGrouping);
        }

        return categoryGroupings;
    }

    public MainCategory saveMainCategory(MainCategory mainCategory, User user) throws Exception {
        mainCategory.setUserID(user.getUserID());
        return mainCategoryRepository.save(mainCategory);
    }

    public SubCategory saveSubCategory(SubCategory subCategory, User user) throws Exception {
        return subCategoryRepository.save(subCategory);
    }
}
