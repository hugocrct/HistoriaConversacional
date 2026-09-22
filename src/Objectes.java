public class Objectes {
    String nom;
    String descripcio;
    String efecte;
    int tipus;
    int cooldown;
   
    public Objectes(String nom, String descripcio, String efecte, int tipus, int cooldown) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.efecte = efecte;
        this.tipus = tipus;
        this.cooldown = cooldown;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDescripcio() {
        return descripcio;
    }
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    public String getEfecte() {
        return efecte;
    }
    public void setEfecte(String efecte) {
        this.efecte = efecte;
    }
    public int getTipus() {
        return tipus;
    }
    public void setTipus(int tipus) {
        this.tipus = tipus;
    }
    public int getCooldown() {
        return cooldown;
    }
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

}
