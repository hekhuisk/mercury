package hekhuis.mercury.config.rest.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import hekhuis.mercury.entity.Money;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;

public class MoneyDeserializer extends JsonDeserializer<Money> {

    @Override
    public Money deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        BigDecimal amount = node.get("amount").decimalValue();
        String currencyCode = node.get("currency").asText();
        Currency currency = Currency.getInstance(currencyCode);

        return new Money(amount, currency);
    }
}
