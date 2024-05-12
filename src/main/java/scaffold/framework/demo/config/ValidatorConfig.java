package scaffold.framework.demo.config;

import java.util.HashMap;

import scaffold.framework.demo.FormHelper.ValidationHelper;

/**
 * ValidatorConfig
 */
public class ValidatorConfig {

    public static ValidationHelper getValidationHelper() {
        HashMap<String, String[]> maps = new HashMap<>();
        maps.put("css", new String[] { "", "border: var(--bs-border-width) solid #C60000;" });
        ValidationHelper v = new ValidationHelper();
        v.setMapValue(maps);
        return v;

    }
}