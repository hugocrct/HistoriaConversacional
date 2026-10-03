import java.util.ArrayList;
import java.util.Scanner;

public class Jugador extends Personatges{



    Scanner e = new Scanner(System.in);
    int forca;
    int vida;
    String nom;
    int salaActual;
    int oro;
    int ward;
    Campament c;
    Objectes o;
    ArrayList<Objectes> inventari;

    public Jugador(String nom, int forca, int vida, int salaActual, int oro, ArrayList<Objectes> inventari, int ward){ //ArrayList<Objecte> inventari
        super(nom);
        this.forca = forca;
        this.vida = vida;
        this.salaActual = 0;
        this.oro = oro;
        this.ward = ward;
        inventari = new ArrayList<>();
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
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
    
    public void moure(){
        int fet = 0;
        
        do { 
            System.out.print("a quina sala et vols moure: ");
            int num = e.nextInt();  
           System.out.println();
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

    public void colocarWard(){
        if(getWard() > 0 && getSalaActual() == 0){
            main.campaments.get(9).setWard(true);
        }
        else if(getWard() > 0  && getSalaActual() == 5){
            main.campaments.get(8).setWard(true);
        }
        else if(getWard() == 0){
            System.out.println("No tienes wards");
        }
        else{
            System.out.println("No ets en un campament a prop del riu.");
        }
    }

    public void agafarObjectes(){
        if(getSalaActual() == 6){
            main.obj.toString();
            System.out.println("");
            System.out.print("Que objecte vols comprar? (Has de dir el nom del objecte, la primera paraula, tot minuscules, sense accents):");
            String compra = e.nextLine();

           
            
            if(compra.equals("cor")){
                if(getOro() >= main.obj.get(0).getPrecio()){
                    System.out.println("Has comprat el cor d'acer!!!");
                    inventari.add(main.obj.get(0));
                    int oroActual = getOro() - main.obj.get(0).getPrecio();
                    setOro(oroActual);
                    setVida(getVida()+1500);
                }
                else{
                    System.out.println("No tens el or suficient per comprar el objecte");
                }
                
            }
            else if(compra.equals("basto")){
                    if(getOro() >= main.obj.get(1).getPrecio()){
                        System.out.println("Has comprat el bastó del buit!!!");
                        inventari.add(main.obj.get(1));
                        int oroActual = getOro() - main.obj.get(1).getPrecio();
                        setOro(oroActual);
                        setForca(getForca()+400);
                        
                    }
                    else{
                    System.out.println("No tens el or suficient per comprar el objecte");
                    }
                }
                else if(compra.equals("fil")){

                if(getOro() >= main.obj.get(2).getPrecio()){
                    System.out.println("Has comprat el fil!!!");
                    inventari.add(main.obj.get(2));
                    int oroActual = getOro() - main.obj.get(2).getPrecio();
                    setOro(oroActual);
                    setForca(getForca()+300);
                }
                else{
                    System.out.println("No tens el or suficient per comprar el objecte");
                }
            }
            else if(compra.equals("rellotge")){
                if(getOro() >= main.obj.get(3).getPrecio()){
                    System.out.println("Has comprat el rellotge!!!");
                    inventari.add(main.obj.get(3));
                    int oroActual = getOro() - main.obj.get(3).getPrecio();
                    setOro(oroActual);
                    setForca(getForca()+250);
                }
                else{
                    System.out.println("No tens el or suficient per comprar el objecte");
                }
            }
            else if(compra.equals("oposicio")){
                if(getOro() >= main.obj.get(4).getPrecio()){
                    System.out.println("Has comprat l'oposició!!!");
                    inventari.add(main.obj.get(4));
                    int oroActual = getOro() - main.obj.get(4).getPrecio();
                    setOro(oroActual);
                    setVida(getVida()+1000);
                }
                else{
                    System.out.println("No tens el or suficient per comprar el objecte");
                }
            }
            else if(compra.equals("soles")){
                if(getOro() >= main.obj.get(5).getPrecio()){
                    System.out.println("Has comprat els soles!!!");
                    inventari.add(main.obj.get(5));
                    int oroActual = getOro() - main.obj.get(5).getPrecio();
                    setOro(oroActual);
                    setForca(getForca()+250);
                    setVida(getVida()+750);
                }
                else{
                    System.out.println("No tens el or suficient per comprar el objecte");
                }
            }
        }
        else{
            System.out.println("Has de anar a la base per comprar objectes");
        }
    }
}
