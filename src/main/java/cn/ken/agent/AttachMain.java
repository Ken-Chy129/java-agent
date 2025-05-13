package cn.ken.agent;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author Ken-Chy129
 * @date 2025/5/14
 */
public class AttachMain {

    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("31856");
        vm.loadAgent("D:\\Java\\java-agent\\target\\agent-1.0-SNAPSHOT.jar");
    }
}
