package com.aurawin.scs.cms.synchronize;

import com.aurawin.core.file.DialogMode;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import static com.aurawin.core.file.DialogKind.dkOpen;
import static com.aurawin.core.file.DialogMode.dmFolder;
import static com.aurawin.scs.cms.synchronize.Controller.mainController;
import static com.aurawin.scs.cms.synchronize.Controller.settingsForm;
import static com.aurawin.scs.cms.synchronize.DisplayMode.dmSettings;
import static com.aurawin.scs.cms.synchronize.DisplayMode.dmStatus;

public class Settings {
    public JPanel mainPanel;
    public JPanel pnlTop;
    public JLabel lblTitle;
    public JButton btnCurrent;
    public JButton btnDisplay;
    public JButton btnSettings;
    public JButton btnStatus;
    public JTextField txtPath;
    private JPanel pnlClient;
    private JLabel lblPath;
    public JSpinner sThreads;
    private JButton btnBrowsePath;

    public Settings() {
        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.changeFrame(dmSettings);
            }
        });
        btnStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainController.changeFrame(dmStatus);
            }
        });
        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.setNavExpansion(!mainController.navRevealed);
            }
        });
        txtPath.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                mainController.saveTimer.setEnabled();
            }
        });
        sThreads.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                mainController.saveTimer.setEnabled();
            }
        });
        btnBrowsePath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.Dialog.setKind(dkOpen);
                Controller.Dialog.setMode(dmFolder);
                int ioR = Controller.Dialog.showOpenDialog(settingsForm.btnBrowsePath);
                switch (ioR) {
                    case JFileChooser.APPROVE_OPTION:
                        File input = Controller.Dialog.getSelectedFile();
                        if (input.exists()) {
                            settingsForm.txtPath.setText(input.toString());
                        }
                        break;
                }
            }
        });
    }

    public void init(){
        sThreads.setModel(new SpinnerNumberModel(0, 0, 20, 1));
    }
}
