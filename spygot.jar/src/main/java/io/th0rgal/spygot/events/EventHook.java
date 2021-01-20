package io.th0rgal.spygot.events;

import io.th0rgal.spygot.SpygotPlugin;
import io.th0rgal.spygot.shared.templates.EventListener;
import org.bukkit.Bukkit;
import org.bukkit.event.*;
import org.bukkit.plugin.EventExecutor;

public class EventHook implements Listener, EventExecutor {

    private final EventListener eventListener;
    public EventHook(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void register() {
        Bukkit.getPluginManager().registerEvent(this.eventListener.getType(), this, EventPriority.NORMAL, this, SpygotPlugin.get());
    }

    @Override
    public void execute(Listener listener, Event event) {
        eventListener.receive(event);
    }

    public void unregister() {
        HandlerList.unregisterAll();
    }

}
