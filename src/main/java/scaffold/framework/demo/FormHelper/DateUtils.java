package scaffold.framework.demo.FormHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    @Deprecated
    public static java.sql.Date convertStringToSQLDate(String dateString, String format) throws ParseException {
        // Définir le format de la chaîne de date
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        // Analyser la chaîne de date et la convertir en java.util.Date
        java.util.Date utilDate = dateFormat.parse(dateString);
        // Convertir java.util.Date en java.sql.Date
        return new java.sql.Date(utilDate.getTime());

    }
}
