package scaffold.framework.demo.models.admin;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Random;

import org.json.JSONArray;

import orm.DynamicORM;

public class Fn_statdevisanneemois extends DynamicORM<Fn_statdevisanneemois> {

    Double montanttotale;
    Integer mois;

    public String getRequest(Integer annee) {
        return "select * from Fn_statdevisanneemois(" + annee + ")";
    }

    public String[] getJSONPieChartInformation(Connection connection, Integer annee) throws Exception {
        Fn_statdevisanneemois[] fs = select(connection, false, getRequest(annee));
        return new String[] { getJSONDATA(fs), getColor(fs), getLabel(fs) };
    }

    private String getLabel(Fn_statdevisanneemois[] fs) {
        String[] labels = new String[fs.length];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = fs[i].getMoisAString();
        }
        return new JSONArray(labels).toString();
    }

    public String getJSONDATA(Fn_statdevisanneemois[] stats) {
        Double[] datas = new Double[stats.length];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = stats[i].getMontanttotale();
        }
        return new JSONArray(datas).toString();
    }

    public static String getRandomRGBAColor() {
        Random random = new Random();
        int red = random.nextInt(256); // Valeur de rouge entre 0 et 255
        int green = random.nextInt(256); // Valeur de vert entre 0 et 255
        int blue = random.nextInt(256); // Valeur de bleu entre 0 et 255

        return String.format("rgba(%d, %d, %d)", red, green, blue);
    }

    public String getColor(Fn_statdevisanneemois[] stats) {
        String[] colors = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            colors[i] = getRandomRGBAColor();
        }
        return new JSONArray(colors).toString();
    }

    public Double getMontanttotale() {
        return montanttotale;
    }

    public String getMoisAString() {
        if (getMois() == 1) {
            return "JANV";
        } else if (getMois() == 2) {
            return "FEV";
        } else if (getMois() == 3) {
            return "MAR";
        } else if (getMois() == 4) {
            return "AVR";
        } else if (getMois() == 5) {
            return "MAI";
        } else if (getMois() == 6) {
            return "JUN";
        } else if (getMois() == 7) {
            return "JUL";
        } else if (getMois() == 8) {
            return "AOU";
        } else if (getMois() == 9) {
            return "SEP";
        } else if (getMois() == 10) {
            return "OCT";
        } else if (getMois() == 11) {
            return "NOV";
        } else {
            return "DEC";
        }
    }

    public void setMontanttotale(BigDecimal moBigDecimal) {
        setMontanttotale(Double.valueOf(moBigDecimal.toPlainString()));
    }

    public void setMontanttotale(Double montanttotale) {
        this.montanttotale = montanttotale;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(BigDecimal mois) {
        this.mois = mois.intValue();
    }

}
