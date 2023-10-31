package edu.umg.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInscriptionInterface {
    private JPanel UserInscriptionInterface;
    private JButton btnBack;
    private JTextField FEmail;
    private JTextField FLastName;
    private JTextField FNam;
    private JTextField FDate;
    private JTextField FCurso;
    private JButton btnAddStudent;
    private JPanel jMainPanel;
    private void aplicarBorde(JComponent componente, Border borde) {componente.setBorder(borde);}

    public UserInscriptionInterface(){
        Border bordeNegroGrueso = BorderFactory.createLineBorder(Color.BLACK, 2);
        aplicarBorde(jMainPanel, bordeNegroGrueso);

        // Eliminación de borde de enfoque de los botones
        btnAddStudent.setFocusPainted(false);
        btnBack.setFocusPainted(false);

        btnAddStudent.addActionListener(new ActionListener() {
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
