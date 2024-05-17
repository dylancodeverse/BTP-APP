package scaffold.framework.demo.FormHelper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

import org.springframework.ui.Model;

public class ValidationHelper {

    // def_ ; err_

    boolean hasError;
    /**
     * [0] -> default value
     * [1] -> error value
     */
    HashMap<String, String[]> mapValue = new HashMap<>();;

    HashMap<String, String> attributes;

    public ValidationHelper() {
        attributes = new HashMap<>();
    }

    public void validate(Object obj, Model model, String fields, String... args)
            throws NoSuchMethodException, SecurityException {
        String[] fieldsList = fields.split(",");
        int index = 0;
        hasError = false;
        for (String field : fieldsList) {
            Method method = obj.getClass().getMethod(setMethod(field), String.class);
            try {
                method.invoke(obj, args[index]);
                fillModelWithMapValue(model, 0, field);
                model.addAttribute(errorField(field), "");
            } catch (Exception e) {
                model.addAttribute(errorField(field), e.getCause().getMessage());
                fillModelWithMapValue(model, 1, field);
                hasError = true;
            }
            index++;
        }
        if (hasError) {
            model.addAllAttributes(attributes);
            int o = 0;
            for (String string : fieldsList) {
                model.addAttribute(inputValue(string), args[o]);
                o++;

            }
        }
    }

    private void fillModelWithMapValue(Model model, int index, String field) {
        if (mapValue == null)
            return;
        Set<String> keys = mapValue.keySet();
        for (String key : keys) {
            this.attributes.put(key + "_" + field, mapValue.get(key)[index]);
        }
    }

    public static String sysout(Object x) {
        if (x == null) {
            return "";
        }
        return x.toString();
    }

    private String inputValue(String value) {
        return "def_" + value;
    }

    private String errorField(String field) {
        return "err_" + field;
    }

    private String setMethod(String field) {
        return "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    public boolean hasError() {
        return hasError;
    }

    public void setHasError(Model model, String fields, String... args) {
        String[] fieldsList = fields.split(",");
        Integer i = 0;
        for (String field : fieldsList) {
            fillModelWithMapValue(model, 0, field);
            model.addAttribute(inputValue(field), args[i]);
            i++;
        }
        hasError = true;
    }

    public void setHasError(boolean hasError) {

        this.hasError = hasError;
    }

    public HashMap<String, String[]> getMapValue() {
        return mapValue;
    }

    public void setMapValue(HashMap<String, String[]> mapValue) {
        this.mapValue = mapValue;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }
}
