# Changer
[![](https://jitpack.io/v/I-JUNNYLAND-I/libs.svg)](https://jitpack.io/#I-JUNNYLAND-I/libs)

## 1. Set class
"@Column" is a delimiter to distinguish headers.

```java
// JAVA CLASS
public class SampleJC {
    @Column("NAME !")
    private String name;
    @Column("AGE !")
    private Integer age;
    private Integer noAnno;
}
```
```java
// RECORD CLASS
public record SampleRC(
        @Column(value = "annoName")
        String name,
        @Column(value = "annoAge") Integer age,
        Integer noAnno
    ) {}
```
```kotlin
//KOTLIN CLASS
class SampleKt(
    @Column(value = "NAME !") var name: String ="",
    @Column("AGE !") var age: Int =0,
    var noAnno: Int = 0
)
```

## 2. Declare Changer
```java
File file = Changer.Companion.create(myCollection)
    .classType(SampleJC.class)
    .type(ExtractType.XLSX)
    .name("sample")
    .defaultTemporary()
    .output(Type.FILE)
    .path("./")
    .extract();

```
```kotlin
Changer.create(lists)
    .classType(SampleKt::class.java)
    .type(ExtractType.CSV)
    .name("jay")
    .temporary()
    .output(Type.BYTE)
    .path("./")
    .build<ByteArray>()
```

---
## Information
`create()` is Collections of your class  
`type()` is Collections of your class  
`name()` is name of output's name  
`temporary()` is temporary file [ only Byte,OutputStream ]  
`output()` is output type [ ByteArray,OutputStream,File,Path ]  
`path()` is output path  
`build() | extract()` need to execute  
