package hekhuis.mercury.dao;

import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.budget.Budget;

import java.util.HashMap;
import java.util.Map;

public class BudgetDAO {

    public static Map<Integer, Budget> budgetMap = new HashMap<>();

    public void createBudget(Budget budget, User user) {
        budgetMap.put(budget.getBudgetID(), budget);
    }

    public Budget getBudget(int budgetID, User user) {
        return budgetMap.get(budgetID);
    }

    public void updateBudget(int budgetID, Budget budget, User user) {
        budgetMap.replace(budgetID, budget);
    }

    public void deleteBudget(int budgetID, User user) {
        budgetMap.remove(budgetID);
    }
}
