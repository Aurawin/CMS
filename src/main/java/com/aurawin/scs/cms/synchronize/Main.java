package com.aurawin.scs.cms.synchronize;

import javax.swing.*;
import java.awt.*;

import static com.aurawin.scs.cms.synchronize.DisplayMode.dmLogin;
import static com.aurawin.scs.cms.synchronize.DisplayMode.dmSettings;
import static com.aurawin.scs.cms.synchronize.DisplayMode.dmStatus;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static JFrame frameMain;
    public static Main mainForm;
    public static Login loginForm;
    public static Status statusForm;
    public static Settings settingsForm;

    public static boolean Loading;
    public DisplayMode Display;

    private JPanel mainPanel;

    public void changeFrame(JPanel panel) {
        JPanel contentPane = (JPanel) frameMain.getContentPane();

        contentPane.removeAll();

        contentPane.add(panel);
        contentPane.revalidate();
        contentPane.repaint();

        if (panel == loginForm.mainPanel) {
            Display = dmLogin;
        } else if (panel == statusForm.mainPanel) {
            Display = dmStatus;
        } else if (panel==settingsForm.mainPanel){
            Display= dmSettings;
        }
    }
    public static void main(String[] args) {
        Loading = true;
        frameMain = new JFrame("mainPanel");

        mainForm = new Main();
        loginForm = new Login();
        statusForm = new Status();
        settingsForm = new Settings();

        frameMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameMain.setPreferredSize(new Dimension(640, 480));
        frameMain.setTitle("Aurawin CMS Synchronization");
        frameMain.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameMain.setLocation(dim.width/2-frameMain.getSize().width/2, dim.height/2-frameMain.getSize().height/2);

        frameMain.setVisible(true);

        mainForm.changeFrame(loginForm.mainPanel);


    }
}
