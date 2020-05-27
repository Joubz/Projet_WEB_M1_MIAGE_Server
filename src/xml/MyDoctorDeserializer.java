package xml;

import businessLogic.MyDoctor;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

public class MyDoctorDeserializer extends JsonDeserializer<MyDoctor>{
    @Override
    public MyDoctor deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        // NE PAS UTILISER LE PARAMETRE jsonParser DIRECTEMENT !!

        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

        MyDoctor doctor = new MyDoctor();
        doctor.setId(jsonNode.get("id").asText());

        System.out.println(doctor);

        return doctor;
    }
}
