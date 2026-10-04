public class Rhaast extends Personatges {
    boolean diuVeritat;

    public Rhaast(String nom, boolean diuVeritat) {
        super(nom);
        this.diuVeritat = diuVeritat;
    }

    public boolean isDiuVeritat() {
        return diuVeritat;
    }

    public void setDiuVeritat(boolean diuVeritat) {
        this.diuVeritat = diuVeritat;
    }

    /** true = aquesta vegada diu la veritat, false = menteix (50/50). */
    public boolean calculVeritat() {
        return Math.random() < 0.5;
    }

    public void onEsSmite() {
        boolean enRed = main.campaments.get(4).isTeSmite();
        boolean enBlue = main.campaments.get(1).isTeSmite();

        // Si ningú el té, és que ja l'has agafat
        if (!enRed && !enBlue) {
            System.out.println("Rhaast: Ja tens el smite, no et cal res més de mi.");
            return;
        }

        int real = enRed ? 4 : 1;
        int altre = enRed ? 1 : 4;
        int dit = calculVeritat() ? real : altre;
        System.out.println("Rhaast: El smite és al campament número " + dit + ".");
    }
}