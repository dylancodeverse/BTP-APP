package scaffold.framework.demo.models;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Random;

import org.json.JSONArray;

import orm.DynamicORM;

public class Statistiquedeventedebilletparfilm extends DynamicORM<Statistiquedeventedebilletparfilm> {

    String films;
    Integer nombredebilletvendu;

    public String[] getJSONPieChartInformation(Connection connection) throws Exception {
        Statistiquedeventedebilletparfilm[] fs = select(connection, false);
        return new String[] { getJSONDATA(fs), getColor(fs), getLabel(fs) };
    }

    private String getLabel(Statistiquedeventedebilletparfilm[] fs) {
        String[] labels = new String[fs.length];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = fs[i].getFilms();
        }
        return new JSONArray(labels).toString();
    }

    public String getJSONDATA(Statistiquedeventedebilletparfilm[] stats) {
        Integer[] datas = new Integer[stats.length];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = stats[i].getNombredebilletvendu();
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

    public String getColor(Statistiquedeventedebilletparfilm[] stats) {
        String[] colors = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            colors[i] = getRandomRGBAColor();
        }
        return new JSONArray(colors).toString();
    }

    public String getFilms() {
        return films;
    }

    public void setFilms(String films) {
        this.films = films;
    }

    public Integer getNombredebilletvendu() {
        return nombredebilletvendu;
    }

    public void setNombredebilletvendu(BigDecimal nombredebilletvendu) {
        this.nombredebilletvendu = nombredebilletvendu.intValue();
    }
}
