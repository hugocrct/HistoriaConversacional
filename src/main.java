import java.util.ArrayList;
import java.util.Scanner;

public class main {

    Scanner e = new Scanner(System.in);
    static ArrayList<Campament> campaments = new ArrayList<>();
    static ArrayList<Objectes> obj = new ArrayList<>();
    static ArrayList<Objectes> inventari = new ArrayList<>();

    Jugador j = new Jugador("Kayn", 10, 100, 5, 0, inventari);
    enemicJungla j2 = new enemicJungla("Rammus", 0, 5);
    public static void main(String[] args) {
        main p = new main();
        p.principal();
    }

    public void principal() {

        crearCampamentos(campaments);
        crearObjectes(obj);
        menu();

    }

    private void menu() {
        boolean fi = false;
        int vueltas = 0;
        do {
            if (vueltas == 0) {
                System.out.println("Benvingut a la historia conversacional lolera!!");
                System.out.println("Benvingut a la Jungla\n" + "\n"
                        + "Ets Kayn, caçador de la jungla, però no vas sol: dins teu hi ha Rhaast, la veu que et guia i que no sempre diu la veritat. Recorre els vuit territoris, fes-te prou fort i enfronta't al Baró abans que ell acabi amb tu.");
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
    private void crearObjectes (ArrayList<Objectes> obj){
        String nom="";
        String descripcio="";
        String efecte="";
        int tipus=0;
        int cooldown=0;
        Objectes objetos;
        int numObj=0;
        switch (numObj) {
            case 1:
                nom ="Cor d'acer";
                descripcio="Atorga letalitat i augmenta el dany físic contra enemics amb més vida que tu.";
                efecte="Mes dany contra enemics mes grans";
                cooldown=2;
                numObj++;
                objetos= new Objectes(nom, descripcio, efecte, tipus, cooldown);
                break;
            case 2:
                nom="Bastó del buit";
                descripcio="És un bastó; els rumors diuen que és el tentacle d'un calamar que va derrotar en Gragas i que atorga 'poders' màgics a qui el porta.";
                efecte="Aplica sagnat als objectius.";
                cooldown=3;
                numObj++;
                objetos= new Objectes(nom, descripcio, efecte, tipus, cooldown);
                break;
            case 3:
                nom="Fil de l'infinit";
                descripcio="És una espasa groga considerada una relíquia, forjada al fiord argentí pels elfs.";
                efecte="Al impactar a un objectiu Kayn roba parcialment la vida del enemic.";
                cooldown=3;
                numObj++;
                objetos= new Objectes(nom, descripcio, efecte, tipus, cooldown);
                break;
            case 4:
                nom="Rellotge de Sorra de Zhonya";
                descripcio="Es un rellotge creat per una vella noble que va morir amb ell a la má, aquet event va donarli caracteristiques mistiques al objecte.";
                efecte="Dona la posibilitat al portador de aturar el temps i de recuperar vida durant l'aturada.";
                cooldown=6;
                numObj++;
                objetos= new Objectes(nom, descripcio, efecte, tipus, cooldown);
            break;
            case 5:
                nom="Oposició Celestial";
                descripcio="L'escut d'un dels mes valerosos 'tercios', fet amb or i una fusta molt robusta es del mes inpenetrable que trovarás.";
                efecte="Dona a Kayn mes resistencia als golpeixos enemics";
                cooldown=0;
                numObj++;
                objetos= new Objectes(nom, descripcio, efecte, tipus, cooldown);
            break;
            case 6:
                nom="Soles Simbiòtiques";
                descripcio="Unes botes amb molta 'aura' que et faran ser el mes estilós de tota la La Fenedura de l'Invocador.";
                efecte="Kayn es més rápid";
                cooldown=0;
                numObj++;
                objetos= new Objectes(nom, descripcio, efecte, tipus, cooldown);
            break;
            case 7:
                nom="Llampec";
                descripcio="Alguns diuen que es un mite, altres diuen que es veridic pero tothom está d'acord en que es un poder magic que 'soposadament' entrega el poderós drac d'aigua al ser derrotat..";
                efecte="Kayn pot fer una teletransportació a un parell de metres d'on este mirant, útil per escapar del jungla enemic.";
                cooldown=0;
                numObj++;
                objetos= new Objectes(nom, descripcio, efecte, tipus, cooldown);
            break;
            case 8:
                nom="Aixafament";
                descripcio="Una Eina perduda fa molt de temps en La Fenedura de l'Invocador que diuen que te el poder d'invocar rampegs sobre un enemic.";
                efecte="Aplica 900 de dany sobre un enemic.";
                cooldown=0;
                numObj++;
                objetos= new Objectes(nom, descripcio, efecte, tipus, cooldown);
            break;
        }
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
                    nom = "Fosa del drac";
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
                    nom = "Fosa del baró";
                    descripcio = "Ubicació on es troba el boss final, es el mes perillos de tota la jungla de League of Legends.";
                    numZona = 10;
                    sortides.add(9);// Rio top
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