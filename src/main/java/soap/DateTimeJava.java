package soap;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Преобразование дат для представления в XML-ках (в формате ISO-8601).
 */
@XmlTransient
public class DateTimeJava extends XmlAdapter<String, LocalDate> {

    public String marshal(LocalDate date) throws Exception {
        return date == null ? null : date.toString();
    }

    public LocalDate unmarshal(String date) throws Exception {
        return LocalDate.parse(date);
    }
}
