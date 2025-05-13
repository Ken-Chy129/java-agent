package cn.ken.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.File;
import java.lang.instrument.ClassFileTransformer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.ProtectionDomain;

/**
 * @author Ken-Chy129
 * @date 2025/5/14
 */
public class TestTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (!className.endsWith("Base")) {
            return classfileBuffer;
        }
        System.out.println("Transforming " + className);
        try {
            return Files.readAllBytes(new File("D:\\Java\\java-agent\\target\\classes\\cn\\ken\\Base.class").toPath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("123");
        return null;
    }
}
