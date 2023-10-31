package edu.umg.entity;

import java.sql.Date;
import java.util.Objects;

public class InscripcionesEntity {
    private int idInscripcion;
    private Integer idEstudiante;
    private Integer idCurso;
    private Date fechaInscripcion;
    private EstudiantesEntity estudiantesByIdEstudiante;
    private CursosEntity cursosByIdCurso;

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscripcionesEntity that = (InscripcionesEntity) o;
        return idInscripcion == that.idInscripcion && Objects.equals(idEstudiante, that.idEstudiante) && Objects.equals(idCurso, that.idCurso) && Objects.equals(fechaInscripcion, that.fechaInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInscripcion, idEstudiante, idCurso, fechaInscripcion);
    }

    public EstudiantesEntity getEstudiantesByIdEstudiante() {
        return estudiantesByIdEstudiante;
    }

    public void setEstudiantesByIdEstudiante(EstudiantesEntity estudiantesByIdEstudiante) {
        this.estudiantesByIdEstudiante = estudiantesByIdEstudiante;
    }

    public CursosEntity getCursosByIdCurso() {
        return cursosByIdCurso;
    }

    public void setCursosByIdCurso(CursosEntity cursosByIdCurso) {
        this.cursosByIdCurso = cursosByIdCurso;
    }
}
