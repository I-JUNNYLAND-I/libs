package junny.land.xlsx.builder;



import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import junny.land.xlsx.builder.output.Type;
import junny.land.xlsx.builder.type.ExtractType;
import junny.land.xlsx.samples.SampleJC;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ChagerJTest {

    Collection<SampleJC> myCollection = Arrays.asList(
        new SampleJC("name1", 1, 2),
        new SampleJC("name2", 1, 2),
        new SampleJC("name3", 1, 2)
    );

    @Test
    public void test() {
        File file = Changer.Companion.create(myCollection)
            .classType(SampleJC.class)
            .type(ExtractType.XLSX)
            .name("sample")
            .defaultTemporary()
            .output(Type.FILE)
            .path("./")
            .extract();

        System.out.println("file = " + file);

    }
}
