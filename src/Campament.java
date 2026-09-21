import java.util.ArrayList;
import java.util.Scanner;

public class Campament {
    Scanner e = new Scanner(System.in);
    private String nom;
    private String descripcio;
    private ArrayList<Integer> sortides;
    // private necessitaObjecte = objecte;
    private int numZona;
    public Campament(String nom, String descrpcio, ArrayList sortides, Integer numZona){
        this.nom = nom;
        this.descripcio = descrpcio;
        this.sortides = sortides;
        this.numZona=numZona;
    }
    
}
