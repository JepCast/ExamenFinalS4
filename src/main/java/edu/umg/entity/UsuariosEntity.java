package edu.umg.entity;

import java.util.Objects;

public class UsuariosEntity {
    private String users;
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
