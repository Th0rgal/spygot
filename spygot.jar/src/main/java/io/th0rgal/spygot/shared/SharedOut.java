package io.th0rgal.spygot.shared;

import io.th0rgal.spygot.events.EventHook;
import io.th0rgal.spygot.shared.templates.EventListener;

public class SharedOut {

    public void registerEventListener(EventListener eventListener) {
        new EventHook(eventListener).register();
    }

}
