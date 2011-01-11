package net.minecraft.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GuiStatsListener implements ActionListener {

    final GuiStatsComponent a; /* synthetic field */

    GuiStatsListener(GuiStatsComponent guistatscomponent) {
        super();
        a = guistatscomponent;
    }

    public void actionPerformed(ActionEvent actionevent) {
        GuiStatsComponent.a(a);
    }
}
