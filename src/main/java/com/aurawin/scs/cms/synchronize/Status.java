package com.aurawin.scs.cms.synchronize;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Status {

    private JTable tblStatus;
    public JPanel mainPanel;
    private JButton btnDisplay;
    private JButton btnSettings;
    private JButton btnStatus;

    private static FileStatusTableModel tableModel;
    private DefaultTableCellRenderer Renderer;
    private JPopupMenu puStatus;
    private JMenuItem miStatusPause;
    private JMenuItem miStatusCancel;


    public Status() {
        tableModel = new FileStatusTableModel();

        for (int lcv=0; lcv<1000; lcv++)
          tableModel.addFileStatus(new FileStatus("/userpath/testfolder/test-file.txt","Upload","Waiting"));

        Renderer = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(JLabel.CENTER);

        tblStatus.setModel(tableModel);

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

    }


    private void setColumnWidth(int col, int width){
        tblStatus.getColumnModel().getColumn(col).setPreferredWidth(width);
        tblStatus.getColumnModel().getColumn(col).setMaxWidth(width);
        tblStatus.getColumnModel().getColumn(col).setMinWidth(width);
        tblStatus.getColumnModel().getColumn(col).setCellRenderer(Renderer);
    }
}