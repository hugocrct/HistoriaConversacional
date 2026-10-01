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
        boolean moviment = false;
        int escollirMoviment = (int) (Math.random() * 2);
        
        if(escollirMoviment == 1){
            for(int i = 0; i < main.campaments.get(getSalaActualEnemic()).getSortides().size(); i++){
                for(int l = 0; l < main.campaments.get(getSalaActualEnemic()).getSortides().get(i); l++){
                    do {
                        int numero = (int) (Math.random() * 12);
                        if(numero == main.campaments.get(getSalaActualEnemic()).getSortides().get(i)){
                            moviment = true;
                            setSalaActualEnemic(numero);
                            return;
                        }
                    } while (!moviment);
                }
            }
        }  
    }
}
