package hekhuis.mercury.entity.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "sub_category_yearly_totals")
@IdClass(SubCategoryYearlyTotalsId.class)
public class SubCategoryYearlyTotals implements Serializable {

    @Id
    @Column(name = "main_category_id", nullable = false)
    private long mainCategoryID;

    @Id
    @Column(name = "sub_category_id", nullable = false)
    private long subCategoryID;

    @Id
    @Column(name = "year")
    private int year;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_type", nullable = false)
    private CategoryType categoryType;

    @Column(name = "january_total")
    private BigDecimal januaryTotal;

    @Column(name = "february_total")
    private BigDecimal februaryTotal;

    @Column(name = "march_total")
    private BigDecimal marchTotal;

    @Column(name = "april_total")
    private BigDecimal aprilTotal;

    @Column(name = "may_total")
    private BigDecimal mayTotal;

    @Column(name = "june_total")
    private BigDecimal juneTotal;

    @Column(name = "july_total")
    private BigDecimal julyTotal;

    @Column(name = "august_total")
    private BigDecimal augustTotal;

    @Column(name = "september_total")
    private BigDecimal septemberTotal;

    @Column(name = "october_total")
    private BigDecimal octoberTotal;

    @Column(name = "november_total")
    private BigDecimal novemberTotal;

    @Column(name = "december_total")
    private BigDecimal decemberTotal;

    @Column(name = "yearly_total")
    private BigDecimal yearlyTotal;

    public SubCategoryYearlyTotals() {}

    public SubCategoryYearlyTotals(long mainCategoryID, long subCategoryID, int year, CategoryType categoryType) {
        this.mainCategoryID = mainCategoryID;
        this.subCategoryID = subCategoryID;
        this.year = year;
        this.categoryType = categoryType;

        januaryTotal = BigDecimal.valueOf(0.00);
        februaryTotal = BigDecimal.valueOf(0.00);
        marchTotal = BigDecimal.valueOf(0.00);
        aprilTotal = BigDecimal.valueOf(0.00);
        mayTotal = BigDecimal.valueOf(0.00);
        juneTotal = BigDecimal.valueOf(0.00);
        julyTotal = BigDecimal.valueOf(0.00);
        augustTotal = BigDecimal.valueOf(0.00);
        septemberTotal = BigDecimal.valueOf(0.00);
        octoberTotal = BigDecimal.valueOf(0.00);
        novemberTotal = BigDecimal.valueOf(0.00);
        decemberTotal = BigDecimal.valueOf(0.00);

        yearlyTotal = BigDecimal.valueOf(0.00);
    }

    public long getMainCategoryID() {
        return mainCategoryID;
    }

    public void setMainCategoryID(long mainCategoryID) {
        this.mainCategoryID = mainCategoryID;
    }

    public long getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(long subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public BigDecimal getJanuaryTotal() {
        return januaryTotal;
    }

    public void setJanuaryTotal(BigDecimal januaryTotal) {
        this.januaryTotal = januaryTotal;
    }

    public BigDecimal getFebruaryTotal() {
        return februaryTotal;
    }

    public void setFebruaryTotal(BigDecimal februaryTotal) {
        this.februaryTotal = februaryTotal;
    }

    public BigDecimal getMarchTotal() {
        return marchTotal;
    }

    public void setMarchTotal(BigDecimal marchTotal) {
        this.marchTotal = marchTotal;
    }

    public BigDecimal getAprilTotal() {
        return aprilTotal;
    }

    public void setAprilTotal(BigDecimal aprilTotal) {
        this.aprilTotal = aprilTotal;
    }

    public BigDecimal getMayTotal() {
        return mayTotal;
    }

    public void setMayTotal(BigDecimal mayTotal) {
        this.mayTotal = mayTotal;
    }

    public BigDecimal getJuneTotal() {
        return juneTotal;
    }

    public void setJuneTotal(BigDecimal juneTotal) {
        this.juneTotal = juneTotal;
    }

    public BigDecimal getJulyTotal() {
        return julyTotal;
    }

    public void setJulyTotal(BigDecimal julyTotal) {
        this.julyTotal = julyTotal;
    }

    public BigDecimal getAugustTotal() {
        return augustTotal;
    }

    public void setAugustTotal(BigDecimal augustTotal) {
        this.augustTotal = augustTotal;
    }

    public BigDecimal getSeptemberTotal() {
        return septemberTotal;
    }

    public void setSeptemberTotal(BigDecimal septemberTotal) {
        this.septemberTotal = septemberTotal;
    }

    public BigDecimal getOctoberTotal() {
        return octoberTotal;
    }

    public void setOctoberTotal(BigDecimal octoberTotal) {
        this.octoberTotal = octoberTotal;
    }

    public BigDecimal getNovemberTotal() {
        return novemberTotal;
    }

    public void setNovemberTotal(BigDecimal novemberTotal) {
        this.novemberTotal = novemberTotal;
    }

    public BigDecimal getDecemberTotal() {
        return decemberTotal;
    }

    public void setDecemberTotal(BigDecimal decemberTotal) {
        this.decemberTotal = decemberTotal;
    }

    public BigDecimal getYearlyTotal() {
        return yearlyTotal;
    }

    public void setYearlyTotal(BigDecimal yearlyTotal) {
        this.yearlyTotal = yearlyTotal;
    }
}
