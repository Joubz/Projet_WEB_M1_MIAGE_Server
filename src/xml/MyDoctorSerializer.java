package xml;

import businessLogic.MyDoctor;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public class MyDoctorSerializer extends JsonSerializer<MyDoctor> {

    /**
     * Serialize a doctor json
     * @param doctor (MyDoctor)
     * @param jsonGenerator (JsonGenerator)
     * @param serializerProvider (SerializerProvider)
     * @throws IOException - IOException
     * @throws JsonProcessingException - JsonProcessingException
     */
    @Override
    public void serialize(MyDoctor doctor, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", doctor.getId());
        jsonGenerator.writeStringField("lastName", doctor.getLastName());
        jsonGenerator.writeStringField("firstName", doctor.getFirstName());
        jsonGenerator.writeStringField("speciality", doctor.getSpeciality());
        jsonGenerator.writeStringField("address", doctor.getAddress());
        jsonGenerator.writeNumberField("morningStartHour", doctor.getMorningStartHour());
        jsonGenerator.writeNumberField("morningEndHour", doctor.getMorningEndHour());
        jsonGenerator.writeNumberField("afternoonStartHour", doctor.getAfternoonStartHour());
        jsonGenerator.writeNumberField("afternoonEndHour", doctor.getAfternoonEndHour());
        jsonGenerator.writeNumberField("appointmentLast", doctor.getAppointmentLast());
        jsonGenerator.writeEndObject();
    }
}
