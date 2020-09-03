package hekhuis.mercury.util;

import hekhuis.mercury.entity.User;

public class SecurityUtil {

    public static void validateUserCanEditBudget(User user, int budgetID) throws Exception {
        if (!user.getBudgetIDs().contains(budgetID) && !user.isAdminUser()) {
            throw new Exception("User not authorized");
        }
    }
}
