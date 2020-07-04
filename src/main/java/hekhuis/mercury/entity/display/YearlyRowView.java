package hekhuis.mercury.entity.display;

import hekhuis.mercury.entity.Money;

import java.time.Month;
import java.util.Map;

public class YearlyRowView {

    private Map<Month, Money> monthlyTotals;
    private Money yearlyTotal;
}
