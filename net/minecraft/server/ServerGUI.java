package net.minecraft.server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ServerGUI extends JComponent implements ICommandListener {

    public static Logger a = Logger.getLogger("Minecraft");
    private MinecraftServer b;

    public static void a(MinecraftServer minecraftserver) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exception) {}
        ServerGUI servergui = new ServerGUI(minecraftserver);
        JFrame jframe = new JFrame("Minecraft server");

        jframe.add(((java.awt.Component) (servergui)));
        jframe.pack();
        jframe.setLocationRelativeTo(((java.awt.Component) (null)));
        jframe.setVisible(true);
        jframe.addWindowListener(((java.awt.event.WindowListener) (new ServerWindowAdapter(minecraftserver))));
    }

    public ServerGUI(MinecraftServer minecraftserver) {
        b = minecraftserver;
        setPreferredSize(new Dimension(854, 480));
        setLayout(((java.awt.LayoutManager) (new BorderLayout())));
        try {
            add(((java.awt.Component) (d())), "Center");
            add(((java.awt.Component) (a())), "West");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private JComponent a() {
        JPanel jpanel = new JPanel(((java.awt.LayoutManager) (new BorderLayout())));

        jpanel.add(((java.awt.Component) (new GuiStatsComponent())), "North");
        jpanel.add(((java.awt.Component) (b())), "Center");
        jpanel.setBorder(((javax.swing.border.Border) (new TitledBorder(((javax.swing.border.Border) (new EtchedBorder())), "Stats"))));
        return ((JComponent) (jpanel));
    }

    private JComponent b() {
        PlayerListBox playerlistbox = new PlayerListBox(b);
        JScrollPane jscrollpane = new JScrollPane(((java.awt.Component) (playerlistbox)), 22, 30);

        jscrollpane.setBorder(((javax.swing.border.Border) (new TitledBorder(((javax.swing.border.Border) (new EtchedBorder())), "Players"))));
        return ((JComponent) (jscrollpane));
    }

    private JComponent d() {
        JPanel jpanel = new JPanel(((java.awt.LayoutManager) (new BorderLayout())));
        JTextArea jtextarea = new JTextArea();

        a.addHandler(((java.util.logging.Handler) (new GuiLogOutputHandler(jtextarea))));
        JScrollPane jscrollpane = new JScrollPane(((java.awt.Component) (jtextarea)), 22, 30);

        jtextarea.setEditable(false);
        JTextField jtextfield = new JTextField();

        jtextfield.addActionListener(((java.awt.event.ActionListener) (new ServerGuiCommandListener(this, jtextfield))));
        jtextarea.addFocusListener(((java.awt.event.FocusListener) (new ServerGuiFocusadapter(this))));
        jpanel.add(((java.awt.Component) (jscrollpane)), "Center");
        jpanel.add(((java.awt.Component) (jtextfield)), "South");
        jpanel.setBorder(((javax.swing.border.Border) (new TitledBorder(((javax.swing.border.Border) (new EtchedBorder())), "Log and chat"))));
        return ((JComponent) (jpanel));
    }

    public void b(String s) {
        a.info(s);
    }

    public String c() {
        return "CONSOLE";
    }

    static MinecraftServer a(ServerGUI servergui) {
        return servergui.b;
    }
}
