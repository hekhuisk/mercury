package hekhuis.mercury.entity.budget;

import hekhuis.mercury.entity.Money;
import hekhuis.mercury.entity.category.CategoryType;

import java.time.YearMonth;
import java.util.HashMap;

public class MonthlyBudget extends Budget {

    private int monthlyBudgetID;

    private YearMonth yearMonth;

    private Money monthlyTotal;

    private CategoryType categoryType;

    // Key is Category ID
    private HashMap<Integer, Money> categoryTotals;
}
