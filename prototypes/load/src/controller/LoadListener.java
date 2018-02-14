package controller;

import model.GizmoLoader;
import model.Model;
import view.Board;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class LoadListener implements ActionListener {

    Model model;
    JPanel board;

    public LoadListener(Model m, JPanel board) {
        model = m;
        this.board = board;
    }

    public void actionPerformed() {


        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select Gizmo Save");
        jfc.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("(.giz) Gizmo Saves", "giz");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();

            GizmoLoader loader = new GizmoLoader(model, selectedFile.getAbsolutePath());
            loader.loadSave();
            board.repaint();

            System.out.println(selectedFile.getAbsolutePath());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        actionPerformed();
    }
}
