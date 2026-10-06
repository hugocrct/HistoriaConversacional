
public class Objectes {

    String nom;
    String descripcio;
    String efecte;
    int tipus;
    int cooldown;
    private int preu;

    public Objectes(String nom, String descripcio, String efecte, int tipus, int cooldown, int preu) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.efecte = efecte;
        this.tipus = tipus;
        this.cooldown = cooldown;
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Objectes: " + nom + ", \ndescripcio=" + descripcio + ", \nefecte=" + efecte + ", \ntipus=" + tipus
                + ", \ncooldown=" + cooldown + ", \npreu=" + preu + "]";
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
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

    public static void canviarCooldowns() {
        for (int i = 0; i < main.obj.size(); i++) {
            if (main.obj.get(i).getCooldown() > 0) {
                main.obj.get(i).setCooldown(main.obj.get(i).getCooldown() - 1);
            }
        }
    }

}
