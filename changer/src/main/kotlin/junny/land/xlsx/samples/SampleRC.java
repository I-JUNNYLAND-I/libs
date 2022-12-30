package junny.land.xlsx.samples;

import junny.land.xlsx.annotation.Column;

public record SampleRC(
    @Column(value = "annoName")
    String name,
    @Column(value = "annoAge") Integer age,
    Integer noAnno
) {}
