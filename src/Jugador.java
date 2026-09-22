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

    public void moure(){

        //for(int i = 0; 0 < campaments.get(getSalaActual).getSortides().size(); i++){
        //int numSala = (campaments.get(getSalaActual()).sortides(i));
        //for(int j = 0; j < campaments.size(); j++){
           // if(numSala == campaments.get(getSalaActual))
        //}
        //}
        
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
