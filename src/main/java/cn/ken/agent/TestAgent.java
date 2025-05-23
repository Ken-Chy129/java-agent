package cn.ken.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author Ken-Chy129
 * @date 2025/5/14
 */
public class TestAgent {

    public static void agentmain(String args, Instrumentation inst) {
        //指定我们自己定义的Transformer，在其中利用Javassist做字节码替换
        inst.addTransformer(new TestTransformer());
        try {
            //重定义类并载入新的字节码
            inst.retransformClasses();
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }

    public static void premain(String args, Instrumentation inst) {
        TestTransformer testTransformer = new TestTransformer();
        inst.addTransformer(testTransformer);
    }
}
