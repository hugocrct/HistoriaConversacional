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
}
