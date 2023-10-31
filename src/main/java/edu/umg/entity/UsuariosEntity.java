package edu.umg.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "usuarios", schema = "public", catalog = "postgres")
public class UsuariosEntity {

    @Basic
    @Column(name = "users")
    private String users;
    @Basic
    @Column(name = "password")
    private String password;

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosEntity that = (UsuariosEntity) o;
        return Objects.equals(users, that.users) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users, password);
    }
}
