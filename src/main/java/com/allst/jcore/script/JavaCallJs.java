package com.allst.jcore.script;

import javax.script.*;
import java.io.FileReader;

/**
 * java调用JavaScript
 *
 * jrunscript 命令
 *
 * model.js文件内容
 * function formula(var1,var2){
 * return var1 + var2 ＊ factor;
 * }
 *
 * @author Hutu
 * @since 2023-06-07 下午 10:08
 */
public class JavaCallJs {
    public static void main(String[] args) throws Exception {
        //获得一个JavaScript的执行引擎
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        //建立上下文变量
        Bindings bind = engine.createBindings();
        bind.put("factor", 2);
        //绑定上下文，作用域是当前引擎范围
        engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
        /*Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int first = input.nextInt();
            int sec = input.nextInt();
            System.out.println("输入参数是：" + first + "," + sec);
            //执行js代码
            engine.eval(new FileReader("e:/TestData/Destop/model.js"));
            //是否可调用方法
            if (engine instanceof Invocable) {
                Invocable in = (Invocable) engine;
                //执行js中的函数
                Double result = (Double) in.invokeFunction("formula", first, sec);
                System.out.println("运算结果：" + result.intValue());
            }
        }*/
        engine.eval(new FileReader("E:/IdeaProjects/allst-jcore/src/main/resources/model.js"));
        //是否可调用方法
        if (engine instanceof Invocable) {
            Invocable in = (Invocable) engine;
            //执行js中的函数
            Double result = (Double) in.invokeFunction("formula", 2, 3);
            System.out.println("exec result is : " + result.intValue());
        }
    }
}
