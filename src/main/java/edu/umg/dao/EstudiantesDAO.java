package edu.umg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.umg.entity.EstudiantesEntity;

public class EstudiantesDAO {

    private Connection connection;

    public EstudiantesDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(EstudiantesEntity estudiante) {
        try {
            String query = "INSERT INTO Estudiantes (nombre, apellido, email) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, estudiante.getNombre());
            statement.setString(2, estudiante.getApellido());
            statement.setString(3, estudiante.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(EstudiantesEntity estudiante) {
        try {
            String query = "UPDATE Estudiantes SET nombre=?, apellido=?, email=? WHERE id_estudiante=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, estudiante.getNombre());
            statement.setString(2, estudiante.getApellido());
            statement.setString(3, estudiante.getEmail());
            statement.setInt(4, estudiante.getIdEstudiante());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idEstudiante) {
        try {
            String query = "DELETE FROM Estudiantes WHERE id_estudiante=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idEstudiante);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EstudiantesEntity getEstudianteById(int idEstudiante) {
        EstudiantesEntity estudiante = null;
        try {
            String query = "SELECT * FROM Estudiantes WHERE id_estudiante=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idEstudiante);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                estudiante = new EstudiantesEntity();
                estudiante.setIdEstudiante(resultSet.getInt("id_estudiante"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setApellido(resultSet.getString("apellido"));
                estudiante.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiante;
    }

    public List<EstudiantesEntity> getAllEstudiantes() {
        List<EstudiantesEntity> estudiantes = new ArrayList<>();
        try {
            String query = "SELECT * FROM Estudiantes";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EstudiantesEntity estudiante = new EstudiantesEntity();
                estudiante.setIdEstudiante(resultSet.getInt("id_estudiante"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setApellido(resultSet.getString("apellido"));
                estudiante.setEmail(resultSet.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
}
