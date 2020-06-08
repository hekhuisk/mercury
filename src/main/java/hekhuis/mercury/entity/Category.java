package hekhuis.mercury.entity;

public class Category {

    private int ID;
    private int budgetID;
    private int mainCategoryID; // do like -1 or something to show it's a main one. Or maybe Integer so it can be null.

    private String name;
    // Could do tooltip with user entered description of the category
    private CategoryType type;
}
