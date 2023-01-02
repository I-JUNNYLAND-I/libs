package junny.land.xlsx.builder.extract;

import static java.util.Optional.ofNullable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import junny.land.xlsx.annotation.Column;
import junny.land.xlsx.datas.HeaderDatas;

public class HeaderValues<T> {

    private final Class<T> clazz;

    public HeaderDatas extract() {
        ArrayList<String> headerList = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            String name = ofNullable(field.getAnnotation(Column.class))
                .map(Column::value)
                .orElseGet(field::getName);

            headerList.add(name);
        }
        return new HeaderDatas(headerList);
    }

    public HeaderValues(Class<T> clazz) {
        this.clazz = clazz;
    }
}
