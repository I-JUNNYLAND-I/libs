package junny.land.xlsx.samples;

import junny.land.xlsx.annotation.Column;

public class SampleJC {
    @Column("annoName")
    private String name;
    @Column("annoAge")
    private Integer age;
    private Integer noAnno;
    public SampleJC(String name, Integer age, Integer noAnno) {
        this.name = name;
        this.age = age;
        this.noAnno = noAnno;
    }
}
