package com.example.myapplication;
public class User {
    public String name;
    public String profile; // URL de la photo de profil (optionnel)
    public String email;
    public String password;

    // Constructeur vide requis par Firebase
    public User() {}

    // Constructeur avec paramètres
    public User(String name, String profile, String email, String password) {
        this.name = name;
        this.profile = profile;
        this.email = email;
        this.password = password;
    }

    // (Optionnel) Getters et setters peuvent être ajoutés si nécessaire

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}