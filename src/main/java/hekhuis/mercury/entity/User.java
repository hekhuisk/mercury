package hekhuis.mercury.entity;

import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class User {

    private int userID;
    private String username;

    private Locale locale;
    private TimeZone timeZone;

    private boolean adminUser;

    private List<Integer> budgetIDs;

    public User() {

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isAdminUser() {
        return adminUser;
    }

    public void setAdminUser(boolean adminUser) {
        this.adminUser = adminUser;
    }

    public List<Integer> getBudgetIDs() {
        return budgetIDs;
    }

    public void setBudgetIDs(List<Integer> budgetIDs) {
        this.budgetIDs = budgetIDs;
    }
}
