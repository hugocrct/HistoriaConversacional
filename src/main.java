import java.util.ArrayList;
import java.util.Scanner;

public class main {

    Scanner e = new Scanner(System.in);
    static ArrayList<Campament> campaments = new ArrayList<>();
    Jugador j = new Jugador("Kayn", 10, 100, 5);


    public static void main(String[] args) {
        main p = new main();
        p.principal();
    }

    public void principal() {

        crearCampamentos(campaments);
        menu();

    }

    private void menu() {
        boolean fi = false;
        int vueltas = 0;
        do {
            if (vueltas == 0) {
                System.out.println("Benvingut a la historia conversacional lolera!!");
                System.out.println("Benvingut a la Jungla\n" + "\n" + "Ets Kayn, caçador de la jungla, però no vas sol: dins teu hi ha Rhaast, la veu que et guia i que no sempre diu la veritat. Recorre els vuit territoris, fes-te prou fort i enfronta't al Baró abans que ell acabi amb tu.");
                vueltas++;
            }
            int queFer = 0;
            do {
                 System.out.println("Que vols fer?");
                System.out.println("1) Moure");
                System.out.println("2) Chupar pito");
                queFer = e.nextInt();
            } while (queFer <= 0 || queFer > 2);

            switch (queFer) {
                case 1:
                    j.moure();
                    break;
            
                default:
                    break;
            }
        } while (!fi);
    }

    private void crearCampamentos(ArrayList<Campament> campaments) {
        int numCamp = 0;
        String nom = "";
        String descripcio = "";
        int numZona = 0;
        Campament camp;
        do {
             ArrayList<Integer> sortides = new ArrayList<>();
            switch (numCamp) {
                case 0:
                    nom = "Gromp";
                    descripcio = "Campament situat al costat del Blue, format per un gran gripau. Si vols anar al Blue, a la riada de toplane o al barón hauras de passar per aquí";
                    numZona = 0;
                    sortides.add(1);// Blue
                    sortides.add(9);// Rio de top
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                case 1:
                    nom = "Blue";
                    descripcio = "Campament que conté una roca gegant que dona molt or al ser derrotada i te molta vida. Desde aquí pots anar als Llops i al Gromp.";
                    numZona = 1;
                    sortides.add(0); // Gromp
                    sortides.add(2);// Llops
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                case 2:
                    nom = "Llops";
                    descripcio = "Campament format per una manada de llops. Pots camiran cap al Blue i els Picutxins";
                    numZona = 2;
                    sortides.add(1);// Blue
                    sortides.add(3);// Picus
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                case 3:
                    nom = "Picutxins";
                    descripcio = "Campament format per diversos ocells petits i la seva mare. Desde aquí accedeixes als llops i al Red";
                    numZona = 3;
                    sortides.add(2);// Lobos
                    sortides.add(4);// Red
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                case 4:
                    nom = "Red";
                    descripcio = "Campament que conté un arbre viu gegant que dona molt or al ser derrotat i te molta vida. Desde aquí pots anar als Picus i als Krugs.";
                    numZona = 4;
                    sortides.add(5);// Krugs
                    sortides.add(3);// Picus
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                case 5:
                    nom = "Krugs";
                    descripcio = "Campament de criatures de pedra de petita dimensions. Pots arribar fins al Red, a la riada de botlane.";
                    numZona = 5;
                    sortides.add(4);// Red
                    sortides.add(8);// Rio bot
                    sortides.add(7);// Dragon
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                case 6:
                    nom = "Base";
                    descripcio = "La base és el lloc segur on els campions poden comprar objectes, recuperar vida i tornar al combat. Pots caminar fins als llops o als picus";
                    numZona = 5;
                    sortides.add(2);// Lobos
                    sortides.add(3);// Picus
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                case 7:
                    nom = "Drac de aigua";
                    descripcio = "Cova on trobarem al temit drac d'aigua, es només accesible desde el riu de bot. ";
                    numZona = 7;
                    sortides.add(8);// Rio bot
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                case 8:
                    nom = "Riada de bot";
                    descripcio = "Zona del riu situada a la part inferior del mapa, entre la jungla i el carril inferior.";
                    numZona = 8;
                    sortides.add(7);// Drac
                    sortides.add(5);// Krugs
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                case 9:
                    nom = "Riada de top";
                    descripcio = "Zona del riu situada a la part superior del mapa, entre la jungla i el carril superior.";
                    numZona = 9;
                    sortides.add(0);// Gromp
                    sortides.add(10);// baron
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                case 10:
                    nom = "Riada de top";
                    descripcio = "Gran monstre situat al riu superior que atorga una poderosa millora a l’equip que el derrota.";
                    numZona = 10;
                    sortides.add(0);// Gromp
                    sortides.add(10);// baron
                    camp = new Campament(nom, descripcio, sortides, numZona);
                    campaments.add(camp);
                    numCamp++;
                    break;
                default:
                    numCamp++;
                    break;
            }
        } while (numCamp != 10);
    }
}