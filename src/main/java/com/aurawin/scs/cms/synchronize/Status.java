package com.aurawin.scs.cms.synchronize;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.aurawin.scs.cms.synchronize.Controller.mainController;
import static com.aurawin.scs.cms.synchronize.Controller.statusForm;
import static com.aurawin.scs.cms.synchronize.DisplayMode.dmSettings;
import static com.aurawin.scs.cms.synchronize.DisplayMode.dmStatus;

public class Status {
    public JTable tblStatus;
    public JPanel mainPanel;
    public JButton btnDisplay;
    public JButton btnSettings;
    public JButton btnStatus;
    public JButton btnCurrent;
    public JPanel pnlTop;
    public JLabel lblTitle;

    private static FileStatusTableModel tableModel;
    public DefaultTableCellRenderer Renderer;
    public JPopupMenu puStatus;
    public JMenuItem miStatusPause;
    public JMenuItem miStatusCancel;


    public Status() {
        tableModel = new FileStatusTableModel();

        for (int lcv=0; lcv<1000; lcv++)
          tableModel.addFileStatus(new FileStatus("/userpath/testfolder/test-file.txt","Upload","Waiting"));

        Renderer = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(JLabel.CENTER);

        tblStatus.setModel(tableModel);
        tblStatus.setRowSelectionAllowed(true);
        setColumnWidth(1,75);
        setColumnWidth(2,75);

        puStatus = new JPopupMenu();
        miStatusPause = new JMenuItem("Pause");
        miStatusPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo Pause engine
            }
        });
        puStatus.add(miStatusPause);
        puStatus.add(new JSeparator());

        miStatusCancel = new JMenuItem("Cancel");
        miStatusCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo Cancel Selected Items
            }
        });

        tblStatus.setComponentPopupMenu(puStatus);

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
    }

    private void setColumnWidth(int col, int width){
        tblStatus.getColumnModel().getColumn(col).setPreferredWidth(width);
        tblStatus.getColumnModel().getColumn(col).setMaxWidth(width);
        tblStatus.getColumnModel().getColumn(col).setMinWidth(width);
        tblStatus.getColumnModel().getColumn(col).setCellRenderer(Renderer);
    }
}