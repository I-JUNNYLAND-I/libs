package junny.land.xlsx.samples

import junny.land.xlsx.annotation.Column

class SampleKt(
    @Column(value = "annoName") var name: String ="",
    @Column("annoAge") var age: Int =0,
    var noAnno: Int = 0
)