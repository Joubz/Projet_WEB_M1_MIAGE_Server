package xml;

import businessLogic.MyPatient;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

public class MyPatientDeserializer extends JsonDeserializer<MyPatient> {
    @Override
    public MyPatient deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        // NE PAS UTILISER LE PARAMETRE jsonParser DIRECTEMENT !!

        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

        MyPatient patient = new MyPatient(
                jsonNode.get("lastName").asText(),
                jsonNode.get("firstName").asText(),
                jsonNode.get("phone").asText(),
                jsonNode.get("email").asText(),
                jsonNode.get("dateOfBirth").asText(),
                jsonNode.get("gender").asText().charAt(0),
                jsonNode.get("height").asInt(),
                jsonNode.get("weight").asInt()
        );

        System.out.println(patient);

        return patient;
    }
}
