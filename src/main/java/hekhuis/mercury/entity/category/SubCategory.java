package hekhuis.mercury.entity.category;

import hekhuis.mercury.entity.AuditData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sub_categories")
public class SubCategory extends AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sub_category_id")
    private long subCategoryID;

    @Column(name = "main_category_id", nullable = false)
    private long mainCategoryID;

    @Column(name = "name", nullable = false)
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
