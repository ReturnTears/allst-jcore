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
    
    匿名类
    
    多态的应用: 模板方法设计模式(TemplateMethod)
    抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造
    但子类总体上会保留抽象类的行为方式。
    
    接口
    接口的本质是契约，标准，规范，接口可以实现多继承的效果。
    is-a的关系： subclass is a superclass表示子类继承父类
    JDK7-: 只能定义全局常量和抽象方法
    全局常量：public static final
    抽象方法：public abstract
    JDK8+：全局常量和抽象方法+静态方法和默认方法
    接口中是不能定义构造器的，意味着接口是不能实例化的
    Java类可以实现多个接口，弥补了Java单继承的局限性
    接口与接口之间可以多继承
    面向接口编程


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

### Java Virtual Machine
```text
第一章：JVM的基本介绍
JVM
Graal VM

第二章：类加载子系统
Class Files 
>>
Class Loader SubSystem (
    loading (bootstrap classloader > extension classloader > application classloader)
    > linking (verify > prepare > resolve)
    > initialization (initialization)
)
>>
Runtime Data Area (
    Method Area 
    Heap Area
    Stack Area
    PC Registers
    Native Method Stack
)
>>
Execution Engine




类加载子系统作用：
1、类加载器子系统负责从文件系统或者网络中加载Class文件，Class文件在文件开头有特定的文件标识。
2、ClassLoader只负责class文件的加载，至于它是否可以运行，则由Execution Engine决定
3、加载的类信息存在于一块称为方法去的内存空间。除了类的信息外，方法区中还会存放运行时常量池信息，可能还包括字符串字面量和数字常量
类加载器Classloader角色：
1、class file存在于本地磁盘上， 可以理解为设计师的画在纸上的模板，最终这个模板在执行的时候要加载到JVM中，JVM根据这个文件实例化出n个一模一样的实例
2、class file加载到JVM中， 称为DNA元数据模板，放在方法区
3、在.class文件 -> JVM -> 最终成为元数据模板，此过程就要一个运转工具（类装载器class loader），扮演一个快递员的角色。
类的加载过程：
加载Loading：
1、通过一个类的全限定名获取定义此类的二进制字节流
2、将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构
3、在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据的访问入口
补充：加载.class文件的方式
1、从本地系统中直接加载
2、通过网络获取，典型场景：Web Applet
3、从zip压缩包中读取，成为日后jar, war格式的基础
4、运行时计算生成，使用最多的是：动态代理技术
5、由其他文件生成，典型场景：JSP应用
6、从专有数据库中提取.class文件，比较少见
7、从加密文件中获取，典型的防Class文件被反编译的保护措施
连接Linking
验证（Verify）:
1、目的在于去报class文件的字节流中包含信息符合当前虚拟机要求，，保证被加载类的正确性，不会危及虚拟机自身安全
2、主要包括四种验证：文件格式验证（.class文件的开头是CA FA BA BY）、元数据验证、字节码验证、符号引用验证。
准备（Prepare）：
1、为类变量分配内存并且设置该类的默认初始值，即零值。这个阶段的类变量会设置为默认值，initialization阶段才会赋值
2、这里不包括final 修饰的static，因为final在编译的时候就会分配了，准备阶段会显式初始化
3、这里不会为实例变量分配初始化，类变量会分配在方法区中，而实例变量是会随着对象一起分配到Java堆中
解析（Resolve）：
将常量池内的符号引用转换为直接引用的过程，直接引用就是直接指向目标的指针，相对偏移量或一个间接定位到目标的句柄。
事实上，解析操作往往会伴随着JVM在执行完初始化之后再执行。
解析动作主要针对类或接口、字段、类方法、接口方法，方法类型等。对应常量池中的：
CONSTANT_Class_info、CONSTANT——Fieldref_info、CONSTANT_Methodref_info
初始化Initialization
初始化：
1、初始化阶段就是执行类构造器方法<client>()的过程
2、此方法不需要定义，是javac编译器自动收集类中的所有类变量的赋值动作和静态代码块中的语句合并而来的
3、构造器方法中指令按语句再源文件中出现的顺序执行
4、<client>()不同于类的构造器。（关联：构造器是虚拟机视觉下的<init>()）
5、若该类具有父类，JVM会保证子类的<client>()执行前，父类的<client>()已经执行完毕
6、虚拟机必须保证一个类的<client>()方法在多线程下被同步加锁
类加载器分类
JVM支持两种类型的类加载器，分别为引导类加载器（Bootstrap ClassLoader）和自定义类加载器（User-Defined ClassLoader）
在Java虚拟机规范中定义，将所有派生于抽象类ClassLoader的类加载都划分为自定义类加载器
虚拟机自带的加载器：启动类加载器（又称引导类加载器, bootstrap classloader）
1、这个类加载使用C/C++语言实现的，嵌套在JVM内部
2、它用来加载JAVA的核心类库（JAVA_HOME/jre/lib/rt.jar、resource.jar、sun.boot.class.path路径下的内容），用于提供JVM自身需要的类
3、并不继承自Java.lang.ClassLoader,没有父加载器
4、加载扩展类和应用类加载器，并指定为他们的父类加载器
5、出于安全考虑，Bootstrap启动类加载器只加载包含包名为java,javax,sun开头的类
扩展类加载器（Extension Classloader）
1、java语言编写的，
2、派生于Classloader类
3、父类加载器为启动类加载器
4、从java.ext.dirs系统属性所指的目录中加载类库，或从JDK的安装目录的jre/lib/ext子目录下加载类库，如果用户创建的JAR放在此目录下，也会自动由扩展类加载器加载
应用程序类加载器（系统类加载器， AppClassLoader）
1、同上1、2
2、它负责加载环境变量classpath或系统属性java.class.path指定路径下的类库
3、该类加载是程序中默认的类加载器，一般来说，Java应用的类都是由它来完成加载的
4、通过ClassLoader#getSystemClassLoader()方法可以获取该类加载器
用户自定义类加载器
为什么需要自定义类加载器？
>隔离加载类
>修改类加载的方式
>扩展加载源
>防止源码泄露
自定义累加器实现步骤：
1、开发人员可以通过继承抽象类java.lang.ClassLoader类的方式实现自己的类加载器，以满足特殊需求
2、在JDK1.2之前，在自定义类加载器时，总会去继承ClassLoader类并重写loadClass()方法,从而实现自定义的类加载类，但是在JDK1.2之后，已不再建议用户去覆盖loadClass()方法，而是建议把自定义的类加载逻辑写在findClass()方法中。
3、在编写自定义类加载器时， 如果没有太过于复杂的需求，可以直接继承URLClassLoader类，这样就可以避免自己去编写findClass()方法及其获取字节码流的方式，使自定义类加载器编写更加简洁。

双亲委派机制
Java虚拟机对class文件采用的是按需加载的方式，当需要使用该类时才会将它的Class文件加载到内存生成class对象，
加载某个类的class文件时，java虚拟机采用的是双亲委派模式， 即把请求交由父类处理，它是一种任务委派模式
双亲委派模式:
1>如果一个类加载器收到类加载请求,它并不会自己去加载,而是把这个请求委托给父类的加载器去执行
2>如果父类加载器还存在父类加载,则进一步向上委托,依次递归,请求最终将到达顶层的启动类加载器
3>如果父类加载器可以完成类加载任务,就成功返回,若不能,子类才会尝试自己去加载
优势:
1>避免类的重复加载
2>保护程序安全,防止核心API被随意篡改

沙箱安全机制
自定义String类，但是在加载自定义String类是会率先使用引导类加载器加载，而引导类加载器在加载的过程中会加载JDK自带的文件（rt.jar包中的java\lang\String.class）
这样起到保护原生类的作用。

在JVM中表示两个class对象是否为同一个类存在两个必要条件：
1、类的完整类名必须一致，包括包名
2、加载这个类的classloader（指classloader实例对象）必须相同。

类的主动使用和被动使用
Java程序对类的使用分为：主动使用和被动使用
主动使用：
1、创建类的实例
2、访问某个类或接口的静态变量，或者对该静态变量赋值
3、调用类的静态方法
4、反射
5、初始化一个类的子类
6、Java虚拟机启动时被标明为启动类的类
7、JDK7开始提供的动态语言支持：
java.lang.invoke.MethodHandle实例的解析结果，REF_getStatic、REF_putStatic、REF_invokeStatic句柄对应的类没有初始化则初始化
除了上述7种方式，都被看作是对类的被动使用，都不会导致类的初始化


第三章 运行时数据区及线程
前述
内存是非常重要的系统资源，是银盘和CPU的中间仓库及桥梁，承载着操作系统和应用程序的实时运行。
JVM内存布局规定了Java在运行过程种内存申请、分配、管理的策略，保证了JVM的高效稳定运行。
不同的JVM对内存的划分方式和管理机制存在着部分差异

运行时数据区（Runtime Data Area）：
方法区（method area）
堆（heap）
程序计数器（program counter register）
本地方法栈（native method stack）
虚拟机栈（Java virtual machine stack）
每个线程独占程序计数器、栈、本地栈、（程序计数器、栈、本地栈的生命周期伴随着线程启动而启动，线程销毁而销毁）
线程间共享：堆、堆外内存（永久代或原空间、代码缓存）

线程是一个程序里的运行单元，JVM允许一个应用有多个线程并行的执行。
在Hotspot JVM里， 每个线程都与操作系统的本地线程直接映射。当一个Java线程准备好执行以后，此时一个操作系统的本地线程也同时创建了。Java线程执行终止后，本地线程也会回收
操作系统负责所有线程的安排调度到任何一个可用的CPU上，一旦本地线程初始化成功，他就会调用Java线程的run()方法

JVM系统线程：
主要的后台线程在Hotspot JVM里有以下几个：
虚拟机线程：这种线程的操作是需要JVM达到安全点才会出现。
周期任务线程：这种线程是时间周期时间的体现，他们呢一般用于周期性操作的调度执行
GC线程：这种线程对在JVM里不同种类的垃圾收集行为提供了支持
编译线程：这种线程在运行时会将字节码编译成本地代码
信号调度线程：这种线程接收信号并发送给JVM，在它内部通过调用适当的方法进行处理


程序计数器（PC寄存器）
JVM中的程序计数寄存器，Register的命名源于CPU的寄存器，寄存器存储指令相关的线程信息。
CPU只有把数据转载到寄存器才能运行。
JVM中的PC寄存器是对物理PC寄存器的一种抽象模拟。
PC寄存器用来存储指向下一条指令的地址，也即将要执行的指令代码。由执行引擎读取下一条指令。
1、它是一块很小的内存空间，几乎可用忽略不计，也是运行速度最快的存储区域。
2、在JVM规范中，每个线程都有自己的程序计数器，是线程私有的，生命周期与线程的生命周期保持一致。
3、任何时间每一个线程都只有一个方法执行，也就是所谓的当前方法。程序计数器会存储当前线程正在执行的Java方法的JVM指令地址。或者，如果是在执行native方法，则是未指定值(undefined)
4、它是程序控制流的指示器，分支、循环、跳转、异常处理、线程恢复等基础功能都需要依赖这个计数器来完成。
5、字节码解释器工作时就是通过改变这个计数器的值来选取下一条需要执行的字节码指令
6、它是唯一一个在Java虚拟机规范中没有规定任何outOfMemoryError情况的区域

程序计数器常见问题？
1、使用程序计数器存储字节码指令地址有什么用呢？
因为CPU需要不停的切换各个线程，这个时候切换回来以后，就得知道接着从哪开始继续执行。
2、为什么使用程序计数器记录当前线程的执行地址呢？
JVM的字节码解释器就需要通过改变PC寄存器来明确下一条应该执行什么样的字节码指令。
3、PC寄存器为什么会被设定为线程私有的？
由于CPU会在不同线程间不停的来回切换任务，这样必然会导致中断或恢复，，
为了能够准确地记录各个线程正在执行的当前字节码指令地址，最好的办法是为每个线程都分配一个PC寄存器，这样线程之间可用独立计算。
```

### 备注
```text
Java反编译命令：
javap -verbose xxx.class
javap -v xxx.class


```