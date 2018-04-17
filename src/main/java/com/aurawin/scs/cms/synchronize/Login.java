package com.aurawin.scs.cms.synchronize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
                Main.mainForm.changeFrame(Main.statusForm.mainPanel);

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frameMain.dispatchEvent(new WindowEvent(Main.frameMain, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
