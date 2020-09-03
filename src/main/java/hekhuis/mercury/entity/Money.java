package hekhuis.mercury.entity;

import hekhuis.mercury.spring.jpa.CurrencyConverter;

import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

@Embeddable
public class Money {

    private static final Currency defaultCurrency = Currency.getInstance("USD");
    private static final Locale defaultLocale = Locale.US;

    private BigDecimal amount;
    @Convert(converter = CurrencyConverter.class)
    private Currency currency;

    protected Money() {}

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

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setAmount(Currency currency) {
        this.currency = currency;
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
