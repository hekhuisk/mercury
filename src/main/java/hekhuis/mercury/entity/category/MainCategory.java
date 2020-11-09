package hekhuis.mercury.entity.category;

import hekhuis.mercury.entity.AuditData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "main_categories")
public class MainCategory extends AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "main_category_id")
    private long mainCategoryID;

    @Column(name = "user_id", nullable = false)
    private long userID;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_type", nullable = false)
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
