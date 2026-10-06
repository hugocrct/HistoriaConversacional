
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Monstre extends Personatges {

    String descripcio;
    int vida;
    int dany;
    int zona;
    int orSoltat;
    static Scanner e = main.e;

    public static ArrayList<Integer> vidaMaximaMonstres = new ArrayList<>();

    public Monstre(String nom, int vida, int dany, int zona, int orSoltat) {
        super(nom);
        this.vida = vida;
        this.dany = dany;
        this.zona = zona;
        this.orSoltat = orSoltat;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getOrSoltat() {
        return orSoltat;
    }

    public void setOrSoltat(int orSoltat) {
        this.orSoltat = orSoltat;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getNom() {
        return nom;
    }

    public int getVida() {
        return vida;
    }

    public int getDany() {
        return dany;
    }

    public void setDany(int dany) {
        this.dany = dany;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    // Relació sala -> posició del monstre a la llista de monstres.
    // Sala 0 = Gromp, 1 = Blue, 2 = Llops, 3 = Picutxins, 4 = Red, 5 = Krugs, 7 =
    // Drac, 10 = Baró
    private static final Map<Integer, Integer> POSICIO_MONSTRE_PER_SALA = Map.of(
            0, 0,
            1, 1,
            2, 2,
            3, 3,
            4, 4,
            5, 5,
            7, 6,
            10, 7);

    private static final String NOM_OBJECTE_AIXAFAMENT = "Aixafament";

    public static Jugador pegarMonstre(Jugador jugador, ArrayList<Monstre> llistaMonstres) {
        Integer posicioMonstre = POSICIO_MONSTRE_PER_SALA.get(jugador.getSalaActual());

        // Si en aquesta sala no hi ha monstre, no hi ha baralla
        if (posicioMonstre == null) {
            return jugador;
        }

        Monstre monstreRival = llistaMonstres.get(posicioMonstre);
        if (monstreRival.getVida() <= 0) {
            System.out.println("Aquest monstre ja l'has matat, torna més tard.");
            return jugador;
        }
        System.out.println("Has decidit lluitar amb el/els " + monstreRival.getNom());

        baralla(jugador, monstreRival);
        return jugador;
    }

    private static void baralla(Jugador jugador, Monstre monstreRival) {
        int vidaRestantMonstre = monstreRival.getVida();

        System.out.println("Acabes de començar la batalla amb el/els " + monstreRival.getNom() + " !");

        while (vidaRestantMonstre > 0 && jugador.getVida() > 0) {

            // Si té l'objecte, no està en cooldown i decideix usar-lo, fa 900 de dany al monstre
            if (jugadorTeObjecte(jugador, NOM_OBJECTE_AIXAFAMENT) && main.obj.get(7).getCooldown() == 0 && preguntarSiUsarAixafament()) {
                vidaRestantMonstre = vidaRestantMonstre - 900;
                main.obj.get(7).setCooldown(10);
                System.out.println("L'aixafament fa 900 de dany!");
                if (vidaRestantMonstre <= 0) {
                    break;
                }
            }

            // Torn del jugador
            System.out.println("Comences tu atacant!");
            vidaRestantMonstre -= jugador.getForca();
            System.out.println("El monstre s'ha quedat a: " + Math.max(vidaRestantMonstre, 0));

            // Si el monstre ja ha mort, no contraataca
            if (vidaRestantMonstre <= 0) {
                break;
            }

            // Torn del monstre
            System.out.println("Ara ataca el monstre!");
            jugador.setVida(jugador.getVida() - monstreRival.getDany());
            System.out.println("T'has quedat a " + Math.max(jugador.getVida(), 0) + " !");
        }

        if (jugador.getVida() <= 0) {
            main.setFi(true);
        } else {
            System.out.println("Has derrotat al monstre!!!");
            jugador.setOr(jugador.getOr() + monstreRival.getOrSoltat());
            monstreRival.setVida(0);

            if (main.campaments.get(monstreRival.getZona()).isTeSmite() == true) {
                System.out.println("Has aconseguit el smite!!!");
                main.inventari.add(main.obj.get(7));
                main.campaments.get(monstreRival.getZona()).setTeSmite(false);
            }
            if (monstreRival.getZona() == 7 && main.j.getSalaActual() == 7 && !jugadorTeObjecte(jugador, "Llampec")) {
                main.j.inventari.add(main.obj.get(6));
                System.out.println("Has aconseguit el flash!!!");
            }
            if (monstreRival.getZona() == 10) {
                System.out.println("HAS DERROTAT AL BARÓ!!! HAS GUANYAT!!!");
                main.fi = true;
            }
        }
    }

    private static boolean jugadorTeObjecte(Jugador jugador, String nomObjecte) {
        for (Objectes objecte : jugador.getInventari()) {
            if (objecte.getNom().equals(nomObjecte)) {
                return true;
            }
        }
        return false;
    }

    private static boolean preguntarSiUsarAixafament() {
        int opcioEscollida = 0;

        System.out.println("Vols usar l'aixafament?");
        System.out.println("    1) Sí");
        System.out.println("    2) No");

        // Repeteix fins que l'usuari escrigui 1 o 2 (evita que "a" peti el programa)
        while (opcioEscollida != 1 && opcioEscollida != 2) {
            if (e.hasNextInt()) {
                opcioEscollida = e.nextInt();
            } else {
                e.next(); // descarta el que no és un número
            }
            if (opcioEscollida != 1 && opcioEscollida != 2) {
                System.out.println("Opció no vàlida, escriu 1 o 2.");
            }
        }

        return opcioEscollida == 1;
    }

    public static void resetEnemic() {
        for (int i = 0; i < main.monstres.size(); i++) {
            if (main.monstres.get(i).getVida() == 0) {
                main.monstres.get(i).setVida(vidaMaximaMonstres.get(i));
            }
        }
    }

    public static void creacioVides() {
        vidaMaximaMonstres.add(2050);
        vidaMaximaMonstres.add(2300);
        vidaMaximaMonstres.add(1200);
        vidaMaximaMonstres.add(1100);
        vidaMaximaMonstres.add(2300);
        vidaMaximaMonstres.add(1050);
        vidaMaximaMonstres.add(5000);
        vidaMaximaMonstres.add(12600);
    }
}
