package hekhuis.mercury.service;

import hekhuis.mercury.entity.Expense;
import hekhuis.mercury.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseService {

    private static Map<Long, Expense> expenseMap = new HashMap<>();

    private static long newExpenseID = 1;

//    @Autowired
//    private ExpenseRepository expenseRepository;

    @Autowired
    private PaymentSourceService paymentSourceService;

    public List<Expense> getAllExpenses() {
        //return expenseRepository.findAll();
        return new ArrayList<>(expenseMap.values());
    }

    public Expense saveExpense(Expense expense, User user) throws Exception {
        //return expenseRepository.save(expense);
        paymentSourceService.validateUserCanAccessPaymentSource(expense.getPaymentSourceID(), user);

        Expense existingExpense = expenseMap.get(expense.getExpenseID());
        if (existingExpense != null) {
            if (existingExpense.getExpenseID() != expense.getExpenseID()) {
                throw new Exception("Invalid expense ID");
            }
            expenseMap.replace(existingExpense.getExpenseID(), expense);
        } else {
            expense.setExpenseID(newExpenseID++);
            expenseMap.put(expense.getExpenseID(), expense);
        }

        return expense;
    }

    public Expense getExpense(long expenseID, User user) throws Exception {
        //return expenseRepository.findById(expenseID).get();
        return expenseMap.get(expenseID);
    }

    public void deleteExpense(long expenseID, User user) throws Exception {
        //expenseRepository.deleteById(expenseID);
        expenseMap.remove(expenseID);
    }
}
