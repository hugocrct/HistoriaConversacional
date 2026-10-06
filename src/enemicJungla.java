public class enemicJungla extends Personatges{
    
    int comptadorMoviments;
    int salaActualEnemic;

    public enemicJungla(String nom, int comptadorMoviments, int salaActualEnemic){
        super(nom);
        this.comptadorMoviments = comptadorMoviments;
        this.salaActualEnemic = salaActualEnemic;
    }

    public void setSalaActualEnemic(int salaActualEnemic){
        this.salaActualEnemic = salaActualEnemic;
    }

    public int getSalaActualEnemic(){
        return this.salaActualEnemic;
    }

    public void moviments(){
        int escollirMoviment = (int) (Math.random() * 2);

        if(escollirMoviment == 1){
            int numero = (int) (Math.random() * main.campaments.get(getSalaActualEnemic()).getSortides().size());
            setSalaActualEnemic(main.campaments.get(getSalaActualEnemic()).getSortides().get(numero));
        }
    }

    public void enemicPega(){
        if(main.j.getSalaActual() == 7 && main.j2.getSalaActualEnemic() == 7 || main.j.getSalaActual() == 8 && main.j2.getSalaActualEnemic() == 8 || main.j.getSalaActual() == 9 && main.j2.getSalaActualEnemic() == 9 || main.j.getSalaActual() == 10 && main.j2.getSalaActualEnemic() == 10){
            int tenimLlampec = 0;
            for(int i = 0; i < main.j.inventari.size(); i++){
                if(main.j.inventari.get(i).getNom().equals("Llampec")){
                    tenimLlampec = 1;
                }
            }
            if(tenimLlampec == 1 && main.obj.get(6).getCooldown() == 0){
                System.out.println("T'has trobat al enemic!!!");
                System.out.println("Per sort tens el llampec i pots escapar sense rebre cap mal");
                System.out.println("Vols utilitzar el llampec per escapar?");
                System.out.println("1. Si.");
                System.out.println("2. No.");
                int escull = main.e.nextInt();
                if(escull == 1){
                    main.j.moure();
                    main.obj.get(6).setCooldown(30);
                }
                else{
                    main.j.setVida(main.j.getVida() - 1000);
                    System.out.println("Et queda " + main.j.getVida() + " de vida");
                }
            }
            else{
                System.out.println("No tens el llampec, el enemic t'ataca");
                main.j.setVida(main.j.getVida() - 1000);
                System.out.println("Et queda " + main.j.getVida() + " de vida");
            }
            if(main.j.getVida() <= 0){
                main.setFi(true);
            }
        }
    }
}