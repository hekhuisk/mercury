package hekhuis.mercury.service;

import hekhuis.mercury.entity.Expense;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExpenseService {

    private static Map<Long, Expense> expenseMap = new HashMap<>();

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private BudgetService budgetService;
    @Autowired
    private PaymentSourceService paymentSourceService;

    public List<Expense> getAllExpenses() {
        //return expenseRepository.findAll();
        return (List<Expense>) expenseMap.values();
    }

    public Expense saveExpense(Expense expense, User user) throws Exception {
        //return expenseRepository.save(expense);
        validateUserCanAccessExpense(expense.getExpenseID(), user);
        paymentSourceService.validateUserCanAccessPaymentSource(expense.getPaymentSourceID(), user);

        Expense existingExpense = expenseMap.get(expense.getBudgetID());
        if (existingExpense == null) {
            if (existingExpense.getBudgetID() != expense.getBudgetID()) {
                throw new Exception("Invalid budget ID");
            }
            validateUserCanAccessExpense(existingExpense.getBudgetID(), user);
            expenseMap.replace(existingExpense.getBudgetID(), expense);
        } else {
            expenseMap.put(expense.getBudgetID(), expense);
        }

        return expense;
    }

    public Expense getExpense(long expenseID, User user) throws Exception {
        //return expenseRepository.findById(expenseID).get();
        validateUserCanAccessExpense(expenseID, user);
        return expenseMap.get(expenseID);
    }

    public void deleteExpense(long expenseID, User user) throws Exception {
        //expenseRepository.deleteById(expenseID);
        validateUserCanAccessExpense(expenseID, user);
        expenseMap.remove(expenseID);
    }

    public void validateUserCanAccessExpense(long expenseID, User user) throws Exception {
        Expense expense = expenseMap.get(expenseID);
        budgetService.validateUserCanAccessBudget(expense.getBudgetID(), user);
    }
}
