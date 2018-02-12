package fr.polytech.ihm.Model;

public enum EnumLocation {
    E130("Est", "Salle 130"),
    E131("Est", "Salle 131"),
    E132("Est", "Salle 132"),
    E133("Est", "Salle 133"),
    E134("Est", "Salle 134"),
    E135("Est", "Salle 135"),
    E136("Est", "Salle 136"),
    E137("Est", "Salle 137"),
    E138("Est", "Salle 138"),
    E139("Est", "Salle 139"),
    E140("Est", "Salle 140"),
    E141("Est", "Salle 141"),
    E142("Est", "Salle 142"),
    E201("Est", "Salle 201"),
    E202("Est", "Salle 202"),
    E203("Est", "Salle 203"),
    E204("Est", "Salle 204"),
    E205("Est", "Salle 205"),
    E206("Est", "Salle 206"),
    E207("Est", "Salle 207"),
    E208("Est", "Salle 208"),

    O130("Ouest", "Salle 130"),
    O131("Ouest", "Salle 131"),
    O132("Ouest", "Salle 132"),
    O133("Ouest", "Salle 133"),
    O134("Ouest", "Salle 134"),
    O135("Ouest", "Salle 135"),
    O136("Ouest", "Salle 136"),
    O137("Ouest", "Salle 137"),
    O138("Ouest", "Salle 138"),
    O139("Ouest", "Salle 139"),
    O140("Ouest", "Salle 140"),
    O201("Ouest", "Salle 201"),
    O202("Ouest", "Salle 202"),
    O203("Ouest", "Salle 203"),
    O204("Ouest", "Salle 204"),
    O205("Ouest", "Salle 205"),
    O206("Ouest", "Salle 206"),
    O207("Ouest", "Salle 207"),
    O208("Ouest", "Salle 208"),

    LEARNING("Nord", "LearningCenter"),
    AMPHIFORUM("Ouest", "Amphi Forum"),
    PARKINGN("Nord", "Parking"),
    PARKINGS("Sud", "Parking"),
    PARKINGO("Ouest", "Parking"),
    PARKINGE("Est", "Parking"),

    BATIMENTE("Est", "Batiment"),
    BATIMENTO("Ouest", "Batiment"),
    BATIMENTN("Nord", "Batiment"),
    BATIMENTS("Sud", "Batiment"),

    WCE1H("Est", "Toilettes hommes, étage 1"),
    WCE1F("Est", "Toilettes femmes, étage 1"),
    WCE2H("Est", "Toilettes hommes, étage 2"),
    WCE2F("Est", "Toilettes femmes, étage 2"),
    WCO1H("Ouest", "Toilettes hommes, étage 1"),
    WCO1F("Ouest", "Toilettes femmes, étage 1"),
    WCO2H("Ouest", "Toilettes hommes, étage 2"),
    WCO2F("Ouest", "Toilettes femmes, étage 2");

    private String orientation;
    private String location;

    EnumLocation(String orient, String loc) {
        this.orientation = orient;
        this.location = loc;
    }

    @Override
    public String toString() {
        return this.location + " " + this.orientation;
    }
}
