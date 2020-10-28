package hekhuis.mercury.api;

import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.category.CategoryGrouping;
import hekhuis.mercury.entity.category.CategoryType;
import hekhuis.mercury.entity.category.MainCategory;
import hekhuis.mercury.entity.category.SubCategory;
import hekhuis.mercury.service.CategoryService;
import hekhuis.mercury.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/category")
public class CategoryAPI {
    private static final Logger logger = LoggerFactory.getLogger(CategoryAPI.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMainCategory(MainCategory mainCategory) {
        try {
            User user = userService.getUser(1);
            MainCategory savedMainCategory = categoryService.saveMainCategory(mainCategory, user);
            return Response.ok(savedMainCategory).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{mainCategoryID}")
    public Response createSubCategory(@PathParam("mainCategoryID") long mainCategoryID, SubCategory subCategory) {
        try {
            User user = userService.getUser(1);
            subCategory.setMainCategoryID(mainCategoryID);
            SubCategory savedSubCategory = categoryService.saveSubCategory(subCategory, user);
            return Response.ok(savedSubCategory).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryGroupings(@QueryParam("categoryType") CategoryType categoryType) {
        try {
            User user = userService.getUser(1);
            List<CategoryGrouping> categoryGroupings = categoryService.getCategoryGroupingsByType(categoryType, user);
            return Response.ok(categoryGroupings).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }
}
