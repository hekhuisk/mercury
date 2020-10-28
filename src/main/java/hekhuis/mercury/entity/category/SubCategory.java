package hekhuis.mercury.entity.category;

import hekhuis.mercury.entity.AuditData;

public class SubCategory extends AuditData {

    private long subCategoryID;
    private long mainCategoryID;
    private String name;

    public long getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(long subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public long getMainCategoryID() {
        return mainCategoryID;
    }

    public void setMainCategoryID(long mainCategoryID) {
        this.mainCategoryID = mainCategoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
