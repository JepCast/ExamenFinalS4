package edu.umg;

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

        btnInscripcion.setFocusPainted(false); // Sin borde de enfoque
        btnInscripcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //CERRAR FORMULARIO ACTUAL Y ABRIR EL NUEVO
                JFrame insert = (JFrame) SwingUtilities.getWindowAncestor(btnInscripcion);
                insert.dispose();
                JFrame UserInscriptionInterface = new JFrame("Menu de Usuario");
                UserInscriptionInterface.setTitle("Menu de Usuario");
//              UserMenuInterface.setResizable(false);
                UserInscriptionInterface.setContentPane(new UserInscriptionInterface().getjMainPanel());
                UserInscriptionInterface.pack();
                UserInscriptionInterface.setSize(400, 400);
                UserInscriptionInterface.setIconImage(new ImageIcon("src/main/resources/img.jpg").getImage());
                UserInscriptionInterface.setLocationRelativeTo(null);
                UserInscriptionInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                UserInscriptionInterface.setVisible(true);
            }
        });
    }
    public JPanel getjMainPanel() {
        return jMainPanel;
    }
}
