package fr.polytech.ihm.Model;

public enum EnumCategory {
    UTILITAIRE("Utilitaire"),
    RESSOURCE("Ressource"),
    TECHNIQUE("Technique"),
    SERVICE("Service"),
    MAINTENANCE("Maintenance");

    private String libelle;

    EnumCategory(String lib) {
        this.libelle = lib;
    }

    public String getLibelle() {
        return libelle;
    }
}
