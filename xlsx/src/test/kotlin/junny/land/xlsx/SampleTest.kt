package junny.land.xlsx

import junny.land.xlsx.extract.FieldExtractor
import junny.land.xlsx.extract.HeaderExtractor
import org.junit.jupiter.api.Test

class SampleTest{

    @Test
    fun `extractHeaderTest`(){
        val data : Sample = Sample("junny", 25, 1)
        val extract = HeaderExtractor(data::class.java).extract()
        println(extract)
    }
    @Test
    fun `extractFieldTest`(){
        val data : Sample = Sample("junny", 25, 1)
        val extract = FieldExtractor(data::class.java).extract()
        println(extract)
    }


}