package junny.land.xlsx.extract;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

record FieldExtractor(Class<?> clazz) {

    private static final Object formatter = new Object();

    public Map<String, String> extract() {
        Map<String, String> vo = new HashMap<>();
        Arrays.stream(clazz.getDeclaredFields()).forEach(field -> {
            field.setAccessible(TRUE);
            try {
                vo.put(field.getName(), String.valueOf(field.get(formatter)));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            field.setAccessible(FALSE);
        });
        return vo;
    }
}

