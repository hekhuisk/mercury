package hekhuis.mercury.service;

import hekhuis.mercury.entity.Income;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.category.CategoryType;
import hekhuis.mercury.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private OverviewService overviewService;

    public List<Income> getAllIncomesForUser(long userID) {
        return new ArrayList<>(incomeRepository.findAllByUserID(userID));
    }

    public Income updateIncome(long incomeID, Income income, User user) throws Exception {
        Income oldExpense = getIncome(incomeID, user);

        removeIncomeFromOverview(oldExpense);

        income.setUserID(user.getUserID());
        Income updatedExpense = incomeRepository.save(income);

        addIncomeToOverview(updatedExpense);

        return updatedExpense;
    }

    public Income createIncome(Income income, User user) throws Exception {
        income.setUserID(user.getUserID());
        Income savedIncome = incomeRepository.save(income);
        addIncomeToOverview(savedIncome);
        return savedIncome;
    }

    public Income getIncome(long incomeID, User user) throws Exception {
        Income income = incomeRepository.findById(incomeID)
                .orElseThrow(() -> new Exception("Income not found for this id :: " + incomeID));
        return income;
    }

    public void deleteIncome(long incomeID, User user) throws Exception {
        Income income = getIncome(incomeID, user);
        removeIncomeFromOverview(income);
        incomeRepository.delete(income);
    }

    private void addIncomeToOverview(Income income) throws Exception {
        LocalDate incomeDate = income.getIncomeDate();

        overviewService.addAmount(income.getMainCategoryID(),
                income.getSubCategoryID(),
                CategoryType.EXPENSE,
                incomeDate.getYear(),
                incomeDate.getMonth(),
                income.getAmount());
    }

    private void removeIncomeFromOverview(Income income) throws Exception {
        LocalDate incomeDate = income.getIncomeDate();

        overviewService.removeAmount(income.getMainCategoryID(),
                income.getSubCategoryID(),
                CategoryType.EXPENSE,
                incomeDate.getYear(),
                incomeDate.getMonth(),
                income.getAmount());
    }
}
