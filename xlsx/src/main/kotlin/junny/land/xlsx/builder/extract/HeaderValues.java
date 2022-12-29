package junny.land.xlsx.builder.extract;

import static java.util.Optional.ofNullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Optional;
import junny.land.xlsx.annotation.Column;
import junny.land.xlsx.datas.XlsxHeaders;

public record HeaderValues<T>(Class<T> clazz) {
    public XlsxHeaders extract() {
        ArrayList<String> headerList = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            String name = ofNullable(field.getAnnotation(Column.class))
                .map(Column::name)
                .orElseGet(field::getName);

            headerList.add(name);
        }
        return new XlsxHeaders(headerList);
    }

}
