public class Objectes {
    String nom;
    String descripcio;
    String efecte;
    int tipus; // 0 = passiu, 1 = actiu, 2 = ward
    int cooldown;
    private int precio;
    private int bonusVida = 0;
    private int bonusForca = 0;

    public Objectes(String nom, String descripcio, String efecte, int tipus, int cooldown, int precio) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.efecte = efecte;
        this.tipus = tipus;
        this.cooldown = cooldown;
        this.precio = precio;
    }

    /** Assigna els bonus de vida i força que dona l'objecte en comprar-lo. */
    public Objectes setBonus(int bonusVida, int bonusForca) {
        this.bonusVida = bonusVida;
        this.bonusForca = bonusForca;
        return this;
    }

    public int getBonusVida() {
        return bonusVida;
    }

    public int getBonusForca() {
        return bonusForca;
    }

    @Override
    public String toString() {
        return "Objectes [nom=" + nom + ", \ndescripcio=" + descripcio + ", \nefecte=" + efecte + ", \ntipus=" + tipus
                + ", \ncooldown=" + cooldown + ", \nprecio=" + precio + "]";
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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

    /** Baixa 1 torn el cooldown de tots els objectes que n'estiguin tenint. */
    public static void cambiarCooldowns() {
        for (Objectes o : main.obj) {
            if (o.getCooldown() > 0) {
                o.setCooldown(o.getCooldown() - 1);
            }
        }
    }
}