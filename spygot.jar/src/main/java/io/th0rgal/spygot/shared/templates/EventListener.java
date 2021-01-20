package io.th0rgal.spygot.shared.templates;

import org.bukkit.event.Event;

public interface EventListener {

    Class<? extends Event> getType();

    void receive(Event event);

}
