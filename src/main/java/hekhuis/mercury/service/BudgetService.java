package hekhuis.mercury.service;

import hekhuis.mercury.entity.budget.Budget;

import java.util.HashMap;
import java.util.Map;

public class BudgetService {

    private static Map<Integer, Budget> budgetMap = new HashMap<>();

    public void createBudget(Budget budget) {
        budgetMap.put(budget.getBudgetID(), budget);
    }

    public Budget getBudget(int budgetID) {
        return budgetMap.get(budgetID);
    }

    public void updateBudget(int budgetID, Budget budget) {
        budgetMap.put(budgetID, budget);
    }

    public void deleteBudget(int budgetID) {
        budgetMap.remove(budgetID);
    }
}
