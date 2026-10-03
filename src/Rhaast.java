public class Rhaast extends Personatges{
    boolean diuVeritat;

    public Rhaast(String nom, boolean diuVeritat){
        super(nom);
        this.diuVeritat = diuVeritat;
    }

    public boolean isDiuVeritat() {
        return diuVeritat;
    }

    public void setDiuVeritat(boolean diuVeritat) {
        this.diuVeritat = diuVeritat;
    }

    public boolean calculVeritat(){
        int numero = (int) (Math.random() * 2);
        if(numero == 0){
            return false;
        }
        else{
            return true;
        }
    }

    public void onEsSmite(){
        if(!calculVeritat()){
            if(main.campaments.get(4).isTeSmite() == true){
                System.out.println("El smite es en el campament numero 1.");
            }
            else{
                System.out.println("El smite es en el campament numero 4.");
            } 
        }
        else{
            if(main.campaments.get(4).isTeSmite() == true){
                System.out.println("El smite es en el campament numero 4.");
            }
            else{
                System.out.println("El smite es en campament numero 1.");
            }
        }
    }
}
