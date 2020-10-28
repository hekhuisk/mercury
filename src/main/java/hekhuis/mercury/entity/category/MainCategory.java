package hekhuis.mercury.entity.category;

import hekhuis.mercury.entity.AuditData;

public class MainCategory extends AuditData {

    private long mainCategoryID;
    private long userID;
    private String name;
    private CategoryType categoryType;

    public long getMainCategoryID() {
        return mainCategoryID;
    }

    public void setMainCategoryID(long mainCategoryID) {
        this.mainCategoryID = mainCategoryID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
}
