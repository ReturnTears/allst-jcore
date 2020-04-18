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
🍎 Java 基础
🥝 抽象类与抽象方法
🍑 随着继承层次中一个个新子类的定义，类变得越来越具体，而父类则变得更一般，更通用。
   类的设计应该保证父类和子类能够共享特征，有时将一个父类设计得非常抽象，以至于他没有具体得实例， 这样得类叫做抽象类。
   抽象类是用来模型化那些父类无法确定全部实现，而是由其子类提供具体实现的对象的类。
   abstract修饰类：抽象类
   1、抽象类不能实例化
   2、抽象类中一定有构造器，便于子类实例化时调用（涉及到了子类实例化得全过程）
   3、抽象类在开发中由子类对象实例化，完成相关操作
   abstract修饰方法：抽象方法
   1、抽象方法只有方法得声明，没有方法体
   2、包含抽象方法得类一定是抽象类，反之，抽象类中可以没有抽象方法
   3、若子类重写了父类中得所有抽象方法，该子类才能实例化，否则，该子类还是一个抽象类需要用abstract关键字修饰
   abstract不能用来修饰：属性、构造器等结构
   abstract不能用来修饰私有方法、静态方法、final修饰的方法和类

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

🍓 lambda表达式的语法
   可以把Lambda表达式理解为简洁地表示可传递的匿名函数的一种方式：它没有名称，但它有参数列表、函数主体、返回类型，可能还有一个可以抛出的异常列表
   lambda表达式的组成:
   (o1, o2) -> o1.getColor().compareTo(o2.getColor())
   参数列表  arrow  lambda body
   (parameters) -> expression
   (parameters) -> {statments;}
   () -> {}
   
   
   
🍓 如何使用lambda表达式
🍓 execute around pattern
🍓 Function Interface
🍓 Method references
   方法引用
   
   
   
🍓 Type interface
🍓 composing lambdas



🍎 Java 8 Stream 流

jconsole命令调用Java自带的工具查看线程运行情况




🍎 Java 8 NumericStream




🍎 Java 8 Optional



🍎 Java 8 Collector



🍎 Java 8 SummarizingInt




🍎 Java 8 parallel 
Java 8并行













```