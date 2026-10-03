import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

        Scanner e = new Scanner(System.in);
        static ArrayList<Campament> campaments = new ArrayList<>();
        static ArrayList<Objectes> obj = new ArrayList<>();
        static ArrayList<Objectes> inventari = new ArrayList<>();
        static ArrayList<Monstre> monstres = new ArrayList<>();
        Jugador j = new Jugador("Kayn", 120, 500, 6, 0, inventari, 0);
        enemicJungla j2 = new enemicJungla("Rammus", 0, 5);
        static boolean fi = false;
        Campament c;
        Rhaast r = new Rhaast("Rhaast", fi);
        

        public static void main(String[] args) {
                main p = new main();
                p.principal();
        }

        public void principal() {

                crearCampamentos(campaments);
                setSmite();
                crearObjectes(obj);
                crearMonstres(monstres);
                menu();

        }

          public void setSmite(){
                int numero = (int) (Math.random() * 2);
                if(numero == 0){
                main.campaments.get(4).setTeSmite(false);
                }
                else{
                main.campaments.get(1).setTeSmite(false);
                }
        }

        private void menu() {

                int vueltas = 0;
                int contador = 0; // comntrol de turnos para reset de campamentos
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
                                System.out.println("2) Parlar amb en Rhaast");
                                if (j.getSalaActual() == 6) {
                                        System.out.println("3) Comprar objectas");
                                } else if (j.getSalaActual() == 5 || j.getSalaActual() == 0) {
                                        System.out.println("3) Wardejar la riada");
                                } else if (j.getSalaActual() != 6) {
                                        if (j.getSalaActual() == 5 || j.getSalaActual() == 0) {
                                                System.out.println("4) Pegar monstre");
                                        } else {
                                                System.out.println("3) Pegar monstre");
                                        }
                                }
                                queFer = e.nextInt();
                        } while (queFer <= 0 || queFer > 2);

                        switch (queFer) {
                                case 1:
                                        j.moure();
                                        contador++;
                                        break;
                                case 2:
                                        r.onEsSmite();
                                        contador++;
                                        break;
                                case 3:
                                        if (j.getSalaActual() == 6) {
                                                // metodo comprar objetos
                                                contador++;
                                        } else if (j.getSalaActual() == 5 || j.getSalaActual() == 0) {
                                                if (j.getSalaActual() == 5) {
                                                        // wardear top
                                                        contador++;
                                                } else {
                                                        // wardear bot
                                                        contador++;
                                                }
                                        } else if (j.getSalaActual() != 6) {
                                                if (j.getSalaActual() == 5 || j.getSalaActual() == 0) {
                                                        Monstre monstre2 = new Monstre(null, 0, 0, 0, 0);
                                                        monstre2.pegarMonstro(j, monstres);
                                                        contador++;
                                                } else {
                                                        // pegar monstruo
                                                        contador++;
                                                }
                                        }
                                        break;
                                default:
                                        break;
                        }
                        
                        if(contador == 10){
                                Monstre m = new Monstre(null, 0, 0, 0, 0);
                                m.resetEnemic();
                        }

                } while (!fi);
        }

        private void crearMonstres(ArrayList<Monstre> monstres2) {
                monstres.add(new Monstre(
                                "Gromp",
                                2050, 80, 0, 350));
                monstres.add(new Monstre(
                                "Blue",
                                2300, 78, 1, 500));
                monstres.add(new Monstre(
                                "Llops",
                                1200, 42, 2, 250));
                monstres.add(new Monstre(
                                "Picutxins",
                                1100, 45, 3, 500));
                monstres.add(new Monstre(
                                "Red",
                                2300, 78, 4, 500));
                monstres.add(new Monstre(
                                "Krugs",
                                1050, 45, 5, 350));
                monstres.add(new Monstre(
                                "Drac",
                                5000, 120, 7, 2000));

                monstres.add(new Monstre(
                                "Baró",
                                12600, 225, 10, 20000000));
        }

        private void crearObjectes(ArrayList<Objectes> obj) {

                obj.add(new Objectes(
                                "Cor d'acer",
                                "Atorga letalitat i augmenta el dany físic contra enemics amb més vida que tu.",
                                "Més dany contra enemics més grans",
                                0, 2,
                                1100));

                obj.add(new Objectes(
                                "Bastó del buit",
                                "És un bastó; els rumors diuen que és el tentacle d'un calamar que va derrotar en Gragas i que atorga 'poders' màgics a qui el porta.",
                                "Aplica sagnat als objectius.",
                                0, 3,
                                1050));

                obj.add(new Objectes(
                                "Fil de l'infinit",
                                "És una espasa groga considerada una relíquia, forjada al fiord argentí pels elfs.",
                                "En impactar a un objectiu Kayn roba parcialment la vida de l'enemic.",
                                0, 3,
                                900));

                obj.add(new Objectes(
                                "Rellotge de Sorra de Zhonya",
                                "És un rellotge creat per una vella noble que va morir amb ell a la mà, aquest esdeveniment va donar-li característiques místiques a l'objecte.",
                                "Dona la possibilitat al portador d'aturar el temps i de recuperar vida durant l'aturada.",
                                0, 6,
                                1100));

                obj.add(new Objectes(
                                "Oposició Celestial",
                                "L'escut d'un dels més valerosos 'tercios', fet amb or i una fusta molt robusta és del més impenetrable que trobaràs.",
                                "Dona a en Kayn més resistència als copets enemics",
                                0, 0,
                                880));

                obj.add(new Objectes(
                                "Soles Simbiòtiques",
                                "Unes botes amb molta 'aura' que et faran ser el més estilós de tota La Fenedura de l'Invocador.",
                                "En Kayn és més ràpid",
                                0, 0,
                                1000));

                obj.add(new Objectes(
                                "Llampec",
                                "Alguns diuen que és un mite, altres diuen que és verídic però tothom està d'acord que és un poder màgic que 'suposadament' entrega el poderós drac d'aigua en ser derrotat..",
                                "En Kayn pot fer una teletransportació a un parell de metres d'on està mirant, útil per escapar del jungla enemic.",
                                1, 0,
                                0));

                obj.add(new Objectes(
                                "Aixafament",
                                "Una eina perduda fa molt de temps a La Fenedura de l'Invocador que diuen que té el poder d'invocar llampecs sobre un enemic.",
                                "Aplica 900 de dany sobre un enemic.",
                                1, 0,
                                0));
                obj.add(new Objectes(
                                "Ward",
                                "Un arbolet magic, alguns diuen que es el fill del campió 'Ivern'.",
                                "Dona visió a les zones designades (riades de top i de bot).",
                                2, 0,
                                100));
        }

        private void crearCampamentos(ArrayList<Campament> campaments) {
                campaments.add(new Campament(
                                "El pantà del Gromp",
                                "Campament situat al costat del Blue, format per un gran gripau. Si vols anar al Blue, a la riada de toplane o al Baró hauràs de passar per aquí",
                                new ArrayList<>(List.of(1, 9)),
                                0,
                                false, false));

                campaments.add(new Campament(
                                "El santuari del Blue",
                                "Campament que conté una roca gegant que dona molt d'or en ser derrotada i té molta vida. Des d'aquí pots anar als Llops i al Gromp.",
                                new ArrayList<>(List.of(0, 2)),
                                1,
                                false, true));

                campaments.add(new Campament(
                                "El llairó dels Llops",
                                "Campament format per una ramat de llops. Pots caminar cap al Blue i els Picutxins. També pots anar a la base.",
                                new ArrayList<>(List.of(1, 3, 6)),
                                2,
                                false, false));

                campaments.add(new Campament(
                                "El niu dels Picutxins",
                                "Campament format per diversos ocells petits i la seva mare. Des d'aquí accedeixes als llops, al Red i a la base.",
                                new ArrayList<>(List.of(2, 4, 6)),
                                3,
                                false, false));

                campaments.add(new Campament(
                                "La cau del Red",
                                "Campament que conté un arbre viu gegant que dona molt d'or en ser derrotat i té molta vida. Des d'aquí pots anar als Picus i als Krugs.",
                                new ArrayList<>(List.of(3, 5)),
                                4,
                                false, true));

                campaments.add(new Campament(
                                "La pedrera Krugs",
                                "Campament de criatures de pedra de petites dimensions. Pots arribar fins al Red o a la riada de bot.",
                                new ArrayList<>(List.of(4, 8)),
                                5,
                                false, false));

                campaments.add(new Campament(
                                "Base",
                                "La base és el lloc segur on els campions poden comprar objectes, recuperar vida i tornar al combat. Pots caminar fins als llops o als picus.",
                                new ArrayList<>(List.of(2, 3)),
                                6,
                                false, false));

                campaments.add(new Campament(
                                "Fosa del drac",
                                "Cova on trobarem el temut drac d'aigua, és només accessible des del riu de bot.",
                                new ArrayList<>(List.of(8)),
                                7,
                                false, false));

                campaments.add(new Campament(
                                "Riada de bot",
                                "Zona del riu situada a la part inferior del mapa, entre la jungla i el carril inferior.",
                                new ArrayList<>(List.of(5, 7)),
                                8,
                                false, false));

                campaments.add(new Campament(
                                "Riada de top",
                                "Zona del riu situada a la part superior del mapa, entre la jungla i el carril superior.",
                                new ArrayList<>(List.of(0, 10)),
                                9,
                                false, false));

                campaments.add(new Campament(
                                "La caverna del baró",
                                "Ubicació on es troba el 'boss' final, és el més perillós de tota la jungla de League of Legends.",
                                new ArrayList<>(List.of(9)),
                                10,
                                false, false));
        }

        public static void setFi(boolean estado) {
                fi=estado;
                if (fi=true){
                        System.out.println("Has mort!!!");
                }
        }
}