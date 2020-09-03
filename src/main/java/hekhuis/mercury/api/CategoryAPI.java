package hekhuis.mercury.api;

import hekhuis.mercury.entity.category.CategoryGrouping;
import hekhuis.mercury.entity.category.MainCategory;
import hekhuis.mercury.entity.category.SubCategory;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/category")
public class CategoryAPI {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createMajorCategory(MainCategory mainCategory) {

    }

    public void createSubCategory(SubCategory subCategory) {

    }

    public List<CategoryGrouping> getCategories() {
        return null;
    }
}
