public class Main {
    public static void main(String[] args) {
        PlantManager plantManager = new PlantManager();
        try {
            plantManager.loadDataFromFile(Settings.fileName(), Settings.delimiter());
        } catch (PlantException e) {
            System.err.println("Nepodařilo se načíst data ze souboru! "+e.getLocalizedMessage());
        }

        System.out.println("");

        int i = 0;
        while(i < plantManager.size()) {
            System.out.println(plantManager.get(i));
            i++;
        }
    }
}