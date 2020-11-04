package hekhuis.mercury.service;

import hekhuis.mercury.entity.Income;
import hekhuis.mercury.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IncomeService {

    private static Map<Long, Income> incomeMap = new HashMap<>();

    private static long newIncomeID = 1;

    public List<Income> getAllIncomes() {
        return new ArrayList<>(incomeMap.values());
    }

    public Income saveIncome(Income income, User user) throws Exception {
        Income existingIncome = incomeMap.get(income.getIncomeID());
        if (existingIncome != null) {
            if (existingIncome.getIncomeID() != income.getIncomeID()) {
                throw new Exception("Invalid income ID");
            }
            incomeMap.replace(existingIncome.getIncomeID(), income);
        } else {
            income.setIncomeID(newIncomeID++);
            incomeMap.put(income.getIncomeID(), income);
        }

        return income;
    }

    public Income getIncome(long incomeID, User user) throws Exception {
        return incomeMap.get(incomeID);
    }

    public void deleteIncome(long incomeID, User user) throws Exception {
        incomeMap.remove(incomeID);
    }
}
