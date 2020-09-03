package hekhuis.mercury.dao;

import hekhuis.mercury.entity.Expense;
import hekhuis.mercury.entity.User;

import java.util.HashMap;
import java.util.Map;

public class ExpenseDAO {

    public static Map<Long, Expense> expenseMap = new HashMap<>();

    public void createExpense(Expense expense, User user) {
        expenseMap.put(expense.getExpenseID(), expense);
    }

    public Expense getExpense(long expenseID, int budgetID, User user) {
        return expenseMap.get(expenseID);
    }

    public void updateExpense(long expenseID, Expense expense, int budgetID, User user) {
        expenseMap.put(expenseID, expense);
    }

    public void deleteExpense(long expenseID, int budgetID, User user) {
        expenseMap.remove(expenseID);
    }
}
