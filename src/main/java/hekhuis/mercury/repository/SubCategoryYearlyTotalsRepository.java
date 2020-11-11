package hekhuis.mercury.repository;

import hekhuis.mercury.entity.category.SubCategoryMonthlyTotals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryYearlyTotalsRepository extends JpaRepository<SubCategoryMonthlyTotals, Long> {

    SubCategoryMonthlyTotals findByMainCategoryIDAndSubCategoryIDAndYear(long mainCategoryId, long subCategoryID, int year);

    List<SubCategoryMonthlyTotals> findAllByMainCategoryIDAndYear(long mainCategoryID, int year);
}
