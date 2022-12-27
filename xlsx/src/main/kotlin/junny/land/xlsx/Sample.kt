package junny.land.xlsx

import junny.land.xlsx.annotation.Column

class Sample(
    @Column(name = "이름") var name: String,
    @Column(name = "나이") var age: Int,
    var noAnno: Int
)