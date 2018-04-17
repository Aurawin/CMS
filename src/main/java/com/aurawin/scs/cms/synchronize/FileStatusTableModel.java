package com.aurawin.scs.cms.synchronize;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class FileStatusTableModel extends AbstractTableModel {
    public static ArrayList<FileStatus> Files = new ArrayList<>();


    private String[] columnHeadings = {"File","Operation" ,"Status"};
    @Override
    public int getRowCount() {
        return Files.size();
    }
    @Override
    public int getColumnCount() {
        return columnHeadings.length;
    }
    @Override
    public String getColumnName(int col) {
        return columnHeadings[col];
    }
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    @Override
    public Object getValueAt(int row, int col) {
        FileStatus file = (FileStatus) Files.get(row);
        switch (col) {
            case 0:
                return file.Filename;
            case 1:
                return file.Operation;
            case 2:
                return file.Status;
            default:
                return null;
        }
    }
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void addFileStatus(FileStatus fs) {
        Files.add(fs);
        fireTableDataChanged();
    }

    public void removeFileStatus(FileStatus fs) {
        Files.remove(fs);
        fireTableDataChanged();
    }

    public void addFileList(List l) {
        Files.addAll(l);
        fireTableDataChanged();
    }


}