package soap;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Преобразование дат для представления в XML-ках (в формате ISO-8601).
 */
@XmlTransient
public class DateTimeISO8601Marshaller extends XmlAdapter<String, DateTime> {
    private DateTimeFormatter dtf = ISODateTimeFormat.dateTimeNoMillis();
    private DateTimeFormatter dtfUniversal = ISODateTimeFormat.dateTimeParser();

    public String marshal(DateTime date) throws Exception {
        return date == null ? null : dtf.print(date);
    }

    public DateTime unmarshal(String dateTime) throws Exception {
        return dtfUniversal.parseDateTime(dateTime);
    }
}
