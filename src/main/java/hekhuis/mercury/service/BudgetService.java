package hekhuis.mercury.service;

import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.budget.Budget;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BudgetService {

    private static Map<Long, Budget> budgetMap = new HashMap<>();

    private static long newBudgetID = 1;

    public Budget saveBudget(Budget budget, User user) throws Exception {
        Budget existingBudget = budgetMap.get(budget.getBudgetID());
        if (existingBudget != null) {
            if (existingBudget.getBudgetID() != budget.getBudgetID()) {
                throw new Exception("Invalid budget ID");
            }
            validateUserCanAccessBudget(existingBudget.getBudgetID(), user);
            budgetMap.replace(existingBudget.getBudgetID(), budget);
        } else {
            budget.setUserID(user.getUserID());
            budget.setBudgetID(newBudgetID++);
            budgetMap.put(budget.getBudgetID(), budget);
        }

        return budget;
    }

    public Budget getBudget(long budgetID, User user) throws Exception {
        validateUserCanAccessBudget(budgetID, user);
        return budgetMap.get(budgetID);
    }

    public void deleteBudget(long budgetID, User user) throws Exception {
        validateUserCanAccessBudget(budgetID, user);
        budgetMap.remove(budgetID);
    }

    public List<Budget> getAllBudgets() {
        return (List<Budget>) budgetMap.values();
    }

    public void validateUserCanAccessBudget(long budgetID, User user) throws Exception {
        Budget budget = budgetMap.get(budgetID);
        if (budget.getUserID() != user.getUserID()) {
            throw new Exception("User does not have access to this budget");
        }
    }
}
