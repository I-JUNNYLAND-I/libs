package junny.land.xlsx.samples

import junny.land.xlsx.annotation.Column

class SampleKt(
    @Column(name = "annoName") var name: String ="",
    @Column(name = "annoAge") var age: Int =0,
    var noAnno: Int = 0
)