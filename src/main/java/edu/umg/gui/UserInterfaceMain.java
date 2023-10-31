package edu.umg;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserInterfaceMain extends JFrame {
    private JTextField textUsername;
    private JButton btnLogin;
    private JLabel passwordLabel;
    private JLabel userLabel;
    private JPanel UserInterfaceMain;
    private JPanel UserMenuInterface;
    private JButton btnInscripcion;
    private JButton btnModifyInscripcion;
    private JButton btnSalir;
    private JPanel UserInscriptionInterface;
    private JPanel UserModifyInscInterface;
    private JLabel LonginText;
    private JPasswordField Fpassword;
    private JTextField FNam;
    private JButton atrásButtonI;
    private JButton agregarAlumnoButton;
    private JTextField FLastName;
    private JTextField FEmail;
    private JTextField FCurso;
    private JTextField FDate;
    private JComboBox comboBoxAlumnos;
    private JTextField textFieldModifyName;
    private JTextField textFieldModifyLastName;
    private JTextField textFieldModifyEmail;
    private JTextField textFieldCurso;
    private JButton actualizarDatosButton;
    private JButton atrásButtonM;
    private JPanel jMainPanel;
    private JButton btnDeleteInscription;
    private static final String USUARIO_DEMO = "1";
    private static final String CONTRASENIA_DEMO = "1";
    private void aplicarBorde(JComponent componente, Border borde) {componente.setBorder(borde);}


    public UserInterfaceMain(){

        Border bordeNegroGrueso = BorderFactory.createLineBorder(Color.BLACK, 2);
        aplicarBorde(jMainPanel, bordeNegroGrueso);
        UserInterfaceMain.setVisible(true);
        Font newFont = new Font("Comfortaa", Font.BOLD, 20);
        textUsername.setFont(newFont);
        Fpassword.setFont(newFont);

        btnLogin.setFocusPainted(false); // Sin borde de enfoque

        // Configurar el ActionListener para el botón de inicio de sesión
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLoginButtonClick();
            }
        });
}

// Botón de inicio de sesión
    private void handleLoginButtonClick() {
        String enteredUsername = textUsername.getText();
        char[] enteredPasswordChars = Fpassword.getPassword();
        String enteredPassword = new String(enteredPasswordChars);

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese su nombre de usuario y contraseña");
        }
        if (enteredUsername.equals(USUARIO_DEMO) && enteredPassword.equals(CONTRASENIA_DEMO)) {
            JOptionPane.showMessageDialog(null, "¡Inicio de sesión exitoso!");
            UserInterfaceMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
        }

        // Limpiar campos después de intentar iniciar sesión
        textUsername.setText("");
        Fpassword.setText("");
    }

    private void UserInterfaceMenu(){
        //CERRAR FORMULARIO ACTUAL Y ABRIR EL NUEVO
        JFrame insert = (JFrame) SwingUtilities.getWindowAncestor(btnLogin);
        insert.dispose();
        JFrame UserMenuInterface = new JFrame("Menu de Usuario");
        UserMenuInterface.setTitle("Menu de Usuario");
//      UserMenuInterface.setResizable(false);
        UserMenuInterface.setContentPane(new UserMenuInterface().getjMainPanel());
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
