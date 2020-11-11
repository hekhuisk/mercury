package hekhuis.mercury.repository;

import hekhuis.mercury.entity.category.SubCategoryYearlyTotals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryYearlyTotalsRepository extends JpaRepository<SubCategoryYearlyTotals, Long> {

    SubCategoryYearlyTotals findByMainCategoryIDAndSubCategoryIDAndYear(long mainCategoryId, long subCategoryID, int year);

    List<SubCategoryYearlyTotals> findAllByMainCategoryIDAndYear(long mainCategoryID, int year);
}
