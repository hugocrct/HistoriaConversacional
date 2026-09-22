import java.util.ArrayList;
import java.util.Scanner;

public class Campament {
    Scanner e = new Scanner(System.in);
    private String nom;
    private String descripcio;
    private ArrayList<Integer> sortides = new ArrayList<>();
    // private necessitaObjecte = objecte;
    private int numZona;
    public Campament(String nom, String descrpcio, ArrayList sortides, Integer numZona){
        this.nom = nom;
        this.descripcio = descripcio;
        this.sortides = sortides;
        this.numZona=numZona;
    }
    public void setNom (String nom){
        this.nom = nom;
    }
    public void setDescripcio (String descripcio){
        this.descripcio = descripcio;
    }
    public void setSortides (ArrayList<Integer> sortides){
        this.sortides = sortides;
    }
    public void setNumZona (Integer numZona){
        this.numZona = numZona;
    }
    public String getNom(){
        return nom;
    }
    public String getDescripcio(){
        return descripcio;
    }
    public ArrayList<Integer> getSortides(){
        return sortides;
    }
    public int getNumZona(){
        return numZona;
    }
}
