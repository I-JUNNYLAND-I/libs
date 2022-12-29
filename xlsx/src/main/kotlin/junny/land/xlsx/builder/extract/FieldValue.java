package junny.land.xlsx.builder.extract;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.String.valueOf;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junny.land.xlsx.datas.XlsxFields;

public record FieldValue<T>(T objects) {
    public XlsxFields extract() {
        Class<?> clazz = objects.getClass();
        List<String> datas = Arrays.stream(clazz.getDeclaredFields()).map(this::toString).toList();
        return new XlsxFields(datas);
    }

    public String toString(Field element){
        try {
            element.setAccessible(TRUE);
            return valueOf(element.get(objects));
        } catch (IllegalAccessException e) {
            return "";
        }
    }
}

