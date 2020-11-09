package hekhuis.mercury.service;

import hekhuis.mercury.entity.Expense;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpensesForUser(long userID) {
        return new ArrayList<>(expenseRepository.findAllByUserID(userID));
    }

    public Expense updateExpense(long expenseID, Expense expense, User user) throws Exception {
        getExpense(expenseID, user);
        expense.setUserID(expenseID);
        return expenseRepository.save(expense);
    }

    public Expense createExpense(Expense expense, User user) {
        return expenseRepository.save(expense);
    }

    public Expense getExpense(long expenseID, User user) throws Exception {
        Expense expense = expenseRepository.findById(expenseID)
                .orElseThrow(() -> new Exception("Expense not found for this id :: " + expenseID));
        return expense;
    }

    public void deleteExpense(long expenseID, User user) throws Exception {
        Expense expense = getExpense(expenseID, user);
        expenseRepository.delete(expense);
    }
}
