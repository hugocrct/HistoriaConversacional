import java.util.ArrayList;
import java.util.Scanner;

public class Jugador extends Personatges{



    Scanner e = new Scanner(System.in);
    int forca;
    int vida;
    String nom;
    int salaActual;
    int oro;
    Campament c;
    Objectes o;
    ArrayList<Objectes> inventari;

    public Jugador(String nom, int forca, int vida, int salaActual, int oro, ArrayList<Objectes> inventari){ //ArrayList<Objecte> inventari
        super(nom);
        this.forca = forca;
        this.vida = vida;
        this.salaActual = 0;
        this.oro = oro;
        inventari = new ArrayList<>();
    }

    public ArrayList<Objectes> getInventari() {
        return inventari;
    }

    public void setInventari(ArrayList<Objectes> inventari) {
        this.inventari = inventari;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void moure(){
        int fet = 0;
        
        do {
           
            System.out.print("a quina sala et vols moure: ");
            int num = e.nextInt();  
           
            for(int i = 0; i <main.campaments.get(getSalaActual()).getSortides().size(); i++){
                if(num == main.campaments.get(getSalaActual()).getSortides().get(i)){
                    setSalaActual(num);
                    System.out.println(main.campaments.get(getSalaActual()).toString());
                    i = main.campaments.get(getSalaActual()).getSortides().size() + 1;
                    fet = 1;
                }
            }
        } while (fet == 0);
        
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    //public void getVidaActual()

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

    public String toString(){
        return("Vida: " + getVida() + "\nOro: " + getOro() + "\")
    }
}
