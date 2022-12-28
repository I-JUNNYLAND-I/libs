package junny.land.xlsx.builder.extract;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.String.valueOf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import junny.land.xlsx.builder.extract.datas.XlsxFields;

public record FieldValue<T>(T objects) {
    public XlsxFields extract() {
        Map<String, String> map = new HashMap<>();
        Class<?> clazz = objects.getClass();
        Arrays.asList(clazz.getDeclaredFields()).forEach(field -> {
            field.setAccessible(TRUE);
            try {
                map.put(field.getName(), valueOf(field.get(objects)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            field.setAccessible(FALSE);
        });

        return new XlsxFields(map);
    }
}

