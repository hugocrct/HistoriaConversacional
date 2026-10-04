public class Objectes {
    String nom;
    String descripcio;
    String efecte;
    int tipus;
    int cooldown;
    private int precio;

   
    public Objectes(String nom, String descripcio, String efecte, int tipus, int cooldown, int precio) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.efecte = efecte;
        this.tipus = tipus;
        this.cooldown = cooldown;
        this.precio = precio;
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

    public void cambiarCooldowns(){
        for(int i = 0; i < main.obj.size(); i++){
            if(main.obj.get(i).getCooldown() > 0){
                main.obj.get(i).setCooldown(getCooldown() -1);
            }
        }
    }


}
