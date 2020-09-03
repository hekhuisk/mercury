package hekhuis.mercury.entity.category;

import hekhuis.mercury.entity.AuditData;

public class SubCategory extends AuditData {

    private int subCategoryID;
    private int mainCategoryID;
    private String name;

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public int getMainCategoryID() {
        return mainCategoryID;
    }

    public void setMainCategoryID(int mainCategoryID) {
        this.mainCategoryID = mainCategoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
