package Controller;

import Model.Stuffs.DigitalStuffs.DataStoring.SSD;
import Model.Stuffs.DigitalStuffs.DataStoring.USB;
import Model.Stuffs.DigitalStuffs.PC;
import Model.Stuffs.Food.Food;
import Model.Stuffs.Stationary.NoteBook;
import Model.Stuffs.Stationary.Pen;
import Model.Stuffs.Stationary.Pencil;
import Model.Stuffs.Stuff;
import Model.Stuffs.Vehicle.Automobile;
import Model.Stuffs.Vehicle.Bicycle;

import java.util.ArrayList;
import java.util.Arrays;

public class StuffController {


    private static ArrayList<Stuff> stuffs = new ArrayList<>();

    public static ArrayList<Stuff> getStuffs() {
        return stuffs;
    }

    public static void setRate(Stuff stuff, double rate) {
        stuff.setRateCount();
        stuff.setTotalRate(stuff.getTotalRate() + rate);
        stuff.setAverageRate(stuff.getTotalRate() / stuff.getRateCount());
    }

    public static void addStuff(PC newStuff) {
        stuffs.add(newStuff);
    }

    public static void addStuff(USB newStuff) {
        stuffs.add(newStuff);
    }

    public static void addStuff(SSD newStuff) {
        stuffs.add(newStuff);
    }

    public static void addStuff(Food newStuff) {
        stuffs.add(newStuff);
    }

    public static void addStuff(NoteBook newStuff) {
        stuffs.add(newStuff);
    }

    public static void addStuff(Pen newStuff) {
        stuffs.add(newStuff);
    }

    public static void addStuff(Pencil newStuff) {
        stuffs.add(newStuff);
    }

    public static void addStuff(Automobile newStuff) {
        stuffs.add(newStuff);
    }

    public static void addStuff(Bicycle newStuff) {
        stuffs.add(newStuff);
    }

    public static void editName(Stuff stuff, String name) {
        stuff.setName(name);
    }

    public static void editPrice(Stuff stuff, double price) {
        stuff.setPrice(price);
    }

    public static void editName(Stuff stuff, int Count) {
        stuff.setCount(Count);
    }

    public static void deleteStuff(Stuff stuff) {
        stuffs.remove(stuff);
    }

    public static void sortStuff() {
        Arrays.sort(stuffs.toArray());
    }
}
