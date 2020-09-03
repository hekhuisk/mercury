package hekhuis.mercury.service;

import hekhuis.mercury.dao.BudgetDAO;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.budget.Budget;
import hekhuis.mercury.util.SecurityUtil;

public class BudgetService {

    public static final BudgetDAO budgetDAO = new BudgetDAO();

    public void createBudget(Budget budget, User user) {
        budgetDAO.createBudget(budget, user);
    }

    public Budget getBudget(int budgetID, User user) throws Exception {
        SecurityUtil.validateUserCanEditBudget(user, budgetID);
        return budgetDAO.getBudget(budgetID, user);
    }

    public void updateBudget(int budgetID, Budget budget, User user) throws Exception {
        if (budgetID != budget.getBudgetID()) {
            throw new Exception("Invalid budget ID");
        }
        SecurityUtil.validateUserCanEditBudget(user, budgetID);

        budgetDAO.updateBudget(budgetID, budget, user);
    }

    public void deleteBudget(int budgetID, User user) throws Exception {
        SecurityUtil.validateUserCanEditBudget(user, budgetID);
        budgetDAO.deleteBudget(budgetID, user);
    }
}
