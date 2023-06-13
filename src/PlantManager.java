import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantManager {

    private List<Plant> plantList
            = new ArrayList<>();

    public void loadDataFromFile(String filename, String delimiter) throws PlantException {
        String[] items = new String[0];
        String line = "";
        int lineNumber = 1;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                System.out.println(line);
                items = line.split(delimiter);
                if (items.length != 5)
                    throw new PlantException("Špatný počet položek na řádku: " + lineNumber + ": " + line);
                plantList.add(new Plant(items[0], items[1], LocalDate.parse(items[3]), LocalDate.parse(items[4]), Integer.parseInt(items[2])));
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor " + filename + " nebyl nalezen! " + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            throw new PlantException("Špatně zadané číslo " + items[2] + " na řádku:" + lineNumber + ":\n" + line);
        }
    }

    public void add(Plant newPlant) {
        plantList.add(newPlant);
    }

    public void remove(Plant plant) {
        plantList.remove(plant);
    }

    public Plant get(int index) {
        return plantList.get(index);
    }

    public List<Plant> getPlantList() {
        return new ArrayList<>(plantList);
    }

    public int size() {
        return plantList.size();
    }

}