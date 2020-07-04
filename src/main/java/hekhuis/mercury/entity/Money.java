package hekhuis.mercury.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Money {

    private static final Currency defaultCurrency = Currency.getInstance("USD");
    private static final Locale defaultLocale = Locale.US;

    private BigDecimal amount;
    private Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.currency = currency;
        this.amount = amount.setScale(currency.getDefaultFractionDigits(), RoundingMode.HALF_EVEN);
    }

    public Money(BigDecimal amount) {
        this(amount, defaultCurrency);
    }

    public Money(double amount, Currency currency) {
        this(BigDecimal.valueOf(amount), currency);
    }

    public Money(double amount) {
        this(BigDecimal.valueOf(amount));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return toString(defaultLocale);
    }

    public String toString(Locale locale) {
        NumberFormat currenyFormat = NumberFormat.getCurrencyInstance(locale);
        currenyFormat.setCurrency(currency);
        return currenyFormat.format(amount.doubleValue());
    }
}
