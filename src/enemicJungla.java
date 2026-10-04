import java.util.ArrayList;

public class enemicJungla extends Personatges {

    static final int DANY_ENEMIC = 500;

    int comptadorMoviments;
    int salaActualEnemic;

    public enemicJungla(String nom, int comptadorMoviments, int salaActualEnemic) {
        super(nom);
        this.comptadorMoviments = comptadorMoviments;
        this.salaActualEnemic = salaActualEnemic;
    }

    public void setSalaActualEnemic(int salaActualEnemic) {
        this.salaActualEnemic = salaActualEnemic;
    }

    public int getSalaActualEnemic() {
        return this.salaActualEnemic;
    }

    /** Cada ronda, el 50% de vegades l'enemic es mou a una sala accessible a l'atzar. */
    public void moviments() {
        if (Math.random() < 0.5) {
            return;
        }
        ArrayList<Integer> sortides = main.campaments.get(salaActualEnemic).getSortides();
        salaActualEnemic = sortides.get((int) (Math.random() * sortides.size()));
        comptadorMoviments++;
    }

    /**
     * Si l'enemic i el jugador coincideixen en una sala perillosa (7 Drac, 8/9 rius,
     * 10 Baró), l'enemic ataca una sola vegada, o el jugador pot escapar amb el llampec.
     */
    public void enemicPega() {
        int sala = main.j.getSalaActual();
        if (sala < 7 || sala != salaActualEnemic) {
            return;
        }

        System.out.println("\n!!! T'has trobat amb l'enemic (" + nom + ") a " + main.campaments.get(sala).getNom() + " !!!");

        Objectes flash = main.j.getObjecte("Llampec");
        if (flash != null) {
            if (flash.getCooldown() == 0) {
                System.out.println("Tens el llampec! Vols utilitzar-lo per escapar?");
                System.out.println("1. Si.");
                System.out.println("2. No.");
                int escull;
                do {
                    escull = main.llegirInt();
                } while (escull != 1 && escull != 2);
                if (escull == 1) {
                    flash.setCooldown(30);
                    System.out.println("Fas servir el llampec i escapes sense rebre cap mal.");
                    main.j.moure();
                    return;
                }
            } else {
                System.out.println("Tens el llampec, però encara està en cooldown (" + flash.getCooldown() + " torns).");
            }
        } else {
            System.out.println("No tens el llampec.");
        }

        main.j.setVida(main.j.getVida() - DANY_ENEMIC);
        System.out.println("L'enemic t'ataca! Et queda " + Math.max(main.j.getVida(), 0) + " de vida.");
        if (main.j.getVida() <= 0) {
            main.morir();
        }
    }
}