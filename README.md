#Java core技术 II

>>day1 2018/04/17
##part 12 本地方法
### 编写本地代码很容易破坏你的程序，并感染系统，因此，只建议在必需的时候才使用本地代码。
### 可以使用本地代码的三种情况：
###     1、你的应用需要访问的系统特性和设备通过Java平台是无法实现的。
###     2、你已经有了大量的测试和调试过的用另一种语言编写的代码，并且知道如何将其导出到所有的目标平台上
###     3、通过基准测试，你发现所编写的Java代码比其他语言的等价代码要慢得多。
### Java有一个用于和本地c代码进行相互操作的API，称为Java本地接口（JNI）
###

##part 5 国际化
###

## MySQL5.7+ 配置
#MySQl data sources(SpringBoot方式)
```
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/dx?characterEncoding=utf-8&useSSL=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456
```
#一般 java.io.tmpdir 路径就是: C:\Users\June\AppData\Local\Temp\

## Java复习
### Java基础部分
```text
@DATE 2019-12-10
值传递和引用传递:
    在Java语言中, 原始数据类型在传递参数时都是按值传递, 而包装类型在传递参数时都是按引用传递




```
### Java高级部分
```text

🍎 Java 8 基础部分

JVM 相关命令:

java -version 查看安装的Java版本
 
jps -l 查看Java程序运行进程ID

jstat -gcutil processId 1000 10 查看进程id为processId的Java程序, 运行1000ms , 运行10次的内存情况
内存运行情况如下:
C:\Users\June>jstat -gcutil 12052 1000 4
  S0     S1     E      O      M     CCS    YGC     YGCT    FGC    FGCT     GCT
 90.29   0.00  38.15   0.18  97.68  94.65      2    0.023     0    0.000    0.023
 90.29   0.00  38.15   0.18  97.68  94.65      2    0.023     0    0.000    0.023
 90.29   0.00  38.15   0.18  97.68  94.65      2    0.023     0    0.000    0.023
 90.29   0.00  38.15   0.18  97.68  94.65      2    0.023     0    0.000    0.023

🍎 Java 8 Lamdba表达式

Java 8 lambda表达式比较节省内存空间~~~
查看lambda表达式编译为字节码文件后和匿名内部类的区别

@FunctionInterface

```