import java.text.Normalizer;
import java.util.ArrayList;

public class Jugador extends Personatges {

    int forca;
    int vida;
    int vidaMax;
    int salaActual;
    int oro;
    int ward;
    ArrayList<Objectes> inventari;

    public Jugador(String nom, int forca, int vida, int salaActual, int oro, ArrayList<Objectes> inventari, int ward) {
        super(nom);
        this.forca = forca;
        this.vida = vida;
        this.vidaMax = vida;
        this.salaActual = salaActual;
        this.oro = oro;
        this.ward = ward;
        this.inventari = inventari;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return this.vida;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public void setSalaActual(int salaActual) {
        this.salaActual = salaActual;
    }

    public int getSalaActual() {
        return this.salaActual;
    }

    /** Retorna l'objecte de l'inventari amb aquest nom, o null si no el té. */
    public Objectes getObjecte(String nomObjecte) {
        for (Objectes o : inventari) {
            if (o.getNom().equals(nomObjecte)) {
                return o;
            }
        }
        return null;
    }

    public boolean teObjecte(String nomObjecte) {
        return getObjecte(nomObjecte) != null;
    }

    public void moure() {
        ArrayList<Integer> sortides = main.campaments.get(getSalaActual()).getSortides();
        System.out.println("Pots anar a:");
        for (int s : sortides) {
            System.out.println("  " + s + ") " + main.campaments.get(s).getNom());
        }
        while (true) {
            System.out.print("A quina sala et vols moure: ");
            int num = main.llegirInt();
            if (sortides.contains(num)) {
                arribar(num);
                return;
            }
            System.out.println("No pots anar-hi des d'aquí.");
        }
    }

    /** Col·loca el jugador a una sala (sense validar sortides) i aplica els efectes d'arribar-hi. */
    public void arribar(int sala) {
        setSalaActual(sala);
        Campament c = main.campaments.get(sala);
        System.out.println("\n== " + c.getNom() + " ==");
        System.out.println(c.getDescripcio());
        if (sala == 6) {
            setVida(getVidaMax());
            System.out.println("Descanses a la base i recuperes tota la vida (" + getVidaMax() + ").");
        }
    }

    /** Posa una ward a la riada propera. Retorna true si s'ha posat. */
    public boolean colocarWard() {
        int riu;
        if (getSalaActual() == 0) {
            riu = 9; // el Gromp mira cap a la riada de top
        } else if (getSalaActual() == 5) {
            riu = 8; // els Krugs miren cap a la riada de bot
        } else {
            System.out.println("No ets en un campament a prop del riu.");
            return false;
        }
        if (getWard() <= 0) {
            System.out.println("No tens wards. Compra'n a la base.");
            return false;
        }
        if (main.campaments.get(riu).isWard()) {
            System.out.println("Ja hi ha una ward a " + main.campaments.get(riu).getNom() + ".");
            return false;
        }
        setWard(getWard() - 1);
        main.campaments.get(riu).setWard(true);
        System.out.println("Has posat ward a " + main.campaments.get(riu).getNom() + ". Wards que et queden: " + getWard());
        return true;
    }

    public void agafarObjectes() {
        if (getSalaActual() != 6) {
            System.out.println("Has de anar a la base per comprar objectes");
            return;
        }

        ArrayList<Objectes> botiga = new ArrayList<>();
        for (Objectes o : main.obj) {
            if (o.getPrecio() > 0) {
                botiga.add(o);
            }
        }

        System.out.println("Tens " + getOro() + " d'or. Objectes a la venda:");
        for (int i = 0; i < botiga.size(); i++) {
            Objectes o = botiga.get(i);
            String estat = teObjecte(o.getNom()) && o.getTipus() != 2 ? "  [JA EL TENS]" : "";
            System.out.println("  " + (i + 1) + ") " + o.getNom() + " - " + o.getPrecio() + " d'or" + estat);
            System.out.println("       " + o.getEfecte());
        }
        System.out.println("  0) Sortir");
        System.out.print("Que vols comprar? (número, o la primera paraula del nom): ");
        String entrada = main.llegirLinia();

        if (entrada.isEmpty() || entrada.equals("0")) {
            return;
        }
        Objectes triat = trobarObjecte(botiga, entrada);
        if (triat == null) {
            System.out.println("No he trobat cap objecte amb aquest nom o número.");
            return;
        }
        comprar(triat);
    }

    private Objectes trobarObjecte(ArrayList<Objectes> botiga, String entrada) {
        try {
            int n = Integer.parseInt(entrada);
            if (n >= 1 && n <= botiga.size()) {
                return botiga.get(n - 1);
            }
            return null;
        } catch (NumberFormatException ex) {
            // no és un número: es busca pel nom
        }
        String buscat = normalitzar(entrada);
        for (Objectes o : botiga) {
            if (normalitzar(o.getNom()).startsWith(buscat)) {
                return o;
            }
        }
        return null;
    }

    private String normalitzar(String text) {
        String sense = Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        return sense.toLowerCase().trim();
    }

    private void comprar(Objectes o) {
        if (getOro() < o.getPrecio()) {
            System.out.println("No tens el or suficient per comprar el objecte");
            return;
        }
        if (o.getTipus() == 2) { // ward: es poden tenir moltes
            setOro(getOro() - o.getPrecio());
            setWard(getWard() + 1);
            System.out.println("Has comprat una ward! Wards: " + getWard());
            return;
        }
        if (teObjecte(o.getNom())) {
            System.out.println("Ja tens aquest objecte.");
            return;
        }
        setOro(getOro() - o.getPrecio());
        inventari.add(o);
        setForca(getForca() + o.getBonusForca());
        setVidaMax(getVidaMax() + o.getBonusVida());
        setVida(getVida() + o.getBonusVida());
        System.out.println("Has comprat " + o.getNom() + "!!! (+" + o.getBonusVida() + " vida, +" + o.getBonusForca() + " força)");
    }
}