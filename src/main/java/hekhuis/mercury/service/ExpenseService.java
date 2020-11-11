package hekhuis.mercury.service;

import hekhuis.mercury.entity.Expense;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.category.CategoryType;
import hekhuis.mercury.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private OverviewService overviewService;

    public List<Expense> getAllExpensesForUser(long userID) {
        return new ArrayList<>(expenseRepository.findAllByUserID(userID));
    }

    public Expense updateExpense(long expenseID, Expense expense, User user) throws Exception {
        Expense oldExpense = getExpense(expenseID, user);

        removeExpenseFromOverview(oldExpense);

        expense.setUserID(user.getUserID());
        Expense updatedExpense = expenseRepository.save(expense);

        addExpenseToOverview(updatedExpense);

        return updatedExpense;
    }

    public Expense createExpense(Expense expense, User user) throws Exception {
        expense.setUserID(user.getUserID());
        Expense savedExpense = expenseRepository.save(expense);
        addExpenseToOverview(savedExpense);
        return savedExpense;
    }

    public Expense getExpense(long expenseID, User user) throws Exception {
        Expense expense = expenseRepository.findById(expenseID)
                .orElseThrow(() -> new Exception("Expense not found for this id :: " + expenseID));
        return expense;
    }

    public void deleteExpense(long expenseID, User user) throws Exception {
        Expense expense = getExpense(expenseID, user);
        removeExpenseFromOverview(expense);
        expenseRepository.delete(expense);
    }

    private void addExpenseToOverview(Expense expense) throws Exception {
        LocalDate expenseDate = expense.getExpenseDate();

        overviewService.addAmount(expense.getMainCategoryID(),
                                  expense.getSubCategoryID(),
                                  CategoryType.EXPENSE,
                                  expenseDate.getYear(),
                                  expenseDate.getMonth(),
                                  expense.getAmount());
    }

    private void removeExpenseFromOverview(Expense expense) throws Exception {
        LocalDate expenseDate = expense.getExpenseDate();

        overviewService.removeAmount(expense.getMainCategoryID(),
                                     expense.getSubCategoryID(),
                                     CategoryType.EXPENSE,
                                     expenseDate.getYear(),
                                     expenseDate.getMonth(),
                                     expense.getAmount());
    }
}
