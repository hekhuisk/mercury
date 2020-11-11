package hekhuis.mercury.config.rest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Month;

public class MonthSerializer extends JsonSerializer<Month> {


    @Override
    public void serialize(Month month, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(month.toString());
    }
}
