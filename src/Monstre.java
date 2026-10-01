import java.util.ArrayList;

public class Monstre extends Personatges{
    
    String descripcio;
    int vida;
    int dany;
    int zona;
    int oroSuelto;
    public Monstre(String nom, int vida, int dany, int zona, int oroSuelto){
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
    public static Jugador pegarMonstro(Jugador j, ArrayList<Monstre> monstre){
        int salaActual = j.getSalaActual();
        String monstreActual ="";
        int vidaMonstre=0;
        int vidaJugador=0;
        switch (salaActual) {
            case 0:
                monstreActual="Gromp";
                vidaMonstre= main.monstres.get(0).getVida();
                vidaJugador= j.getVida();
                do {
                    
                } while (vidaMonstre!=0);
                break;
            case 1:
                monstreActual="Blue";
                vidaMonstre= main.monstres.get(1).getVida();
                vidaJugador= j.getVida();
                do {
                    
                } while (vidaMonstre!=0);
                break;
            case 2:
                monstreActual="Llops";
                vidaMonstre= main.monstres.get(2).getVida();
                vidaJugador= j.getVida();
                break;
            case 3:
                monstreActual="Picutxins";
                vidaMonstre= main.monstres.get(3).getVida();
                vidaJugador= j.getVida();
                break;
            case 4:
                monstreActual="Red";
                vidaMonstre= main.monstres.get(4).getVida();
                vidaJugador= j.getVida();
                break;
            case 5:
                monstreActual="Krugs";
                vidaMonstre= main.monstres.get(5).getVida();
                vidaJugador= j.getVida();
                break;
            case 7:
                monstreActual="Drac";
                vidaMonstre= main.monstres.get(6).getVida();
                vidaJugador= j.getVida();
                break;
            case 10:
                monstreActual="Baró";
                vidaMonstre= main.monstres.get(7).getVida();
                vidaJugador= j.getVida();
                break;
            default:
                break;
        }
        System.out.println("Has decidit lluitar amb el/els " + monstreActual);
        return j;
    }
}
