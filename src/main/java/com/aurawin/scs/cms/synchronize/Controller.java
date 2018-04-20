package com.aurawin.scs.cms.synchronize;

import com.aurawin.core.file.DialogKind;
import com.aurawin.core.file.DialogMode;
import com.aurawin.core.file.SystemDialog;
import com.aurawin.scs.cms.synchronize.configuration.ConfigController;
import com.aurawin.scs.cms.synchronize.configuration.Configuration;
import com.aurawin.scs.cms.synchronize.configuration.SaveTimer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.UIManager.*;


import static com.aurawin.core.file.DialogKind.dkOpen;
import static com.aurawin.core.file.DialogMode.dmFolder;
import static com.aurawin.scs.cms.synchronize.DisplayMode.dmLogin;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Controller {


    public static String [] DisplayText = {"\u2039","\u203A"};
    public static String captionStatus = "\u25A4";
    public static String captionSettings = "\u2699";

    public static JFrame frameMain;
    public static Controller mainController;
    public static Login loginForm;
    public static Status statusForm;
    public static Settings settingsForm;
    public static SystemDialog Dialog;
    public static SaveTimer saveTimer;
    public static boolean Loading = true;


    public DisplayMode Display;
    public boolean navRevealed = true;

    private JPanel mainPanel;

    private void setNavigationButton(JButton src, JButton dst){
        dst.setText(src.getText());
    }
    private void setButtonCaptions(){
        settingsForm.btnStatus.setText(captionStatus);
        settingsForm.btnSettings.setText(captionSettings);
        statusForm.btnStatus.setText(captionStatus);
        statusForm.btnSettings.setText(captionSettings);
    }
    public void setNavExpansion(boolean value){
        navRevealed = value;
        settingsForm.btnStatus.setVisible(navRevealed);
        settingsForm.btnSettings.setVisible(navRevealed);
        statusForm.btnStatus.setVisible(navRevealed);
        statusForm.btnSettings.setVisible(navRevealed);

        settingsForm.btnDisplay.setText(mainController.DisplayText[(value)? 0:1]);
        statusForm.btnDisplay.setText(mainController.DisplayText[(value)? 0:1]);
    }
    public void navigationChanged(){
        setNavExpansion(navRevealed);
        switch (Display) {
            case dmStatus:
                setNavigationButton(statusForm.btnStatus, statusForm.btnCurrent);
                setNavigationButton(settingsForm.btnStatus, settingsForm.btnCurrent);
                break;
            case dmSettings:
                setNavigationButton(statusForm.btnSettings,statusForm.btnCurrent);
                setNavigationButton(settingsForm.btnSettings,settingsForm.btnCurrent);
                break;

        }
    }
    public void changeFrame(DisplayMode mode) {
        JPanel contentPane = (JPanel) frameMain.getContentPane();

        Display=mode;
        contentPane.removeAll();

        switch (mode) {
            case dmSettings:
                contentPane.add(Controller.settingsForm.mainPanel);
                break;
            case dmStatus:
                contentPane.add(Controller.statusForm.mainPanel);
                break;
            case dmLogin:
                contentPane.add(Controller.loginForm.mainPanel);
                break;
        }
        navigationChanged();
        contentPane.revalidate();
        contentPane.repaint();

    }
    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }
        try {
            com.aurawin.core.solution.Settings.Initialize("CMS", "Aurawin Synchronize Utility", "CMS");
        } catch(IOException ioe){

        }

        saveTimer = new SaveTimer();

        frameMain = new JFrame("mainPanel");

        mainController = new Controller();

        loginForm = new Login();
        statusForm = new Status();
        settingsForm = new Settings();

        Dialog = new SystemDialog(dkOpen,dmFolder);


        frameMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameMain.setPreferredSize(new Dimension(640, 480));
        frameMain.setTitle("Aurawin CMS Synchronization");
        frameMain.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameMain.setLocation(dim.width/2-frameMain.getSize().width/2, dim.height/2-frameMain.getSize().height/2);

        frameMain.setVisible(true);
        mainController.setButtonCaptions();
        mainController.changeFrame(dmLogin);

        settingsForm.init();
        ConfigController.init();
        ConfigController.Enforce();

        Loading =false;
    }
}
