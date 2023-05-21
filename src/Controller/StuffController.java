package Controller;

import Model.Stuffs.*;
import Model.Stuffs.DigitalStuffs.*;
import Model.Stuffs.DigitalStuffs.DataStoring.*;
import Model.Stuffs.Food.*;
import Model.Stuffs.Stationary.*;
import Model.Stuffs.Vehicle.*;

import java.util.ArrayList;

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
}
