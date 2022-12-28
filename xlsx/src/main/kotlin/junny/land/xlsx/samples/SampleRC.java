package junny.land.xlsx.samples;

import junny.land.xlsx.annotation.Column;

public record SampleRC(
    @Column(name = "annoName")
    String name,
    @Column(name = "annoAge") Integer age,
    Integer noAnno
) {}
