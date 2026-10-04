import java.util.ArrayList;

public class Campament {
    private String nom;
    private String descripcio;
    private ArrayList<Integer> sortides = new ArrayList<>();
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

    public void setNumZona(int numZona) {
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

    @Override
    public String toString() {
        return "Campament [nom=" + nom + ", descripcio=" + descripcio + ", sortides=" + sortides + ", numZona="
                + numZona + ", isWard=" + isWard + ", teSmite=" + teSmite + "]";
    }
}