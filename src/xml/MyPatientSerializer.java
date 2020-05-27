package xml;

import businessLogic.MyDoctor;
import businessLogic.MyPatient;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public class MyPatientSerializer extends JsonSerializer<MyPatient> {
    @Override
    public void serialize(MyPatient patient, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", patient.getId());
        jsonGenerator.writeStringField("lastName", patient.getLastName());
        jsonGenerator.writeStringField("firstName", patient.getFirstName());
        jsonGenerator.writeStringField("phone", patient.getPhone());
        jsonGenerator.writeStringField("email", patient.getEmail());
        jsonGenerator.writeStringField("dateOfBirth", patient.getDateOfBirth());
        jsonGenerator.writeStringField("gender", String.valueOf(patient.getGender()));
        jsonGenerator.writeNumberField("height", patient.getHeight());
        jsonGenerator.writeNumberField("weight", patient.getWeight());
        jsonGenerator.writeEndObject();
    }
}
