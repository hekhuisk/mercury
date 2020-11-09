package hekhuis.mercury.repository;

import hekhuis.mercury.entity.category.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    List<SubCategory> findAllByMainCategoryID(long mainCategoryID);
}
