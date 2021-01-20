package io.th0rgal.spygot;

import io.th0rgal.spygot.shared.SharedOut;
import io.th0rgal.spygot.shared.templates.PythonSpygot;
import org.bukkit.plugin.java.JavaPlugin;
import py4j.GatewayServer;

public class SpygotPlugin extends JavaPlugin {

    private static SpygotPlugin plugin;
    public final SharedOut sharedMemory;
    private GatewayServer gatewayServer;

    public SpygotPlugin() {
        plugin = this;
        sharedMemory = new SharedOut();
    }

    public void onLoad() {
        GatewayServer.turnLoggingOff();
        GatewayServer gatewayServer = new GatewayServer(sharedMemory);
        gatewayServer.start();
        PythonSpygot hello = (PythonSpygot) gatewayServer.getPythonServerEntryPoint(new Class[]{PythonSpygot.class});
        try {
            hello.log("Hello World on the Python side");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onEnable() {
        System.out.println("Hello World on the Spigot side");
    }

    public void onDisable() {
        gatewayServer.shutdown();
    }

    public static SpygotPlugin get() {
        return plugin;
    }

}
