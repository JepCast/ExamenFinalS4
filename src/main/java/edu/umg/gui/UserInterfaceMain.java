package edu.umg.gui;

import edu.umg.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class UserInterfaceMain extends JFrame {
    private JTextField textUsername;
    private JButton btnLogin;
    private JLabel passwordLabel;
    private JLabel userLabel;
    private JPanel UserInterfaceMain;
    private JLabel LonginText;
    private JPasswordField Fpassword;
    private JPanel jMainPanel;

    private void aplicarBorde(JComponent componente, Border borde) {componente.setBorder(borde);}


    public UserInterfaceMain(){

        Border bordeNegroGrueso = BorderFactory.createLineBorder(Color.BLACK, 2);
        aplicarBorde(jMainPanel, bordeNegroGrueso);
        UserInterfaceMain.setVisible(true);
        btnLogin.setFocusPainted(false); // Sin borde de enfoque

        // Configurar el ActionListener para el botón de inicio de sesión
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLoginButtonClick();

                // Obtener el nombre de usuario y la contraseña
//        String username = txtUsername.getText();
//        char[] passwordChars = txtPassword.getPassword();
//        String password = new String(passwordChars);
//
//        // Validar en la base de datos
//        if (validarCredenciales(username, password)) {
//            JOptionPane.showMessageDialog(null, "¡Inicio de sesión exitoso!");
//            // Abrir la ventana principal o realizar otras acciones necesarias
//        } else {
//            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
//        }
//
//        // Limpiar los campos después de intentar iniciar sesión
//        txtUsername.setText("");
//        txtPassword.setText("");
//    }
//});
            }
        });
}

// Botón de inicio de sesión
    private boolean handleLoginButtonClick() {
        String enteredUsername = textUsername.getText();
        char[] enteredPasswordChars = Fpassword.getPassword();
        String enteredPassword = new String(enteredPasswordChars);


        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBInscipcion", "postgres", "PostgK._nm7"))
        {
            String sql = "SELECT * FROM usuarios WHERE users=? AND password=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, enteredUsername);
                statement.setString(2, enteredPassword);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
                        UserInterfaceMenu();
                        // Aquí puedes abrir la nueva ventana o realizar otras acciones después del inicio de sesión
                    } else {
                        JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Maneja la excepción de una forma adecuada
        }
        return false;
    }

    private void UserInterfaceMenu(){
        //CERRAR FORMULARIO ACTUAL Y ABRIR EL NUEVO
        JFrame insert = (JFrame) SwingUtilities.getWindowAncestor(btnLogin);
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

    public JPanel getjMainPanel() {
        return jMainPanel;
    }
}
