package arthurs_pet_med.med_prescription.utils;

import org.springframework.util.CollectionUtils;

import javax.persistence.AttributeConverter;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DateToListConverter implements AttributeConverter<List<ZonedDateTime>, String> {

  @Override
  public String convertToDatabaseColumn(List<ZonedDateTime> zonedDateTimes) {
    if (CollectionUtils.isEmpty(zonedDateTimes)) {
      return null;
    } else {
      return zonedDateTimes.stream().map(ZonedDateTime::toString).collect(Collectors.joining(","));
    }
  }

  @Override
  public List<ZonedDateTime> convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    } else {
      return Arrays.stream(dbData.split(","))
          .map(ZonedDateTime::parse)
          .collect(Collectors.toList());
    }
  }
}
