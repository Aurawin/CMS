package com.aurawin.scs.cms.synchronize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static com.aurawin.scs.cms.synchronize.Controller.mainController;
import static com.aurawin.scs.cms.synchronize.DisplayMode.dmStatus;

public class Login {
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton cancelButton;
    private JButton loginButton;
    public JPanel mainPanel;

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.changeFrame(dmStatus);

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.frameMain.dispatchEvent(new WindowEvent(Controller.frameMain, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
