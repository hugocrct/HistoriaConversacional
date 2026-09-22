public class Monstre extends Personatges{
    
    String descripcio;
    int vida;
    int dany;
    int zona;

    public Monstre(String nom, int vida, int dany, int zona){
        super(nom);
        this.vida = vida;
        this.dany = dany;
        this.zona = zona;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getVida() {
        return vida;
    }

    public int getDany() {
        return dany;
    }

    public void setDany(int dany) {
        this.dany = dany;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }
}
