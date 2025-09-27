package com.franciscaolivares.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size (min = 3, max = 15, message = "El nombre de usuario debe tener entre 3 y 15 caracteres")
    @Column(unique=true) //esto hace que sea un unico nombre de usuario en la base de datos, que no se pueda repetir)
    private String nombreUsuario;

    @NotBlank(message = "Por favor proporciona la constraseña.")
    @Size(min = 8, message = "El password necesita tener al menos 8 catacteres.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña debe incluir al menos una letra mayúscula, una letra minúscula y un número")
    private String contrasenia;

    @Transient
    private String confirmarContrasenia;

    @Email (message = "Por favor proporciona un correo válido.")
    private String correo;
    
    @Size (min = 3, message = "El nombre debe tener al menos 3 caracteres")
    @Pattern(regexp="^[A-Za-z]+$", message="El nombre no puede contener números")
    private String nombre;

    @Size (min = 3, message = "El apellido debe contener al menos 3 caracteres")
    @Pattern(regexp="^[A-Za-z]+$", message="El apellido no puede contener números")
    private String apellido;

    @Past(message = "Tu fecha de nacimiento necesita ser una fecha en el pasado.")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_creacion", updatable=false)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_actualizacion")
    private Date fechaActualizacion;

    public Usuario(){
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getConfirmarContrasenia() {
        return confirmarContrasenia;
    }
    public void setConfirmarContrasenia(String confirmarContrasenia) {
        this.confirmarContrasenia = confirmarContrasenia;
    }
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = new Date();
}
}
