package edu.umg.dao;
import edu.umg.entity.UsuariosEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UsuariosDAO {

    private final SessionFactory sessionFactory;

    public UsuariosDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void Create(UsuariosEntity usuarios) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usuarios);
        transaction.commit();
        session.close();
    }

    public UsuariosEntity findUserByUsername(String username) {
        Session session = sessionFactory.openSession();
        String hql = "FROM UsuariosEntity WHERE users = :username";
        Query<UsuariosEntity> query = session.createQuery(hql, UsuariosEntity.class);
        query.setParameter("username", username);
        UsuariosEntity user = query.uniqueResult();
        session.close();
        return user;
    }














//    private Session session;
//    public UsuariosDAO(){
//        session = edu.umg.Main.HibernateUtil.getSessionFactory().openSession();
//    }
//
//    public boolean validarCredenciales(String enteredUsername, String enteredPassword) {
//        String sql = "SELECT * FROM Usuarios WHERE users=? AND password=?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, enteredUsername);
//            statement.setString(2, enteredPassword);
//
//            try (ResultSet resultSet = statement.executeQuery()) {
//                return resultSet.next(); // Devuelve true si hay al menos un resultado, es decir, las credenciales son válidas
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Maneja la excepción de una forma adecuada, por ejemplo, registrándola
//            return false;
//        }
//    }












//    private final Connection connection;
//    private boolean miBooleano;
//    private boolean resultSet;

//    public UsuariosDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void addUser(UsuariosClass usuario)
//    {
//        String sql= "INSERT INTO Usuarios (users, password) VALUES (?, ?)";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, usuario.getUsers());
//            statement.setString(2, usuario.getPassword());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace(); //Maneja la excepción de una forma adecuada
//        }
//    }
//
//    public void validarCredenciales(boolean resultSet) {
//        this.resultSet = resultSet;
//    }
//
//    public void validarCredenciales(String enteredUsername, String enteredPassword) {
//        String sql = "SELECT * FROM Usuarios WHERE users=? AND password=?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, enteredUsername);
//            statement.setString(2, enteredPassword);
//
//            try (ResultSet resultSet = statement.executeQuery()) {
//                return resultSet.next(); // Devuelve true si hay al menos un resultado, es decir, las credenciales son válidas
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Maneja la excepción de una forma adecuada, por ejemplo, registrándola
//            return false;
//        }
//    }
//
//    public void addPassword(UsuariosClass usuario)
//    {
//        String sql= "UPDATE Usuarios SET password=? WHERE users=?";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, usuario.getPassword());
//            statement.setString(2, usuario.getUsers());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace(); //Maneja la excepción de una forma adecuada
//        }
//    }
//
//    public UsuariosClass getUser(String username) {
//        String sql = "SELECT * FROM Usuarios WHERE users=?";
//        UsuariosClass usuario = new UsuariosClass();
//
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, username);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    usuario.setUsers(resultSet.getString("users"));
//                    //usuario.setPassword(resultSet.getString("password"));
//                } else {
//                    // Manejar el caso en el que el usuario no existe, por ejemplo, lanzar una excepción o devolver null
//                    usuario = null;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Maneja la excepción de una forma adecuada, por ejemplo, registrándola
//        }
//
//        return usuario;
//    }
//
//    public void getUserPassword(UsuariosClass usuario) {
//        String sql = "SELECT * FROM Usuarios WHERE users=?";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, usuario.getUsers());
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                usuario.setPassword(resultSet.getString("password"));
//            } else {
//                // Manejar el caso en el que el usuario no existe
//                usuario.setPassword(null); // o establecer otro valor por defecto
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Maneja la excepción de una forma adecuada, por ejemplo, registrándola
//        }
//    }
//
//
//    public void deleteUser(UsuariosClass usuario)
//    {
//        String sql= "DELETE FROM Usuarios WHERE users=?";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, usuario.getUsers());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace(); //Maneja la excepción de una forma adecuada
//        }
//    }
//
//    public void deletePassword(UsuariosClass usuario) {
//        String sql = "DELETE FROM Usuarios WHERE users=?";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, usuario.getUsers());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace(); // Maneja la excepción de una forma adecuada
//        }
//    }

//    public boolean validarCredenciales(String username, String password) {
//        String sql = "SELECT * FROM Usuarios WHERE users=? AND password=?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, username);
//            statement.setString(2, password);
//
//            try (ResultSet resultSet = statement.executeQuery()) {
//                return resultSet.next(); // Devuelve true si hay al menos un resultado, es decir, las credenciales son válidas
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Maneja la excepción de una forma adecuada, por ejemplo, registrándola
//            return false;
//        }
//    }



//
//    public boolean verificarCredenciales(String users, String password) {
//        try (Session session = Main.HibernateUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            // Lógica para verificar credenciales usando Hibernate
//            String hql = "SELECT COUNT(*) FROM usuarios WHERE users = :nombreUsuario AND password = :contrasena";
//            Query<Long> query = session.createQuery(hql, Long.class);
//            query.setParameter("nombreUsuario", users);
//            query.setParameter("contrasena", password);
//            Long count = query.uniqueResult();
//
//            transaction.commit();
//
//            return count > 0;
//        } catch (Exception e) {
//            e.printStackTrace(); // Manejo adecuado de excepciones en una aplicación real
//            return false;
//        }
//      }
}


