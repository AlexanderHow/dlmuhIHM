package fr.polytech.ihm.Model;

public enum EnumLocation {
    E130("Est","Salle 130"),
    E131("Est","Salle 131"),
    E132("Est","Salle 132"),
    E133("Est","Salle 133"),
    E134("Est","Salle 134"),
    E135("Est","Salle 135"),
    E136("Est","Salle 136"),
    E137("Est","Salle 137"),
    E138("Est","Salle 138"),
    E139("Est","Salle 139"),
    E140("Est","130"),
    E201("Est","130"),
    E202("Est","130"),
    E203("Est","130"),
    E204("Est","130"),
    E205("Est","130"),
    E206("Est","130"),
    E207("Est","130"),
    E208("Est","130"),

    O130("Ouest","130"),
    O131("Ouest","130"),
    O132("Ouest","130"),
    O133("Ouest","130"),
    O134("Ouest","130"),
    O135("Ouest","130"),
    O136("Ouest","130"),
    O137("Ouest","130"),
    O138("Ouest","130"),
    O139("Ouest","130"),
    O140("Ouest","130"),
    O201("Ouest","130"),
    O202("Ouest","130"),
    O203("Ouest","130"),
    O204("Ouest","130"),
    O205("Ouest","130"),
    O206("Ouest","130"),
    O207("Ouest","130"),
    O208("Ouest","130"),

    LEARNING("Nord","LearningCenter"),
    PARKINGN("Nord","Parking"),
    PARKINGS("Sud","Parking"),
    PARKINGO("Ouest","Parking"),
    PARKINGE("Est","Parking"),

    BATIMENTE("Est","Batiment"),
    BATIMENTO("Ouest","Batiment"),
    BATIMENTN("Nord","Batiment"),
    BATIMENTS("Sud","Batiment");

    private String orientation;
    private String location;

    EnumLocation(String orient, String loc){
        this.orientation=orient;
        this.location=loc;
    }

    @Override
    public String toString() {
        return this.location+" "+this.orientation;
    }
}
