package junny.land.xlsx.builder.extract;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.String.valueOf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junny.land.xlsx.datas.XlsxFields;

public record FieldValue<T>(T objects) {
    public XlsxFields extract() {
        Class<?> clazz = objects.getClass();
        List<String> datas = Arrays.asList(clazz.getDeclaredFields()).stream().map(field -> {
            try {
                field.setAccessible(TRUE);
                return valueOf(field.get(objects));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return "";
        }).toList();

        return new XlsxFields(datas);
    }
}
