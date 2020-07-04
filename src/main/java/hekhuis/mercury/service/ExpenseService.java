package hekhuis.mercury.service;

import hekhuis.mercury.entity.Expense;
import hekhuis.mercury.entity.ExpenseSearchQuery;

import java.time.Month;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseService {

    private static Map<Integer, Expense> expenseMap = new HashMap<>();

    public void createExpense(Expense expense) {
        expenseMap.put(expense.getExpenseID(), expense);
    }

    public Expense getExpense(int expenseID) {
        return expenseMap.get(expenseID);
    }

    public void updateExpense(int expenseID, Expense expense) {
        expenseMap.put(expenseID, expense);
    }

    public void deleteExpense(int expenseID) {
        expenseMap.remove(expenseID);
    }

    public List<Expense> getExpenses(int month, int year) {
        List<Expense> expenses = new ArrayList<>();

        for (Expense expense : expenseMap.values()) {
            ZonedDateTime expenseDate = expense.getExpenseDate();
            if (expenseDate.getMonth() == Month.of(month) && expenseDate.getYear() == year) {
                expenses.add(expense);
            }
        }

        return expenses;
    }

    public List<Expense> getExpenses(ExpenseSearchQuery searchQuery) {
        return new ArrayList<>();
    }
}
