package com.franciscaolivares.modelos;

import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import java.util.Date;
import jakarta.persistence.Column;


@Entity
@Table(name="canciones")

public class Cancion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size (min=5, message="Por favor proporciona el título de la canción")
    private String titulo;

    @ManyToOne
    @JoinColumn(name="id_artista")
    private Artista artista; // Relación Many-to-One con objeto artista, importante el nombre es el mismo nombre que pusimos en mappedBy en Artista.java

    @Size (min=3, message="Por favor proporciona el álbum de la canción")
    private String album;

    @Size (min=3, message="Por favor proporciona el género de la canción")
    private String genero;

    @Size (min=3, message="Por favor proporciona el idioma de la canción")
    private String idioma;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_creacion")
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_actualizacion")
    private Date fechaActualizacion;

    public Cancion() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }
// Cambiar el objeto, ya no es un string sino un objeto tipo artista (cuando hacemos la relacion Many to One)
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
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
        this.fechaActualizacion = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = new Date();
    }


}
