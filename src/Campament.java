
import java.util.ArrayList;
import java.util.Scanner;

public class Campament {

    Scanner e = new Scanner(System.in);
    private String nom;
    private String descripcio;
    private ArrayList<Integer> sortides = new ArrayList<>();
    // private necessitaObjecte = objecte;
    private int numZona;
    private boolean isWard;
    private boolean teSmite;

    public Campament(String nom, String descripcio, ArrayList<Integer> sortides, Integer numZona, boolean isWard, boolean teSmite) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.sortides = new ArrayList<>(sortides);
        this.numZona = numZona;
        this.isWard = isWard;
        this.teSmite = teSmite;
    }

    public void setNumZona(int numZona) {
        this.numZona = numZona;
    }

    public boolean isTeSmite() {
        return teSmite;
    }

    public void setTeSmite(boolean teSmite) {
        this.teSmite = teSmite;
    }

    public boolean isWard() {
        return isWard;
    }

    public void setWard(boolean isWard) {
        this.isWard = isWard;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setSortides(ArrayList<Integer> sortides) {
        this.sortides = sortides;
    }

    public void setNumZona(Integer numZona) {
        this.numZona = numZona;
    }

    public String getNom() {
        return nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public ArrayList<Integer> getSortides() {
        return sortides;
    }

    public int getNumZona() {
        return numZona;
    }

    public void setSmite() {
        int numero = (int) (Math.random() * 2);
        if (numero == 0) {
            main.campaments.get(4).setTeSmite(false);
        } else {
            main.campaments.get(1).setTeSmite(false);
        }
    }

    @Override
    public String toString() {
        return "Campament: " + nom + ", descripcio: " + descripcio + ", sortides: " + sortides + ", numZona: "
                + numZona + ", isWard: " + isWard + ", teSmite: " + teSmite;
    }

}
