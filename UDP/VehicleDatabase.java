package UDP;

import java.util.HashMap;
import java.util.Map;

public class VehicleDatabase {
    private static Map<String, Vehicle> database;

    static {
        database = new HashMap<>();
        database.put("B001", new Vehicle("B001", "Seat", "Ibiza", 2009, "Orange"));
        database.put("B002", new Vehicle("B002", "Hyundai", "Kona", 2019, "White"));
        database.put("A001", new Vehicle("A001", "VW", "Polo", 2005, "Black"));
        database.put("C002", new Vehicle("C002", "Audi", "A6", 2020, "Silver"));
        database.put("C003", new Vehicle("C003", "BMW", "X7", 2022, "Brown"));
    }

    public static Vehicle lookup(String plateId) {
        return database.getOrDefault(plateId, null);
    }
}
