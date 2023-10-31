package edu.umg.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserModifyInscInterface {
    private JPanel UserModifyInscInterface;
    private JComboBox comboBoxAlumnos;
    private JTextField textFieldModifyName;
    private JTextField textFieldModifyLastName;
    private JTextField textFieldModifyEmail;
    private JTextField textFieldCurso;
    private JButton btnUpdateData;
    private JButton btnBack;
    private JPanel jMainPanel;
    private void aplicarBorde(JComponent componente, Border borde) {componente.setBorder(borde);}
    public UserModifyInscInterface(){

        Border bordeNegroGrueso = BorderFactory.createLineBorder(Color.BLACK, 2);
        aplicarBorde(jMainPanel, bordeNegroGrueso);

        btnBack.setFocusPainted(false);
        btnUpdateData.setFocusPainted(false);

        btnUpdateData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //CERRAR FORMULARIO ACTUAL Y ABRIR EL NUEVO
                JFrame insert = (JFrame) SwingUtilities.getWindowAncestor(btnBack);
                insert.dispose();
                JFrame UserMenuInterface = new JFrame("Menu de Usuario");
                UserMenuInterface.setTitle("Menu de Usuario");
//      UserMenuInterface.setResizable(false);
                UserMenuInterface.setContentPane(new UserMenuInterface().getjMainPanel());
                UserMenuInterface.setIconImage(new ImageIcon("src/main/resources/img.jpg").getImage());
                UserMenuInterface.pack();
                UserMenuInterface.setSize(400, 400);
                UserMenuInterface.setLocationRelativeTo(null);
                UserMenuInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                UserMenuInterface.setVisible(true);
            }
        });



    }
    public JPanel getjMainPanel() {
        return jMainPanel;
    }
}
