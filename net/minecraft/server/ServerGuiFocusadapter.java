package net.minecraft.server;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

class ServerGuiFocusadapter extends FocusAdapter {

    final ServerGUI a; /* synthetic field */

    ServerGuiFocusadapter(ServerGUI servergui) {
        super();
        a = servergui;
    }

    public void focusGained(FocusEvent focusevent) {}
}
