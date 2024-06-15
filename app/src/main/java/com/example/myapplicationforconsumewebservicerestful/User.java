package com.example.myapplicationforconsumewebservicerestful;

public class User {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String genero;
    private String fechaNacimiento;
    private int edad;
    private String emailVerifiedAt;
    private String createdAt;
    private String updatedAt;

    // Constructor, getters y setters
    public User(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String email, String genero, String fechaNacimiento, int edad, String emailVerifiedAt, String createdAt, String updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.emailVerifiedAt = emailVerifiedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public String getEmail() { return email; }
    public String getGenero() { return genero; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public int getEdad() { return edad; }
    public String getEmailVerifiedAt() { return emailVerifiedAt; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
