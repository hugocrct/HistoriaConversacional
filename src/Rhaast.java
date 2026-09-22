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
}
