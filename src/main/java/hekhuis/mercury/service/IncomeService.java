package hekhuis.mercury.service;

import hekhuis.mercury.entity.Income;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> getAllIncomesForUser(long userID) {
        return new ArrayList<>(incomeRepository.findAllByUserID(userID));
    }

    public Income updateIncome(long incomeID, Income income, User user) throws Exception {
        getIncome(incomeID, user);
        income.setUserID(incomeID);
        return incomeRepository.save(income);
    }

    public Income createIncome(Income income, User user) {
        return incomeRepository.save(income);
    }

    public Income getIncome(long incomeID, User user) throws Exception {
        Income income = incomeRepository.findById(incomeID)
                .orElseThrow(() -> new Exception("Income not found for this id :: " + incomeID));
        return income;
    }

    public void deleteIncome(long incomeID, User user) throws Exception {
        Income income = getIncome(incomeID, user);
        incomeRepository.delete(income);
    }
}
