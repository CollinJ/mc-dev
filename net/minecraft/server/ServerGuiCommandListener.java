package net.minecraft.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class ServerGuiCommandListener implements ActionListener {

    final JTextField a; /* synthetic field */
    final ServerGUI b; /* synthetic field */

    ServerGuiCommandListener(ServerGUI servergui, JTextField jtextfield) {
        super();
        b = servergui;
        a = jtextfield;
    }

    public void actionPerformed(ActionEvent actionevent) {
        String s = a.getText().trim();

        if (s.length() > 0) {
            ServerGUI.a(b).a(s, ((ICommandListener) (b)));
        }
        a.setText("");
    }
}
