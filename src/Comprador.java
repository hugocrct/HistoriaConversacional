
import java.util.ArrayList;

public class Comprador extends Personatges {

    String nom;
    ArrayList<Objectes> tenda = new ArrayList<>();

    public Comprador(String nom, ArrayList<Objectes> tenda) {
        super(nom);
        this.tenda = tenda;
    }

    public ArrayList<Objectes> getTenda() {
        return tenda;
    }

    public void setTenda(ArrayList<Objectes> tenda) {
        this.tenda = tenda;
    }

}
