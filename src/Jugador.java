import java.util.ArrayList;

public class Jugador extends Personatges{

    int forca;
    int vida;
    String nom;
    int salaActual;

    public Jugador(String nom, int forca, int vida, int salaActual ){ //ArrayList<Objecte> inventari
        super(nom);
        this.forca = forca;
        this.vida = vida;
        this.salaActual = 0;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void moure(int num){
        
        for(int i = 0; i <main.campaments.get(getSalaActual()).getSortides().size(); i++){
         if(num == main.campaments.get(getSalaActual()).getSortides().get(i)){
            setSalaActual(num);
         }
        }
        
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getVida(){
        return this.vida;
    }

    public void setSalaActual(int salaActual){
        this.salaActual = salaActual;
    }

    public int getSalaActual(){
        return this.salaActual;
    }
}
