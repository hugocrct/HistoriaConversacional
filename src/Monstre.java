import java.util.ArrayList;

public class Monstre extends Personatges {

    String descripcio;
    int vida;
    int vidaMax;
    int dany;
    int zona;
    int oroSuelto;

    private static final String NOMBRE_OBJETO_SMITE = "Aixafament";
    private static final String NOMBRE_OBJETO_FLASH = "Llampec";
    private static final int DANY_SMITE = 900;
    private static final int COOLDOWN_SMITE = 10;

    public Monstre(String nom, int vida, int dany, int zona, int oroSuelto) {
        super(nom);
        this.vida = vida;
        this.vidaMax = vida;
        this.dany = dany;
        this.zona = zona;
        this.oroSuelto = oroSuelto;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getOroSuelto() {
        return oroSuelto;
    }

    public void setOroSuelto(int oroSuelto) {
        this.oroSuelto = oroSuelto;
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

    public int getVidaMax() {
        return vidaMax;
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

    /** Busca el monstre de la sala on és el jugador (pel camp zona) i lluita contra ell. */
    public static Jugador pegarMonstro(Jugador jugador, ArrayList<Monstre> listaMonstruos) {
        Monstre monstruoRival = null;
        for (Monstre m : listaMonstruos) {
            if (m.getZona() == jugador.getSalaActual()) {
                monstruoRival = m;
            }
        }

        // Si en aquesta sala no hi ha monstre, no hi ha baralla
        if (monstruoRival == null) {
            System.out.println("Aquí no hi ha cap monstre.");
            return jugador;
        }
        if (monstruoRival.getVida() <= 0) {
            System.out.println("El/els " + monstruoRival.getNom() + " ja els has matat. Torna més tard, ja reapareixeran.");
            return jugador;
        }

        System.out.println("Has decidit lluitar amb el/els " + monstruoRival.getNom());
        pelea(jugador, monstruoRival);
        return jugador;
    }

    private static void pelea(Jugador jugador, Monstre monstruoRival) {
        System.out.println("Acabas de començar la batalla amb el/els " + monstruoRival.getNom() + " !");

        // Smite: 900 de dany al monstre, una vegada per baralla, amb cooldown
        Objectes smite = jugador.getObjecte(NOMBRE_OBJETO_SMITE);
        if (smite != null) {
            if (smite.getCooldown() == 0) {
                if (preguntarSiUsarAplastamiento()) {
                    monstruoRival.setVida(monstruoRival.getVida() - DANY_SMITE);
                    smite.setCooldown(COOLDOWN_SMITE);
                    System.out.println("Fas servir l'aixafament! El monstre rep " + DANY_SMITE + " de dany.");
                }
            } else {
                System.out.println("L'aixafament està en cooldown (" + smite.getCooldown() + " torns).");
            }
        }

        while (monstruoRival.getVida() > 0 && jugador.getVida() > 0) {
            // Torn del jugador
            System.out.println("Comences tu atacant!");
            monstruoRival.setVida(monstruoRival.getVida() - jugador.getForca());
            System.out.println("El monstre s'ha quedat a: " + Math.max(monstruoRival.getVida(), 0));

            // Si el monstre ja ha mort, no contraataca
            if (monstruoRival.getVida() <= 0) {
                break;
            }

            // Torn del monstre
            System.out.println("Ahora ataca el monstre!");
            jugador.setVida(jugador.getVida() - monstruoRival.getDany());
            System.out.println("T'has quedat a " + Math.max(jugador.getVida(), 0) + " !");
        }

        if (jugador.getVida() <= 0) {
            main.morir();
            return;
        }

        monstruoRival.setVida(0);
        System.out.println("Has derrotat al monstre!!!");
        jugador.setOro(jugador.getOro() + monstruoRival.getOroSuelto());
        System.out.println("Guanyes " + monstruoRival.getOroSuelto() + " d'or. Or total: " + jugador.getOro());

        // Smite: només el campament que el té (Blue o Red) i només una vegada
        Campament campament = main.campaments.get(monstruoRival.getZona());
        if (campament.isTeSmite()) {
            campament.setTeSmite(false);
            Objectes obj = main.buscarObjecte(NOMBRE_OBJETO_SMITE);
            if (obj != null && !jugador.teObjecte(NOMBRE_OBJETO_SMITE)) {
                jugador.getInventari().add(obj);
                System.out.println("Has aconseguit el smite!!!");
            }
        }

        // Flash: es guanya en matar el Drac
        if (monstruoRival.getZona() == 7 && !jugador.teObjecte(NOMBRE_OBJETO_FLASH)) {
            Objectes obj = main.buscarObjecte(NOMBRE_OBJETO_FLASH);
            if (obj != null) {
                jugador.getInventari().add(obj);
                System.out.println("Has conseguit el flash!!!");
            }
        }

        // Matar el Baró = guanyar el joc
        if (monstruoRival.getZona() == 10) {
            main.guanyar();
        }
    }

    private static boolean preguntarSiUsarAplastamiento() {
        System.out.println("Vols usar l'aplastament??");
        System.out.println("    1) Si");
        System.out.println("    2) No");
        int opcionElegida;
        do {
            opcionElegida = main.llegirInt();
            if (opcionElegida != 1 && opcionElegida != 2) {
                System.out.println("Opció no vàlida, escriu 1 o 2.");
            }
        } while (opcionElegida != 1 && opcionElegida != 2);
        return opcionElegida == 1;
    }

    /** Fa reaparèixer (vida màxima) tots els monstres que estaven morts. */
    public static boolean resetEnemic() {
        boolean algun = false;
        for (Monstre m : main.monstres) {
            if (m.getVida() <= 0) {
                m.setVida(m.getVidaMax());
                algun = true;
            }
        }
        return algun;
    }
}