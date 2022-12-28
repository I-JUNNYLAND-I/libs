package junny.land.xlsx.samples;

import junny.land.xlsx.annotation.Column;

public class SampleJC {
    @Column(name = "annoName")
    private String name;
    @Column(name = "annoAge")
    private Integer age;
    private Integer noAnno;

    protected SampleJC() {
    }

    public SampleJC(String name, Integer age, Integer noAnno) {
        this.name = name;
        this.age = age;
        this.noAnno = noAnno;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getNoAnno() {
        return noAnno;
    }
}
