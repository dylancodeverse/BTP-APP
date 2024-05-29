package scaffold.framework.demo.FormHelper;

import java.sql.Date;
import java.text.ParseException;

public class DateUtils {
    public static java.sql.Date convertStringToSQLDate(String dateString) throws ParseException {
        String []ddmmyyyy =dateString.split("/");
        return Date.valueOf(ddmmyyyy[2]+'-'+ddmmyyyy[1]+'-'+ddmmyyyy[0]);

    }
}
