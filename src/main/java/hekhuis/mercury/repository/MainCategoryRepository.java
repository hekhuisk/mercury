package hekhuis.mercury.repository;

import hekhuis.mercury.entity.category.CategoryType;
import hekhuis.mercury.entity.category.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Long> {

    List<MainCategory> findAllByUserIDAndAndCategoryType(long userID, CategoryType categoryType);
}
