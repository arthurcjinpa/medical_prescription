package arthurs_pet_med.med_prescription.utils;

import org.springframework.util.CollectionUtils;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringToListConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (CollectionUtils.isEmpty(attribute)) {
            return null;
        } else {
            return String.join(",", attribute);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return new ArrayList<>();
        } else {
            return new ArrayList<>(Arrays.asList(dbData.split(",")));
        }
    }
}
