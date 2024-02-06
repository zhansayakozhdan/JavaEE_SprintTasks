package db;

import models.Developer;

import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static List<Developer> developers = new ArrayList<>();
    static {
        developers.add(new Developer("Daulet", "D", "IT", 500000));
        developers.add(new Developer("Tili", "T", "IT", 500000));
        developers.add(new Developer("Amir", "A", "IT", 500000));
        developers.add(new Developer("Abylai", "A", "IT", 500000));
        developers.add(new Developer("Daryn", "D", "IT", 500000));
        developers.add(new Developer("Zhansaya", "Z", "IT", 500000));
        developers.add(new Developer("Dina", "D", "IT", 500000));
        developers.add(new Developer("Baglan", "B", "IT", 500000));
        developers.add(new Developer("Gulshat", "D", "IT", 500000));
    }

    public static List<Developer> getDevelopers() {
        return developers;
    }

    public static void addDeveloper(Developer developer){
        developers.add(developer);
    }

}
