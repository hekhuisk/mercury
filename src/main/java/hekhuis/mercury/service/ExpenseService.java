package hekhuis.mercury.service;

import hekhuis.mercury.entity.Expense;
import hekhuis.mercury.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense getExpense(long id) {
        return expenseRepository.findById(id).get();
    }

    public void deleteExpense(long id) {
        expenseRepository.deleteById(id);
    }

    //    public static final ExpenseDAO expenseDAO = new ExpenseDAO();

//
//    public void createExpense(Expense expense, User user) throws Exception {
//        SecurityUtil.validateUserCanEditBudget(user, expense.getBudgetID());
//        expenseDAO.createExpense(expense, user);
//    }
//
//    public Expense getExpense(int expenseID, int budgetID, User user) throws Exception {
//        SecurityUtil.validateUserCanEditBudget(user, budgetID);
//        return expenseDAO.getExpense(expenseID, budgetID, user);
//    }
//
//    public void updateExpense(int expenseID, Expense expense, User user) throws Exception {
//        if (expenseID != expense.getExpenseID()) {
//            throw new Exception();
//        }
//        SecurityUtil.validateUserCanEditBudget(user, expense.getBudgetID());
//        expenseDAO.updateExpense(expenseID, expense, expense.getBudgetID(), user);
//    }
//
//    public void deleteExpense(int expenseID, int budgetID, User user) throws Exception {
//        SecurityUtil.validateUserCanEditBudget(user, budgetID);
//        expenseDAO.deleteExpense(expenseID, budgetID, user);
//    }

//    public List<Expense> getExpenses(int month, int year, int budgetID, User user) {
//        List<Expense> expenses = new ArrayList<>();
//
//        for (Expense expense : expenseMap.values()) {
//            ZonedDateTime expenseDate = expense.getExpenseDate();
//            if (expenseDate.getMonth() == Month.of(month) && expenseDate.getYear() == year) {
//                expenses.add(expense);
//            }
//        }
//
//        return expenses;
//    }
//
//    public List<Expense> getExpenses(ExpenseSearchQuery searchQuery, int budgetID, User user) {
//        return new ArrayList<>();
//    }
}
