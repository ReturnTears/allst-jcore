#Java core技术 II

## part 12 本地方法
```text
### 编写本地代码很容易破坏你的程序，并感染系统，因此，只建议在必需的时候才使用本地代码。
### 可以使用本地代码的三种情况：
###     1、你的应用需要访问的系统特性和设备通过Java平台是无法实现的。
###     2、你已经有了大量的测试和调试过的用另一种语言编写的代码，并且知道如何将其导出到所有的目标平台上
###     3、通过基准测试，你发现所编写的Java代码比其他语言的等价代码要慢得多。
### Java有一个用于和本地c代码进行相互操作的API，称为Java本地接口（JNI）
###

##part 5 国际化
###
```

## MySQL5.7+ 配置
#MySQl data sources(SpringBoot方式)
```properties
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/dx?characterEncoding=utf-8&useSSL=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456
```

# Java
## Java基础部分
### 基础
```text
一般 java.io.tmpdir 路径就是: C:\Users\June\AppData\Local\Temp\
🍎 Java 基础
🍎 Java transient关键字用于类属性/变量，表示该类的序列化过程在为该类的任何实例创建持久字节流时应该忽略此类变量。

🥝 抽象类与抽象方法
🍑 随着继承层次中一个个新子类的定义，类变得越来越具体，而父类则变得更一般，更通用。
   类的设计应该保证父类和子类能够共享特征，有时将一个父类设计得非常抽象，以至于他没有具体得实例， 这样得类叫做抽象类。
   抽象类是用来模型化那些父类无法确定全部实现，而是由其子类提供具体实现的对象的类。
   abstract修饰类：抽象类
   1、抽象类不能实例化
   2、抽象类中一定有构造器，便于子类实例化时调用（涉及到了子类实例化得全过程）
   3、抽象类在开发中由子类对象实例化，完成相关操作
   4、抽象类和抽象方法都使用 abstract 关键字进行声明。抽象类一般会包含抽象方法，抽象方法一定位于抽象类中。
        抽象类和普通类最大的区别是，抽象类不能被实例化，需要继承抽象类才能实例化其子类。
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
    1、 接口是抽象类的延伸，在 Java 8 之前，它可以看成是一个完全抽象的类，也就是说它不能有任何的方法实现。 
        从 Java 8 开始，接口也可以拥有默认的方法实现，这是因为不支持默认方法的接口的维护成本太高了。
        在 Java 8 之前，如果一个接口想要添加新的方法，那么要修改所有实现了该接口的类。 
        接口的成员(字段 + 方法)默认都是 public 的，并且不允许定义为 private 或者 protected。 
        接口的字段默认都是 static 和 final 的。
        public abstract class AbstractClassExample {
            protected int x;
            private int y;
            public abstract void func1();
            public void func2() {
                System.out.println("func2");
            }
        }
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
    
    抽象类与接口比较：    
    1、从设计层面上看，抽象类提供了一种 IS-A 关系，那么就必须满足里式替换原则，即子类对象必须能够替换掉所有父类对象。而接口更像是一种 LIKE-A 关系，它只是提供一种方法实现契约，并不要求接口和实现接口的类具有 IS-A 关系。 
    2、从使用上来看，一个类可以实现多个接口，但是不能继承多个抽象类。 
    3、接口的字段只能是 static 和 final 类型的，而抽象类的字段没有这种限制。 
    4、接口的成员只能是 public 的，而抽象类的成员可以有多种访问权限。



@DATE 2019-12-10
值传递和引用传递:
    在Java语言中, 原始数据类型在传递参数时都是按值传递, 而包装类型在传递参数时都是按引用传递


🥝 注解
注解是JDK1.5版本开始引入的一个特性，用于对代码进行说明，可以对包、类、接口、字段、方法参数、局部变量等进行注解。
它主要的作用有以下四方面：
生成文档，通过代码里标识的元数据生成javadoc文档。
编译检查，通过代码里标识的元数据让编译器在编译期间进行检查验证。
编译时动态处理，编译时通过代码里标识的元数据动态处理，例如动态生成代码。
运行时动态处理，运行时通过代码里标识的元数据动态处理，例如使用反射注入实例。
例：
Java自带的标准注解，包括@Override、@Deprecated和@SuppressWarnings，分别用于标明重写某个方法、标明某个类或方法过时、标明要忽略的警告，用这些注解标明后编译器就会进行检查。
元注解，元注解是用于定义注解的注解，包括@Retention、@Target、@Inherited、@Documented
    @Retention用于标明注解被保留的阶段
    @Target用于标明注解使用的范围
    @Inherited用于标明注解可继承
    @Documented用于标明是否生成javadoc文档
自定义注解，可以根据自己的需求定义注解，并可用元注解对自定义注解进行注解。

内置注解 - @Override
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
这个注解可以被用来修饰方法，并且它只在编译时有效，在编译后的class文件中便不再存在。
这个注解的作用我们大家都不陌生，那就是告诉编译器被修饰的方法是重写的父类的中的相同签名的方法，编译器会对此做出检查，若发现父类中不存在这个方法或是存在的方法签名不同，则会报错。

内置注解 - @Deprecated
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
public @interface Deprecated {
    String since() default "";
    boolean forRemoval() default false;
}
它会被文档化，能够保留到运行时，能够修饰构造方法、属性、局部变量、方法、包、参数、类型。这个注解的作用是告诉编译器被修饰的程序元素已被“废弃”，不再建议用户使用。

内置注解 - @SuppressWarnings
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {
    String[] value();
}
它能够修饰的程序元素包括类型、属性、方法、参数、构造器、局部变量，只能存活在源码时，取值为String[]。它的作用是告诉编译器忽略指定的警告信息，它可以取的值如下所示：
参数             作用                                    原描述
all             抑制所有警告                              to suppress all warnings
boxing          抑制装箱、拆箱操作时候的警告                 to suppress warnings relative to boxing/unboxing operations
cast            抑制映射相关的警告                         to suppress warnings relative to cast operations
dep-ann         抑制启用注释的警告                         to suppress warnings relative to deprecated annotation
deprecation     抑制过期方法警告                           to suppress warnings relative to deprecation
fallthrough     抑制确在switch中缺失breaks的警告            to suppress warnings relative to missing breaks in switch statements
finally         抑制finally模块没有返回的警告                to suppress warnings relative to finally block that don’t return
hiding          抑制与隐藏变数的区域变数相关的警告             to suppress warnings relative to locals that hide variable（） 
incomplete-switch 忽略没有完整的switch语句                  to suppress warnings relative to missing entries in a switch statement (enum case) 
nls             忽略非nls格式的字符                         to suppress warnings relative to non-nls string literals
null            忽略对null的操作                           to suppress warnings relative to null analysis
rawtype         使用generics时忽略没有指定相应的类型          to suppress warnings relative to un-specific types when using
restriction     抑制与使用不建议或禁止参照相关的警告            to suppress warnings relative to usage of discouraged or
serial          忽略在serializable类中没有声明serialVersionUID变量     to suppress warnings relative to missing serialVersionUID field for a serializable class 
static-access   抑制不正确的静态访问方式警告                     to suppress warnings relative to incorrect static access
synthetic-access 抑制子类没有按最优方法访问内部类的警告          to suppress warnings relative to unoptimized access from inner classes 
unchecked       抑制没有进行类型检查操作的警告                 to suppress warnings relative to unchecked operations
unqualified-field-access 抑制没有权限访问的域的警告           to suppress warnings relative to field access unqualified
unused          抑制没被使用过的代码的警告                    to suppress warnings relative to unused code

元注解
内置注解的定义中使用了一些元注解（注解类型进行注解的注解类），在JDK 1.5中提供了4个标准的元注解：@Target，@Retention，@Documented，@Inherited,
在JDK 1.8中提供了两个元注解 @Repeatable和@Native。

元注解 - @Target
Target注解的作用是：描述注解的使用范围（即：被修饰的注解可以用在什么地方）。
Target注解用来说明那些被它所注解的注解类可修饰的对象范围：
注解可以用于修饰 packages、types（类、接口、枚举、注解类）、类成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数），
在定义注解类时使用了@Target 能够更加清晰的知道它能够被用来修饰哪些对象，它的取值范围定义在ElementType 枚举中。
public enum ElementType {
 
    TYPE, // 类、接口、枚举类
 
    FIELD, // 成员变量（包括：枚举常量）
 
    METHOD, // 成员方法
 
    PARAMETER, // 方法参数
 
    CONSTRUCTOR, // 构造方法
 
    LOCAL_VARIABLE, // 局部变量
 
    ANNOTATION_TYPE, // 注解类
 
    PACKAGE, // 可用于修饰：包
 
    TYPE_PARAMETER, // 类型参数，JDK 1.8 新增
 
    TYPE_USE // 使用类型的任何地方，JDK 1.8 新增 
    (此类型包括类型声明和类型参数声明，是为了方便设计者进行类型检查)包含了ElementType.TYPE(类、接口（包括注解类型）和枚举的声明)和ElementType.TYPE_PARAMETER(类型参数声明),
}

元注解 - @Retention & @RetentionTarget
Reteniton注解的作用是：描述注解保留的时间范围（即：被描述的注解在它所修饰的类中可以被保留到何时） 。
Reteniton注解用来限定那些被它所注解的注解类在注解到其他类上以后，可被保留到何时，一共有三种策略，定义在RetentionPolicy枚举中。
public enum RetentionPolicy {
    SOURCE,    // 源文件保留
    CLASS,       // 编译期保留，默认值
    RUNTIME   // 运行期保留，可通过反射去获取注解信息
}
通过执行 javap -verbose RetentionTest 命令获取到的RetentionTest 的 class 字节码内容如下
警告: 文件 .\RetentionTest.class 不包含类 RetentionTest
Classfile /E:/IdeaProjects/allst-jcore/target/classes/com/allst/jcore/anno/RetentionTest.class
  Last modified 2022年6月26日; size 680 bytes
  MD5 checksum 2e916e0909912b0046fe21c328d53297
  Compiled from "RetentionTest.java"
public class com.allst.jcore.anno.RetentionTest
  minor version: 0
  major version: 55
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #2                          // com/allst/jcore/anno/RetentionTest
  super_class: #3                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 4, attributes: 1
Constant pool:
   #1 = Methodref          #3.#20         // java/lang/Object."<init>":()V
   #2 = Class              #21            // com/allst/jcore/anno/RetentionTest
   #3 = Class              #22            // java/lang/Object
   #4 = Utf8               <init>
   #5 = Utf8               ()V
   #6 = Utf8               Code
   #7 = Utf8               LineNumberTable
   #8 = Utf8               LocalVariableTable
   #9 = Utf8               this
  #10 = Utf8               Lcom/allst/jcore/anno/RetentionTest;
  #11 = Utf8               sourcePolicy
  #12 = Utf8               classPolicy
  #13 = Utf8               RuntimeInvisibleAnnotations
  #14 = Utf8               Lcom/allst/jcore/anno/ClassPolicy;
  #15 = Utf8               runtimePolicy
  #16 = Utf8               RuntimeVisibleAnnotations
  #17 = Utf8               Lcom/allst/jcore/anno/RuntimePolicy;
  #18 = Utf8               SourceFile
  #19 = Utf8               RetentionTest.java
  #20 = NameAndType        #4:#5          // "<init>":()V
  #21 = Utf8               com/allst/jcore/anno/RetentionTest
  #22 = Utf8               java/lang/Object
{
  public com.allst.jcore.anno.RetentionTest();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/allst/jcore/anno/RetentionTest;

  public void sourcePolicy();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=0, locals=1, args_size=1
         0: return
      LineNumberTable:
        line 11: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       1     0  this   Lcom/allst/jcore/anno/RetentionTest;

  public void classPolicy();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=0, locals=1, args_size=1
         0: return
      LineNumberTable:
        line 15: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       1     0  this   Lcom/allst/jcore/anno/RetentionTest;
    RuntimeInvisibleAnnotations:
      0: #14()
        com.allst.jcore.anno.ClassPolicy

  public void runtimePolicy();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=0, locals=1, args_size=1
         0: return
      LineNumberTable:
        line 19: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       1     0  this   Lcom/allst/jcore/anno/RetentionTest;
    RuntimeVisibleAnnotations:
      0: #17()
        com.allst.jcore.anno.RuntimePolicy
}
SourceFile: "RetentionTest.java"
从RetentionTest的字节码内容我们可以得出以下两点结论：
1、编译器并没有记录下 sourcePolicy() 方法的注解信息；
2、编译器分别使用了 RuntimeInvisibleAnnotations 和 RuntimeVisibleAnnotations 属性去记录了classPolicy()方法 和 runtimePolicy()方法 的注解信息；

元注解 - @Documented
Documented注解的作用是：描述在使用 javadoc 工具为类生成帮助文档时是否要保留其注解信息。

元注解 - @Inherited
Inherited注解的作用：被它修饰的Annotation将具有继承性。如果某个类使用了被@Inherited修饰的Annotation，则其子类将自动具有该注解。

元注解 - @Repeatable (Java8)

元注解 - @Native (Java8)
使用 @Native 注解修饰成员变量，则表示这个变量可以被本地代码引用，常常被代码生成工具使用。对于 @Native 注解不常使用，了解即可


注解与反射接口
定义注解后，如何获取注解中的内容呢？反射包java.lang.reflect下的AnnotatedElement接口提供这些方法。
这里注意：只有注解被定义为RUNTIME后，该注解才能是运行时可见，当class文件被装载时被保存在class文件中的Annotation才会被虚拟机读取。
AnnotatedElement 接口是所有程序元素（Class、Method和Constructor）的父接口，所以程序通过反射获取了某个类的AnnotatedElement对象之后，程序就可以调用该对象的方法来访问Annotation信息。

注解的原理：
注解本质是一个继承了Annotation 的特殊接口，其具体实现类是Java 运行时生成的动态代理类。而我们通过反射获取注解时，返回的是Java 运行时生成的动态代理对象$Proxy1。
通过代理对象调用自定义注解（接口）的方法，会最终调用AnnotationInvocationHandler 的invoke方法。该方法会从memberValues 这个Map 中索引出对应的值。而memberValues 的来源是Java 常量池。

注解是不支持继承的，不能使用关键字extends来继承某个@interface，但注解在编译后，编译器会自动继承java.lang.annotation.Annotation接口.
虽然反编译后发现注解继承了Annotation接口，请记住，即使Java的接口可以实现多继承，但定义注解时依然无法使用extends关键字继承@interface。
区别于注解的继承，被注解的子类继承父类注解可以用@Inherited： 如果某个类使用了被@Inherited修饰的Annotation，则其子类将自动具有该注解。

注解的应用场景：
1、配置化到注解化 - 框架的演进
    例： Spring 框架 配置化到注解化的转变
2、自定义注解和AOP - 通过切面实现解耦
    例： 最为常见的就是使用Spring AOP切面实现统一的操作日志管理
    例： 可以看到权限管理也是通过类似的注解（@RequiresPermissions）机制来实现的。所以我们可以看到，通过注解+AOP最终的目标是为了实现模块的解耦。
    例： https://cloud.tencent.com/developer/article/1522675


```

### 异常
```text
Java异常是Java提供的一种识别及响应错误的一致性机制，java异常机制可以使程序中异常处理代码和正常业务代码分离，保证程序代码更加优雅，并提高程序健壮性。
Throwable 
    Throwable 是 Java 语言中所有错误与异常的超类。
    Throwable 包含两个子类：Error（错误）和 Exception（异常），它们通常用于指示发生了异常情况。 
    Throwable 包含了其线程创建时线程执行堆栈的快照，它提供了 printStackTrace() 等接口用于获取堆栈跟踪数据等信息。
Error（错误） 
    Error 类及其子类：程序中无法处理的错误，表示运行应用程序中出现了严重的错误。 
    此类错误一般表示代码运行时 JVM 出现问题。通常有 Virtual MachineError（虚拟机运行错误）、NoClassDefFoundError（类定义错误）等。比如 OutOfMemoryError：内存不足错误；StackOverflowError：栈溢出错误。此类错误发生时，JVM 将终止线程。
    这些错误是不受检异常，非代码性错误。因此，当此类错误发生时，应用程序不应该去处理此类错误。按照Java惯例，我们是不应该实现任何新的Error子类的！ 
Exception（异常）
    程序本身可以捕获并且可以处理的异常。Exception 这种异常又分为两类：运行时异常和编译时异常。 
    运行时异常
        都是RuntimeException类及其子类异常，如NullPointerException(空指针异常)、IndexOutOfBoundsException(下标越界异常)等，这些异常是不检查异常，程序中可以选择捕获处理，也可以不处理。
        这些异常一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异常的发生。 
        运行时异常的特点是Java编译器不会检查它，也就是说，当程序中可能出现这类异常，即使没有用try-catch语句捕获它，也没有用throws子句声明抛出它，也会编译通过。 
    非运行时异常 （编译异常）
        是RuntimeException以外的异常，类型上都属于Exception类及其子类。从程序语法角度讲是必须进行处理的异常，如果不处理，程序就不能编译通过。如IOException、SQLException等以及用户自定义的Exception异常，一般情况下不自定义检查异常。

可查的异常（checked exceptions）和不可查的异常（unchecked exceptions）
    可查异常（编译器要求必须处置的异常）： 正确的程序在运行中，很容易出现的、情理可容的异常状况。可查异常虽然是异常状况，但在一定程度上它的发生是可以预计的，而且一旦发生这种异常状况，就必须采取某种方式进行处理。 
        除了RuntimeException及其子类以外，其他的Exception类及其子类都属于可查异常。这种异常的特点是Java编译器会检查它，也就是说，当程序中可能出现这类异常，要么用try-catch语句捕获它，要么用throws子句声明抛出它，否则编译不会通过。 
    不可查异常(编译器不要求强制处置的异常) 
        包括运行时异常（RuntimeException与其子类）和错误（Error）。

异常的申明(throws)
    1、若是父类的方法没有声明异常，则子类继承方法后，也不能声明异常。
    
    Throws抛出异常的规则： 如果是不可查异常（unchecked exception），即Error、RuntimeException或它们的子类，那么可以不使用throws关键字来声明要抛出的异常，编译仍能顺利通过，但在运行时会被系统抛出。 
    必须声明方法可抛出的任何可查异常（checked exception）。即如果一个方法可能出现受可查异常，要么用try-catch语句捕获，要么用throws子句声明将它抛出，否则会导致编译错误。 
    仅当抛出了异常，该方法的调用者才必须处理或者重新抛出该异常。当方法的调用者无力处理该异常的时候，应该继续抛出，而不是囫囵吞枣。 
    调用方法必须遵循任何可查异常的处理和声明规则。若覆盖一个方法，则不能声明与覆盖方法不同的异常。声明的任何异常必须是被覆盖方法所声明异常的同类或子类。
 异常的抛出(throw)
    如果代码可能会引发某种错误，可以创建一个合适的异常类实例并抛出它，这就是抛出异常。

异常的自定义
    习惯上，定义一个异常类应包含两个构造函数，一个无参构造函数和一个带有详细描述信息的构造函数（Throwable 的 toString 方法会打印这些详细信息，调试时很有用）。
    自定义异常类时，继承Exception类
    public class DefException extends Exception {
        public DefException(){ }
        public DefException(String msg){
            super(msg);
        }
        // ...
    }

异常的捕获
    异常捕获处理的方法通常有：
    try-catch
    try-catch-finally
    try-finally
    try-with-resource

异常基础总结
    1、try、catch和finally都不能单独使用，只能是try-catch、try-finally或者try-catch-finally。 
    2、try语句块监控代码，出现异常就停止执行下面的代码，然后将异常移交给catch语句块来处理。 
    3、finally语句块中的代码一定会被执行，常用于回收资源 。 
    4、throws：声明一个异常，告知方法调用者。 
    5、throw ：抛出一个异常，至于该异常被捕获还是继续抛出都与它无关。 
Java编程思想一书中，对异常的总结。 
    1、在恰当的级别处理问题。（在知道该如何处理的情况下了捕获异常。） 
    2、解决问题并且重新调用产生异常的方法。 
    3、进行少许修补，然后绕过异常发生的地方继续执行。 
    4、用别的数据进行计算，以代替方法预计会返回的值。 
    5、把当前运行环境下能做的事尽量做完，然后把相同的异常重抛到更高层。 
    6、把当前运行环境下能做的事尽量做完，然后把不同的异常抛到更高层。 
    7、终止程序。 
    8、进行简化（如果你的异常模式使问题变得太复杂，那么用起来会非常痛苦）。 
    9、让类库和程序更安全。

常用的异常
    在Java中提供了一些异常用来描述经常发生的错误，对于这些异常，有的需要程序员进行捕获处理或声明抛出，有的是由Java虚拟机自动进行捕获处理。Java中常见的异常类:
    RuntimeException：
        java.lang.ArrayIndexOutOfBoundsException 数组索引越界异常。当对数组的索引值为负数或大于等于数组大小时抛出。
        java.lang.ArithmeticException 算术条件异常。譬如：整数除零等。
        java.lang.NullPointerException 空指针异常。当应用试图在要求使用对象的地方使用了null时，抛出该异常。譬如：调用null对象的实例方法、访问null对象的属性、计算null对象的长度、使用throw语句抛出null等等 
        java.lang.ClassNotFoundException 找不到类异常。当应用试图根据字符串形式的类名构造类，而在遍历CLASSPAH之后找不到对应名称的class文件时，抛出该异常。
        java.lang.NegativeArraySizeException 数组长度为负异常
        java.lang.ArrayStoreException 数组中包含不兼容的值抛出的异常
        java.lang.SecurityException 安全性异常
        java.lang.IllegalArgumentException 非法参数异常
    IOException
        IOException：操作输入流和输出流时可能出现的异常。
        EOFException 文件已结束异常
        FileNotFoundException 文件未找到异常
    其他
        ClassCastException    类型转换异常类 
        ArrayStoreException  数组中包含不兼容的值抛出的异常 
        SQLException   操作数据库异常类 
        NoSuchFieldException   字段未找到异常 
        NoSuchMethodException   方法未找到抛出的异常 
        NumberFormatException    字符串转换为数字抛出的异常 
        StringIndexOutOfBoundsException 字符串索引超出范围抛出的异常 
        IllegalAccessException  不允许访问某类异常 
        InstantiationException  当应用程序试图使用Class类中的newInstance()方法创建一个类的实例，而指定的类对象无法被实例化时，抛出该异常
```

### SPI机制
```text
SPI（Service Provider Interface），是JDK内置的一种 服务提供发现机制，可以用来启用框架扩展和替换组件，主要是被框架的开发人员使用。
Java中SPI机制主要思想是将装配的控制权移到程序之外，在模块化设计中这个机制尤其重要，其核心思想就是 解耦。
SPI整体机制如图：java-spi.jpg

当服务的提供者提供了一种接口的实现之后，需要在classpath下的META-INF/services/目录里创建一个以服务接口命名的文件，这个文件里的内容就是这个接口的具体的实现类。
当其他的程序需要这个服务的时候，就可以通过查找这个jar包（一般都是以jar包做依赖）的META-INF/services/中的配置文件，配置文件中有接口的具体实现类名，可以根据这个类名进行加载实例化，就可以使用该服务了。J
DK中查找服务的实现的工具类是：java.util.ServiceLoader。
SPI实现机制如图：java-spi.png

具体案例查看项目：allst-dubbo-javaspi

jdk spi 需要遵循的规范： javaspi遵循的规范.jpg

SPI和API的区别是什么
1、SPI - “接口”位于“调用方”所在的“包”中
    概念上更依赖调用方。
    组织上位于调用方所在的包中。
    实现位于独立的包中。
    常见的例子是：插件模式的插件。     
2、API - “接口”位于“实现方”所在的“包”中
    概念上更接近实现方。
    组织上位于实现方所在的包中。
    实现和接口在一个包中。

SPI机制的缺陷 
    通过上面的解析，可以发现，我们使用SPI机制的缺陷： 
    1、不能按需加载，需要遍历所有的实现，并实例化，然后在循环中才能找到我们需要的实现。如果不想用某些实现类，或者某些类实例化很耗时，它也被载入并实例化了，这就造成了浪费。
    2、 获取某个实现类的方式不够灵活，只能通过 Iterator 形式获取，不能根据某个参数来获取对应的实现类。 
    3、多个并发多线程使用 ServiceLoader 类的实例是不安全的。
```

## Java高级部分
### Java 8
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
1、目的在于确保class文件的字节流中包含信息符合当前虚拟机要求，保证被加载类的正确性，不会危及虚拟机自身安全
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

CPU时间片
CPU时间片即CPU分配给各个程序的时间，每个线程被分配一个时间段，成为它的时间片。


虚拟机栈
1、虚拟机栈概述
虚拟机栈出现的背景：由于跨平台性的设计，Java的指令都是根据栈设计出来的。不同平台CPU架构不同，所以不能设计为基于寄存器的
优点是跨平台，指令集小，编译器容易实现，缺点是性能下降，实现同样的功能需要更多的指令。
栈是运行时的单位， 堆是存储时的单位
Java虚拟机栈是什么？
Java虚拟机栈也叫Java栈，每个线程在创建时都会创建一个虚拟机栈，其内部保存一个个的栈帧，对应着一次次的Java方法调用
是线程私有的
生命周期和线程一致
主管Java程序的运行，它保存方法的局部变量（8种基本数据类型），局部结果，并参与方法调用和返回。

栈的特点：
栈是一种快速有效的分配存储方式，访问速度仅次于程序计数器
JVM直接对Java栈的操作只有两个：
每个方法执行都伴随着进栈（入栈、压栈）
执行结束后的出栈工作
对于栈来说不存在于垃圾回收问题：
GC， OOM

栈种可能出现的异常：
Java虚拟机规范允许Java栈的大小是动态的或者是固定不变的
若是固定的，只要超过该大小就会抛出StackOverflowError
若是动态的，只要尝试扩展时申请不到内存则会抛出OutOfMemoryError

设置栈内存大小
-Xss 256K / 256M

2、栈的存储单位
每个线程都有自己的栈，栈种的数据都是以栈帧（stack frame）的格式存储的
在这个线程上正在执行的每个方法都各自对应一个栈帧
栈帧是一块内存区块，是一个数据集，维系着方法执行过程中的各种数据信息
JVM直接对Java栈的操作只有两个，就是对栈帧的压栈和出栈，遵循“先进后出”/“后进先出”原则
在一个活动线程中，一个时间按上，只会有一个活动的栈帧。即只有当前正在执行的方法的栈帧是有效的，这个栈帧称为当前栈帧，与当前栈帧相对应的方法就是当前方法，定义这个方法的类就是当前类
执行引擎运行的所有字节码指令只针对当前栈帧进行操作
如果该方法中调用了其他方法，对应的新的栈帧会被创建出来，放在栈的顶端，成为新的当前栈

栈的允许原理：
不同线程中所包含的栈帧是不允许存在相互引用的，即不可能在一个栈帧中引用另外一个线程的栈帧。
如果当前方法调用了其他方法，方法返回之际，当前栈帧会传回此方法的执行结果给前一个栈帧，接着，虚拟机会丢弃当前栈帧，使得前一个栈帧重新成为当前栈帧
Java方法有两种返回函数的方式，一种是正常的函数返回，使用return指令；另一种是抛出异常，不管是那种都会导致栈帧被弹出。

栈帧的内部结构：
每个栈帧都存储着以下五部分结构：
局部变量表
操作数栈
动态连接：指向运行时常量池的方法引用
方法返回地址：方法正常退出或者异常退出的定义
一些附加信息

3、局部变量表
又称局部变量数组或本地变量表
定义一个数字数组，主要用于存储方法参数和定义在方法体内的局部变量，这些数据类型包括各类基本数据类型，对象引用，以及ReturnAddress类型
由于局部变量表是建立在线程的栈上，是线程私有数据，因此不存在数据安全问题
局部变量表所需的容量大小是在编译器确定下来的，并保存在方法Code属性的maximum local variables数据项中。
    此方法运行期间是不会改变局部变量表的大小的
方法嵌套调用的次数由栈的大小决定。一般来说，栈越大，方法嵌套调用次数越多。
    对于一个函数而言，它的参数和局部变量越多，使得局部变量表膨胀，它的栈帧就越大，以满足方法调用所需传递的信息增大需求。
    进而函数调用的就会占用更多的栈空间，导致其嵌套的调用次数就会减少。
局部变量表中的变量只在当前方法调用中有效。在方法执行时，虚拟机通过使用局部变量表完成参数值到参数变量列表的传递过程。
    当方法调用结束后。随着方法栈帧的销毁。局部变量表也随之销毁。

Slot的理解
参数值的存放总是在局部变量数组的index0开始，到数组长度-1的索引结束
局部变量表，最基本的存储单元是Slot(变量槽)
局部变量表中存放编译期可知的各种基本数据类型（8种），引用类型（reference），returnAddress类型的变量
在局部变量表里，32位以内的类型只占用一个slot（包括returnAddress类型），64位类型（long和double）占用两个slot
    byte,short,char，float在存储前被转换位int,boolean也被转换位int,0表示false1表示true
JVM会位局部变量表中的每一个slot都分配一个访问索引，通过这个索引即可成功访问到局部变量表中指定的局部变量值
当一个实例方法被调用的时候，它的方法参数和方法体内部定义的局部变量将会按照顺序被复制到局部变量表中的每一个slot上
如果需要访问局部变量表中一个64bit的局部变量值时，只需要使用前一个索引即可
如果当前帧是由构造方法或者实例方法创建的，那么该对象引用this将会存在在index为0的slot处，其余的参数将按照参数顺序继续排列
栈帧中的局部变量表中的slot是可用重用的，如果一个局部变量过了其作用域，那么在其作用域之后申明的新的局部变量就很有可能会复用过期局部变量的槽位，从而达到节省资源的目的
补充说明：
在栈帧中，与性能调优关系最为密切的部分就是前面提到的局部变量表。在方法执行时，虚拟机使用局部变量表完成方法的传递
局部变量表中的变量也是很重要的垃圾回收根节点，只要被局部变量表中直接或间接引用的对象都不会被回收。

4、操作数栈(Operand Stack)
每一个独立的栈帧中除了包括局部变量表以外，还包含一个后进先出的操作数栈，，也可以称为表达式栈。
操作数栈，在方法执行过程中，根据字节码指令，往栈中写入数据或提取数据，即入栈（push）/出栈（pop）
操作数栈，主要用于保存计算过程的中间结果，同时作为计算过程中变量临时的存储空间。
操作数栈就是JVM执行引擎的一个工作区，当一个方法刚开始执行的时候，一个新的栈帧也会随之被创建出来，这个方法的操作数栈是空的。
每一个操作数栈都会拥有一个明确的栈深度用于存储数值，其所需的最大深度在编译期就定义好了，保存在方法的code属性中，为max_stack的值
栈中的任何一个元素都可以是任意的Java数据类型:32bit的类型占用一个栈单位深度，64bit的类型占用两个栈单位深度
操作数栈并非采用访问索引的方法来进行数据访问的，而是只能通过标准的入栈push和出栈pop操作来完成一次数据访问
如果被调用的方法带有返回值的化，其返回值就会被压入当前栈帧的操作数栈中，并更新PC寄存器中下一条需要执行的字节码指令。
操作数栈中元素的数据类型必须与字节码指令的序列严格匹配，这由编译器在编译器间进行验证，同时在类加载过程中的类检验阶段的数据流分析阶段要再次验证
另外，Java虚拟机的解释引擎是基于栈的执行引擎，其中的栈指的就是操作数栈。

5、代码追踪


6、栈顶缓存技术(Top of stack cashing)
由于操作数是存储在内存中的，因此频繁地执行内存读/写操作必然会影响执行速度。
为了解决这个问题，HotSpot JVM设计师提出了栈顶缓存技术：将栈顶元素全部缓存在物理CPU的寄存器中， 以此降低内存的读/写次数，提示执行引擎的执行效率

7、动态链接（Dynamic Linking）（或指向运行时常量池的方法引用）
每一个栈帧内部都包含一个指向运行时常量池中该栈帧所属方法的引用。
包含这个引用的目的就是为了支持当前方法的代码能够实现动态链接。
在Java源文件被编译到字节码文件中时，所有的变量和方法引用都作为符号引用保存在class文件的常量池里。
因此动态连接的作用就是为了将这些符号引用转换为调用方法的直接引用。
为什么需要常量池呢？
常量池的作用就是为了提供一些符号和常量，便于指令的识别。

8、方法的调用：解析与分派
在JVM中，将符号引用转换为调用方法的直接引用与方法的绑定机制相关。
静态连接：当一个字节码文件被装载进JVM内部时，如果被调用的目标方法在编译器可知，且运行期保持不变时。这种情况下将调用方法的符号引用转换为直接引用的过程称为静态连接。
动态连接：如果被调用的方法在编译器无法被确定下来，也就是说，只能够在程序运行期将调用方法的符号引用转换为直接引用，由于这种引用转换过程具备动态性，因此也被称之为动态连接。 
对应的方法绑定机制为：早期绑定和晚期绑定。绑定是一个字段、方法或者类在符号引用被替换为直接引用的过程，这仅仅发生一次。
早期绑定：早期绑定就是被调用的目标方法如果在编译器可知，且运行期保持不变时，即可将这个方法与所属的类型进行绑定，这样一来，由于明确了被调用的目标方法究竟时哪一个，因此也就可以使用静态连接的方法将符号引用转换为直接引用。
晚期绑定：如果被调用的方法在编译器无法被确定下来，只能够在程序运行期根据实际的类型绑定相关的方法，这种绑定方式也就被称之为晚期绑定。

虚方法和非虚方法
非虚方法：如果方法在编译器就确定了具体的调用版本，这个版本在运行时是不可变的，这样的方法称为非虚方法。
静态方法、私有方法、final方法、实例构造器、父类方法都是非虚方法。
其他方法称为非虚方法。

虚拟机中提供了以下几条方法调用指令：
普通调用指令：
1、invokestatic:调用静态方法、解析阶段确定唯一方法版本
2、invokespecial：调用<init>方法，私有及父类方法，解析阶段确定唯一方法版本
3、invokevirtual：调用所有虚方法
4、invokeinterface：调用接口方法
动态调用指令：
5、invokedynamic：动态解析出需要调用的方法，然后执行。

动态类型语言和静态类型语言：
动态类型语言和静态类型语言的区别就在于对类型的检查是在编译器还是在运行期，满足前者九四静态类型语言，反之是动态类型语言。
或者，静态类型语言是判断变量自身的类型信息；动态类型语言是判断变量值的类型信息，变量没有类型信息，变量值才有类型信息，这是动态语言的一个重要特性。

Java语言中方法重写的本质：
1、找到操作数栈顶的第一个元素所执行的对象的实际类型，记作C。
2、如果在类型C中找到与常量中的描述符合简单名称都相符的方法，则进行访问权限校验。如果通过则返回这个方法的直接引用，查找过程结束，如果不通过，则返回。Java.lang.IllegalAccessError
3、否则，按照继承关系从下往上依次对C的歌父类进行第2步的搜索和验证过程
4、如果始终没有找到合适的方法，则抛出java.lang.AbstractMethodError异常。


9、方法返回地址(return address)
作用：
1、存放调用该方法的PC寄存器的值
2、一个方法的结束有两种方式：正常指向完成、出现未处理的异常非正常退出
  无论通过那种方式退出，在方法退出后都返回到该方法被调用的位置。
  方法正常退出时，调用者的pc计数器的值作为返回地址，即调用该方法的指令的下一条指令的地址。而通过异常退出的，返回地址是要通过异常表来确定，栈帧中一般不会保存这部分信息。
  
10、一些附加信息

11、栈相关面试题
通过-Xss设置栈的大小

```

### 本地方法接口本地方法库
```text
什么是本地方法？
一个Native Method就是一个Java调用非Java代码的接口。作用是为了如何不同的编程语言为Java所用。初衷是为了融合C/C++程序。
为什么需要使用Native Method?
1、与Java环境外交互(主要原因)
2、与操作系统交互
3、Sun`s Java


```

### 堆空间(Importance)
```text
堆空间和方法区是进程独有的，线程间共享
1、堆的核心概述
一个JVM实例只存在一个堆内存，堆也是Java内存管理的核心区域
Java堆区在JVM启动的时候即被创建，其空间大小也就确定了。是JVM管理的最大的一块内存空间，堆的大小是可以调节的
《Java虚拟机规范》规定，堆可以处于物理上不连续的内存空间，逻辑上是连续的
所有的线程共享Java堆，在这里还可以划分线程私有的缓冲区（Thread Local Allocation Buffer , TLAB）
《Java虚拟机规范》中对Java堆的描述是：所有的对象实例以及数组都应当在运行时分配在堆上
数组和对象可能永远不会存储在栈上，因为栈帧中保存引用，这个引用指向对象或者数组在堆中的位置。
在方法结束后，堆中的对象不会马上被移除，仅仅在垃圾收集的时候才会被移除
堆，是GC（Garbage Collection）执行垃圾回收的重点区域。

堆内存细分
现代垃圾收集器大部分都基于分代收集理论设计，堆空间细分为：
Java7及之前堆内存逻辑上分为三部分：新生代(Young:Eden+Survivor:(S0+S1))+老年代(Old)+永久区(Perm)
Java8及之后堆内存逻辑上分为三部分：新生代(Young:Eden+Survivor:(S0+S1))+老年代(Old)+元空间(Meta)

2、设置堆内存大小与OOM
Java堆区用于存储Java对象实例，那么堆的大小在JVM启动时就已经设定好了，大家可以通过选项"-Xmx"和"-Xms"来进行设置。
    "-Xms"用于表示堆区的起始内存，等价于-XX:InitialHeapSize
    "-Xmx"用于表示堆区的最大内存，等价于-XX:MaxHeapSize
一旦堆区中的内存大小超过了"-Xmx"所指定的最大内存时，将会抛出OutOfMemoryError异常
通过会将-Xms和-Xmx两个参数配置相同的值，其目的时为了能够在Java垃圾回收机制清理完堆区后不需要重新分隔计算堆区的大小，从而提高性能
默认情况下，初始内存大小：物理电脑内存大小 / 64
           最大内存大小：物理内存大小 / 4
使用JDK自带的jvisualvm工具查看visualGC 信息
JPS查看Java运行进程，jstat -gc pid查看进程中堆内存大小及使用情况
                    jinfo -flag NewRatio pid

3、年轻代与老年代
配置新生代和老年代在对结构的占比：
默认-XX:NewRatio=2,表示新生代占1，老年代占2，新生代占整个堆内存的1/3
可以修改-XX:NewRatio=4,表示新生代占1，老年代占4，新生代占整个堆内存的1/5
在HotSpot中，Eden区与Survivor区中的S0和S1空间所占的比例是8:1:1
开发人员也可以通过"-XX:SurvivorRatio"设置上述比例，例如：-XX:SurvivorRatio=8
几乎所有的Java对象都是在Eden区被new出来的。
绝大数的Java对象的销毁都在新生代进行了
可以使用-Xmn设置新生代的空间大小

4、图解对象分配过程

5、Minor GC、Major GC、Full GC
YGC 等同于 Minor GC
Old GC 等同于 Major GC
混合收集(mixed GC)：收集整个新生代以及部分老年代的垃圾收集
整堆收集(full GC): 收集整个Java堆和方法区的垃圾收集 

6、堆空间分代思想
为什么需要把Java堆分代？不分代就不能正常工作了码？
经研究，不同对象的生命周期不同，70-90%的对象是临时对象
>新生代：有Eden区，两块大小相同的Survivor(from/to, s0/s1)构成，to总为空
>老年代，存放新生代中经历多次GC任然存活的对象
起始不分代完全可以，分代的唯一理由就是优化GC性能。

7、内存分配策略
针对不同年龄段的对象分配原则：
优先分配到Eden
大对象直接分配到老年代（应尽量避免程序中出现过多的大对象）
长期存活的对象存储在老年代
动态对象年龄判断：如果Survivor区中相同年龄的所有对象大小的总和和大于Survivor空间的一半，年龄大于等于该年龄的对象直接存放到老年代，无需等待MaxTenuringThreshold中要求的年龄。
空间分配担保
    -XX:HandlePromotionFailure

8、为对象分配内存 TLAB
为什么要有TLAB（Thread Local Allocation Buffer）
堆区是线程共享区域，任何线程都可以访问到堆区中的共享数据
由于对象实例的创建在JVM中非常频繁，因此在并发环境下从堆区中划分内存空间是线程不安全的
为避免多个线程操作同一个地址，需要使用加锁等机制，进而影响分配速度
什么是TLAB?
从内存模型而不是垃圾收集的角度，对Eden区域继续进行划分，JVM为每个线程分配了一个私有缓存区域，它包含在Eden空间内
多线程同时分配内存时，使用TLAB可以避免一系列的非线程安全问题，同时还能够提升内分配的吞吐量，因此我们可以将这种内存分配方式称为"快速分配策略"
所有OpenJDK衍生出来的JVM都提供了TLAB的设计
尽管不是所有的对象实例都能过在TLAB中成功分配内存，但JVM确实时将TLAB作为内存分配的首选。
在程序中，开发人员可以通过选项"-XX:UseTLAB"设置是否开启TLAB空间。
默认情况下，TLAB空间的内存非常小，仅占有整个Eden空间的1%，当然我们可以通过选项"-XX:TLABWasteTargetPercent"设置TLAB空间所占用Eden的百分比大小。
一旦对象在TLAB空间分配内存失败时，JVM就尝试着通过使用加锁机制确保数据操作的原子性，从而直接在Eden空间中分配内存。

9、小结堆空间的参数设置
https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
-XX:+PrintFlagsInitial : 查看所有的参数默认初始值
-XX:+PrintFlagsFinal : 查看所有的参数的最终值
-Xms : 初始堆内存（默认物理内存的1/64）
-Xmx : 最大堆内存 (默认物理内存的1/4)
-Xmn : 设置新生代的大小(初始值及最大值)
-XX:NewRatio ： 配置新生代与年老代在堆结构的占比
-XX:SurvivorRatio ： 设置新生代中Eden和s0/s1空间的比例
-XX:MaxTenuringThreshold ： 设置新生代垃圾的最大年龄
-XX:+PrintGCDetails : 输出详细的GC处理日志
打印GC简要信息：1）、-XX:+PrintGC 2)、-verbose:gc
-XX:HandlePromotionFailure: 是否设置空间分配担保

X、堆是分配对象的唯一选择码？
No、

XI、逃逸分析
参数-server，启动server模式，因为在server模式下，才可以启用逃逸分析
使用逃逸分析，编译器可以对代码做如下优化：
1、栈上分配，将堆分配转化为栈分配。如果一个对象在子程序中被分配，要是指向该对象的指针永远不会逃逸，对象可能是栈分配的候选，而不是堆分配
2、同步策略，如果一个对象被发现只能从一额线程被访问到，那么对于这个对象的操作可以不考虑同步
3、分离对象或标量(scalar)替换，有的对象可能不需要作为一个连续的内存结构存在也可以被访问到，那么对象的部分可以不存储在内存，而是存储在CPU寄存器中。


``` 
### 方法区
```text
1、堆、栈、方法区的交互关系
从线程共享与否的角度来看：
线程共享：堆， 元空间
线程私有：虚拟机栈、本地方法栈、程序计数器(不会报异常， 不存在GC)
User user = new User();
User类本身存放在方法区
user引用存放在栈空间(Java本地变量表)，引用类型指针指向堆
new User()存放在堆空间，堆空间的指针指向方法区的对象实例数据

2、方法区的理解
方法区看作是一块独立于Java堆的内存空间
方法区（Method Area）与Java堆一样，是各个线程共享的内存区域。
方法区在JVM启动的时候被创建，并且它的实际物理内存空间中和Java堆区一样都可以是不连续的
方法区的大小，跟堆空间一样，可以选择固定大小或者可扩展
方法区的大小决定了系统可以保存多少个类，如果系统定义了太多的类，导致方法区溢出，虚拟机同样会抛出内存溢出错误：
        java.lang.OutOfMemoryError: PermGen space或者java.lang.OutOfMemoryError:Metaspace
    导致溢出的情况有：加载大量的第三方的jar包，Tomcat部署的工程过多，大量动态的反射类
关闭JVM就会释放这个区域的内存。

设置方法区大小与OOM
JDK7-：通过-XX:PermSize来设置永久代初始分配空间。默认是20.75M
          -XX:MaxPermSize来设定永久代最大可分配空间。32位机器默认是64M，64位机器默认模式是82M
JDK8+： -XX:MetaspaceSize=21M 默认21M
        -XX:MaxMetaspaceSize=-1 的值是-1，即没有限制
内存溢出(OOM)
内存泄漏(Memory Leak)

方法区的内部结构
方法区用于存储已被虚拟机加载的类型信息，常量，静态变量，即时编译器编译后的代码缓存
类型信息：对每个加载的类型(类class、接口interface、枚举enum、注解annotation)，JVM必须在方法区中存储以下类型信息：
(1)、这个类型的完整有效名称(全名=包名.类名)
(2)、这个类型直接父类的完整有效名(对于interface或者java.lang.object都没有父类)
(3)、这个类型的修饰符(public，abstract,final的某个子集)
(4)、这个类型直接接口的一个有序列表
域(Field)信息：JVM必须在方法区中保存类型的所有域的相关信息以及域的声明顺序
    域的相关信息包括：域名称、域类型、域修饰符（public，private、protected、static、final、volatile、transient）
方法信息：JVM必须保存所有方法的以下信息，同域信息一样包括声明顺序：
    方法名称
    方法的返回类型
    方法参数的数量和类型
    方法的修饰符
    方法的字节码，操作数栈，局部变量表及大小
    异常表
    
方法区内部包含了运行时常量池
常量池可以看作是一张表，虚拟机指令根据这张常量表找到要执行的类名，方法名，参数类型，字面量等类型。
运行时常量池是方法区的一部分
常量池是class文件的一部分，用于存放编译期生成的各种字面量与符号引用，这部分内容将在类加载后存放到方法区的运行时常量池中

方法区使用举例

方法区的演进细节
元空间不在虚拟机设置的内存中，而是使用本地内存

方法区的垃圾回收

总结

```

### 注解与反射
```text
注解的作用:
可以对程序作出解释、可以被其他程序读取（如：被编译器读取）

注解使用在:
可以附加在package,class,method,field等上面，相当于给他们添加了额外的辅助信息，
可以通过反射机制实现对这些元数据的访问

元注解:
@Target,定义注解的作用域:ElementType.TYPE 作用在类上, ElementType.METHOD作用在方法上
@Retention,定义注解何时有效:RetentionPolicy.RUNTIME运行时有效

Java反射机制机制
Refection(反射)是Java被视为动态语言的关键，反射机制运行程序在执行期间借助Reflection API取得任何类的内部信息，
并能直接操作任何对象的内部属性及方法。
Class c = Class.forName("java.lang.String");
加载完类之后，在堆内存的方法中就产生了一个Class类型的对象（一个类只有一个Class对象），,
这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构。
反射：
    正常方式：引入需要的“包类”名称 > 通过new实例化 > 取得实例化对象
    反射方法：实例化对象 > getClass()方法 > 取得完整的“包类”名称
反射优缺点:
    优点：可以实现动态创建对象和编译，体现出很大的灵活性
    缺点：对性能有影响。使用反射基本上是一种解释操作，我们可以告诉JVM，我们希望做什么并且它满足我们的要求。这类操作总是慢于直接执行相同的操作。


理解CLass类并获取Class实例
对于每个类而言， JRE为其保留了一个不变的Class类型的对象。
一个Class对象包含特定某个结构(class/interface/enum/annotation/primitive type/void)的有关信息。
Class本身也是一个类
Class对象只能由系统建立对象
一个加载的类在JVM中智慧有一个Class实例
一个Class对象对应的是一个加载到JVM中的.class文件
每个类的实例都会记得自己是由那个Class实例所生成
通过Class可以完整地得到一个类中的所有被加载的结构
Class类是Reflection的根源， 针对任何你想动态加载、运行的类，唯有先获得相应的Class对象

有了Class对象，可以做什么？
创建类的对象， 调用Class对象的newInstance()方法
1、类必须有一个无参构造器
2、类的构造器的访问权限需要足够
可以查看例子

类的加载与ClassLoader

创建运行时类的对象

获取运行时类的完整结构

调用运行时类的指定结构

补充：
Java提供了一套独特的反射API来描述类，使得Java程序在运行时可以获得任何一个类的字节码信息，包括类的修饰符（public、static等）、基类（超类、父类）、实现的接口、字段和方法等信息，并可以根据字节码信息来创建该类的实例对象，改变对象的字段内容和调用对象方法。
Class是Java反射中的一个核心类，它代表了内存中的一个Java类。通过它可以取得类的各种操作属性，这些属性是通过java.lang.reflect包中的反射API来描述的。
● Constructor：用来描述一个类的构造方法。
● Field：用来描述一个类的成员变量。
● Method：用来描述一个类的方法。
● Modifer：用来描述类内各元素的修饰符。
● Array：用来对数组进行操作。

```

### Vavr
```text
官方网站:
https://docs.vavr.io/
https://www.baeldung.com/java-vavr
https://www.baeldung.com/tag/vavr/

more:
https://www.baeldung.com/vavr-tutorial

Api列表: 
https://www.javadoc.io/doc/io.vavr/vavr/0.10.3/index.html

```

### Guava
```text
GuavaCache有两种创建方式：
CacheLoader 和 Callable callback

```

### Java集合
```text
容器，就是可以容纳其他Java对象的对象。
其始于JDK 1.2，优点是: 
1、降低编程难度 
2、提高程序性能 
3、提高API间的互操作性 
4、降低学习难度 
5、降低设计和实现相关API的难度 
6、增加程序的重用性 
Java容器里只能放对象，对于基本类型(int, long, float, double等)，需要将其包装成对象类型后(Integer, Long, Float, Double等)才能放到容器里。
很多时候拆包装和解包装能够自动完成。这虽然会导致额外的性能和空间开销，但简化了设计和编程。

容器主要包括 Collection 和 Map 两种，Collection 存储着对象的集合，而 Map 存储着键值对(两个对象)的映射表。
Set
1、TreeSet : 基于红黑树实现，支持有序性操作，例如根据一个范围查找元素的操作。但是查找效率不如 HashSet，HashSet 查找的时间复杂度为 O(1)，TreeSet 则为 O(logN)。 
2、HashSet : 基于哈希表实现，支持快速查找，但不支持有序性操作。并且失去了元素的插入顺序信息，也就是说使用 Iterator 遍历 HashSet 得到的结果是不确定的。 
3、LinkedHashSet : 具有 HashSet 的查找效率，且内部使用双向链表维护元素的插入顺序。

List
1、ArrayList ：基于动态数组实现，支持随机访问。
2、Vector ：和 ArrayList 类似，但它是线程安全的。 
3、LinkedList : 基于双向链表实现，只能顺序访问，但是可以快速地在链表中间插入和删除元素。不仅如此，LinkedList 还可以用作栈、队列和双向队列。

Queue
1、LinkedList : 可以用它来实现双向队列。
2、PriorityQueue ：基于堆结构实现，可以用它来实现优先队列。

Map
1、TreeMap ： 基于红黑树实现。 
2、HashMap ： 基于哈希表实现。 
3、HashTable ： 和 HashMap 类似，但它是线程安全的，这意味着同一时刻多个线程可以同时写入 HashTable 并且不会导致数据不一致。它是遗留类，不应该去使用它。
    现在可以使用 ConcurrentHashMap 来支持线程安全，并且 ConcurrentHashMap 的效率会更高，因为 ConcurrentHashMap 引入了分段锁。 
4、LinkedHashMap 使用双向链表来维护元素的顺序，顺序为插入顺序或者最近最少使用(LRU)顺序。
```

#### Java集合 - ArrayList源码解析
```text
ArrayList实现了List接口，是顺序容器，即元素存放的数据与放进去的顺序相同，允许放入null元素，底层通过数组实现。
每当向数组中添加元素时，都要去检查添加后元素的个数是否会超出当前数组的长度，如果超出，数组将会进行扩容，以满足添加数据的需求。
数组扩容通过一个公开的方法ensureCapacity(int minCapacity)来实现。在实际添加大量元素前，我也可以使用ensureCapacity来手动增加ArrayList实例的容量，以减少递增式再分配的数量。
ArrayList 扩容机制：
int oldCapacity = elementData.length;
int newCapacity = oldCapacity + (oldCapacity >> 1);
数组进行扩容时，会将老数组中的元素重新拷贝一份到新的数组中，每次数组容量的增长大约是其原容量的1.5倍。
这种操作的代价是很高的，因此在实际使用时，我们应该尽量避免数组容量的扩张。当我们可预知要保存的元素的多少时，要在构造ArrayList实例时，就指定其容量，以避免数组扩容的发生。
或者根据实际需求，通过调用ensureCapacity方法来手动增加ArrayList实例的容量。
查看：Java集合ArrayList源码.png
```

#### Java集合 - LinkedList源码解析
```text
LinkedList同时实现了List接口和Deque接口，也就是说它既可以看作一个顺序容器，又可以看作一个队列(Queue)，同时又可以看作一个栈(Stack)。
这样看来LinkedList简直就是个全能冠军。当你需要使用栈或者队列时，可以考虑使用LinkedList，一方面是因为Java官方已经声明不建议使用Stack类，更遗憾的是，
Java里根本没有一个叫做Queue的类(它是个接口名字)。关于栈或队列，现在的首选是ArrayDeque，它有着比LinkedList(当作栈或队列使用时)有着更好的性能。

LinkedList的实现方式决定了所有跟下标相关的操作都是线性时间，而在首段或者末尾删除元素只需要常数时间。
为追求效率LinkedList没有实现同步(synchronized)，如果需要多个线程并发访问，可以先采用Collections.synchronizedList()方法对其进行包装。

底层数据结构：
    LinkedList底层通过双向链表实现。
    双向链表的每个节点用内部类Node表示。LinkedList通过first和last引用分别指向链表的第一个和最后一个元素。注意这里没有所谓的哑元，当链表为空的时候first和last都指向null。
    哑元：某个参数如果在子程序或函数中没有用到，那就被称为哑元。
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;
    其中Node:
            private static class Node<E> {
                E item;
                Node<E> next;
                Node<E> prev;
        
                Node(Node<E> prev, E element, Node<E> next) {
                    this.item = element;
                    this.next = next;
                    this.prev = prev;
                }
            }

方法介绍：
1、add(int index, E element)
因为链表双向的，可以从开始往后找，也可以从结尾往前找，具体朝那个方向找取决于条件：index < (size >> 1)




```

#### Java集合 - Stack和Queue
```text
Java里有一个叫做Stack的类，却没有叫做Queue的类(它是个接口名字)。
当需要使用栈时，Java已不推荐使用Stack，而是推荐使用更高效的ArrayDeque；既然Queue只是一个接口，当需要使用队列时也就首选ArrayDeque了(次选是LinkedList)。

Queue
Queue接口继承自Collection接口，除了最基本的Collection的方法之外，它还支持额外的insertion, extraction和inspection操作。

Deque
Deque是"double ended queue", 表示双向的队列，英文读作"deck". Deque 继承自 Queue接口，除了支持Queue的方法之外，还支持insert, remove和examine操作，由于Deque是双向的，所以可以对队列的头和尾都进行操作。
当把Deque当做FIFO的queue来使用时，元素是从deque的尾部添加，从头部进行删除的； 所以deque的部分方法是和queue是等同的。
Deque的含义是“double ended queue”，即双端队列，它既可以当作栈使用，也可以当作队列使用。

ArrayDeque和LinkedList是Deque的两个通用实现，由于官方更推荐使用AarryDeque用作栈和队列。
ArrayDeque底层通过数组实现，为了满足可以同时在数组两端插入或删除元素的需求，该数组还必须是循环的，即循环数组(circular array)，也就是说数组的任何一点都可能被看作起点或者终点。
ArrayDeque是非线程安全的(not thread-safe)，当多个线程同时使用的时候，需要程序员手动同步；另外，该容器不允许放入null元素。
head指向首端第一个有效元素，tail指向尾端第一个可以插入元素的空位。因为是循环数组，所以head不一定总等于0，tail也不一定总是比head大。

```


### 备注
```text
Java反编译命令：
javap -verbose xxx.class
javap -v xxx.class
jstat -gc pid 
jinfo -flag NewRatio pid 
-Xmx1G 
-Xms1G 
-XX:+DoEscapeAnalysis 开启逃逸分析 
-XX:+PrintGCDetails
-XX:+EliminateAllocations 开启标量替换，运行将对象打散分配在栈中

```

### Current Looking Url
```text
https://www.bilibili.com/video/BV1wh411C7uS?p=2
https://www.liaoxuefeng.com/wiki/1252599548343744/1265119084411136
```

## Reconsitution
```text
代码重构


```

## Antlr
```text

官方地址：https://www.antlr.org/
getting-started地址： https://github.com/antlr/antlr4/blob/master/doc/getting-started.md
集成IDE地址： https://github.com/antlr/antlr4/blob/master/doc/IDEs.md
g4语法地址： https://github.com/antlr/grammars-v4
```