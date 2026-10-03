import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Monstre extends Personatges {

    String descripcio;
    int vida;
    int dany;
    int zona;
    int oroSuelto;
    static Scanner e = new Scanner(System.in);

    public ArrayList<Integer> vidaMaximaMonstres = new ArrayList<>();


    public Monstre(String nom, int vida, int dany, int zona, int oroSuelto) {
        super(nom);
        this.vida = vida;
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
    private static final Map<Integer, Integer> POSICION_MONSTRUO_POR_SALA = Map.of(
            0, 0,
            1, 1,
            2, 2,
            3, 3,
            4, 4,
            5, 5,
            7, 6,
            10, 7);

    private static final String NOMBRE_OBJETO_APLASTAMIENTO = "Aixafament";

    public Jugador pegarMonstro(Jugador jugador, ArrayList<Monstre> listaMonstruos) {
        Integer posicionMonstruo = POSICION_MONSTRUO_POR_SALA.get(jugador.getSalaActual());

        // Si en aquesta sala no hi ha monstre, no hi ha baralla
        if (posicionMonstruo == null) {
            return jugador;
        }

        Monstre monstruoRival = listaMonstruos.get(posicionMonstruo);
        System.out.println("Has decidit lluitar amb el/els " + monstruoRival.getNom());

        pelea(jugador, monstruoRival);
        return jugador;
    }

    private void pelea(Jugador jugador, Monstre monstruoRival) {
        int vidaRestanteMonstruo = monstruoRival.getVida();

        System.out.println("Acabas de començar la batalla amb el/els " + monstruoRival.getNom() + " !");

        while (vidaRestanteMonstruo > 0 && jugador.getVida() > 0) {

            // Si té l'objecte i decideix usar-lo, el monstre mor a l'instant
            if (jugadorTieneObjeto(jugador, NOMBRE_OBJETO_APLASTAMIENTO) && preguntarSiUsarAplastamiento()) {
                vidaRestanteMonstruo = 0; //Le aplicas el que va a morir? (JOEL)
                break;
            }

            // Torn del jugador
            System.out.println("Comences tu atacant!");
            vidaRestanteMonstruo -= jugador.getForca();
            System.out.println("El monstre s'ha quedat a: " + Math.max(vidaRestanteMonstruo, 0));

            // Si el monstre ja ha mort, no contraataca
            if (vidaRestanteMonstruo <= 0) {
                break;
            }

            // Torn del monstre
            System.out.println("Ahora ataca el monstre!");
            jugador.setVida(jugador.getVida() - monstruoRival.getDany());
            System.out.println("T'has quedat a " + Math.max(jugador.getVida(), 0) + " !");
        }

        if (jugador.getVida() <= 0) {
            main.setFi(true);
        } else {
            System.out.println("Has derrotat al monstre!!!");
            jugador.setOro(jugador.getOro() + monstruoRival.getOroSuelto());
            setVida(0); //por mirar si funciona
            if(main.campaments.get(monstruoRival.getZona()).isTeSmite() == true){
                System.out.println("Has aconseguit el smite!!!");
                main.inventari.add(main.obj.get(7));
            }
        }
    }

    private boolean jugadorTieneObjeto(Jugador jugador, String nombreObjeto) {
        for (Objectes objeto : jugador.getInventari()) {
            if (objeto.getNom().equals(nombreObjeto)) {
                return true;
            }
        }
        return false;
    }

    private boolean preguntarSiUsarAplastamiento() {
        int opcionElegida = 0;

        System.out.println("Vols usar l'aplastament??");
        System.out.println("    1) Si");
        System.out.println("    2) No");

        // Repeteix fins que l'usuari escrigui 1 o 2 (evita que "a" peti el programa)
        while (opcionElegida != 1 && opcionElegida != 2) {
            if (e.hasNextInt()) {
                opcionElegida = e.nextInt();
            } else {
                e.next(); // descarta el que no és un número
            }
            if (opcionElegida != 1 && opcionElegida != 2) {
                System.out.println("Opció no vàlida, escriu 1 o 2.");
            }
        }

        return opcionElegida == 1;
    }

    public void resetEnemic(){
        for(int i = 0; i < main.monstres.size(); i++){
            if(main.monstres.get(i).getVida() == 0 && main.monstres.get(i).getZona() == 7 || main.monstres.get(i).getZona() == 10){
                main.monstres.get(i).setVida(vidaMaximaMonstres.get(i));
            }
        }
    }

    public void creacioVides(){
        vidaMaximaMonstres.add(2050);
        vidaMaximaMonstres.add(2300);
        vidaMaximaMonstres.add(1200);
        vidaMaximaMonstres.add(1100);
        vidaMaximaMonstres.add(2300);
        vidaMaximaMonstres.add(1050);
    }
}
