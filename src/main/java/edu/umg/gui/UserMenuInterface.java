package edu.umg.gui;

import edu.umg.gui.UserInscriptionInterface;
import edu.umg.dao.UsuariosDAO;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenuInterface {
    private JPanel UserMenuInterface;
    private JButton btnModifyInscripcion;
    private JButton btnSalir;
    private JButton btnInscripcion;
    private JButton btnDeleteInscription;
    private JPanel jMainPanel;
    private void aplicarBorde(JComponent componente, Border borde) {componente.setBorder(borde);}
    public UserMenuInterface() {
        Border bordeNegroGrueso = BorderFactory.createLineBorder(Color.BLACK, 2);
        aplicarBorde(jMainPanel, bordeNegroGrueso);


        // Eliminación de borde de enfoque de los botones
        btnInscripcion.setFocusPainted(false);
        btnModifyInscripcion.setFocusPainted(false);

        btnInscripcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insert = (JFrame) SwingUtilities.getWindowAncestor(btnInscripcion);
                insert.dispose();
                JFrame UserInscriptionInterface = new JFrame("Inscripción");
                UserInscriptionInterface.setTitle("Inscripción");
//              UserMenuInterface.setResizable(false);
                UserInscriptionInterface.setContentPane(new UserInscriptionInterface().getjMainPanel());
                UserInscriptionInterface.pack();
                UserInscriptionInterface.setSize(500, 400);
                UserInscriptionInterface.setIconImage(new ImageIcon("src/main/resources/img.jpg").getImage());
                UserInscriptionInterface.setLocationRelativeTo(null);
                UserInscriptionInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                UserInscriptionInterface.setVisible(true);
            }
        });

        btnModifyInscripcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insert = (JFrame) SwingUtilities.getWindowAncestor(btnModifyInscripcion);
                insert.dispose();
                JFrame UserModifyInscInterface = new JFrame("Modificar Inscripción");
                UserModifyInscInterface.setTitle("Modificar Inscripción");
//              UserMenuInterface.setResizable(false);
                UserModifyInscInterface.setContentPane(new UserModifyInscInterface().getjMainPanel());
                UserModifyInscInterface.pack();
                UserModifyInscInterface.setSize(700, 400);
                UserModifyInscInterface.setIconImage(new ImageIcon("src/main/resources/img.jpg").getImage());
                UserModifyInscInterface.setLocationRelativeTo(null);
                UserModifyInscInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                UserModifyInscInterface.setVisible(true);
            }
        });

        btnDeleteInscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insert = (JFrame) SwingUtilities.getWindowAncestor(btnDeleteInscription);
                insert.dispose();
                JFrame UserDeleteInterface = new JFrame("Modificar Inscripción");
                UserDeleteInterface.setTitle("Modificar Inscripción");
//              UserMenuInterface.setResizable(false);
                UserDeleteInterface.setContentPane(new UserDeleteInterface().getjMainPanel());
                UserDeleteInterface.pack();
                UserDeleteInterface.setSize(500, 400);
                UserDeleteInterface.setIconImage(new ImageIcon("src/main/resources/img.jpg").getImage());
                UserDeleteInterface.setLocationRelativeTo(null);
                UserDeleteInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                UserDeleteInterface.setVisible(true);
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insert = (JFrame) SwingUtilities.getWindowAncestor(btnSalir);
                insert.dispose();
                System.exit(0); // Finaliza la aplicación
            }
        });
    }

    public JPanel getjMainPanel() {
        return jMainPanel;
    }
}
