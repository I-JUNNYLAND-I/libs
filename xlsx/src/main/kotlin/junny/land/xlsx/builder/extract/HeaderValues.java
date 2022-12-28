package junny.land.xlsx.builder.extract;

import java.lang.reflect.Field;
import java.util.ArrayList;
import junny.land.xlsx.annotation.Column;
import junny.land.xlsx.builder.extract.datas.XlsxHeaders;

public record HeaderValues<T>(Class<T> clazz) {
    public XlsxHeaders extract() {
        ArrayList<String> headerList = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            Column annotation = field.getAnnotation(Column.class);

            if (annotation != null) {
                headerList.add(annotation.name());
            } else {
                headerList.add(field.getName());
            }
        }
        return new XlsxHeaders(headerList);
    }

}
