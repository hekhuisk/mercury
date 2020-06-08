package hekhuis.mercury.entity;

import java.util.List;

public class Budget {

    private int budgetID;

    private String name;
    private String description;
    private List<Category> categories;

    private BudgetType budgetType; // like envelope method or something
}
