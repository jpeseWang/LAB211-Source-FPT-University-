/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class GarbageTruck{
    private int total = 0;
    private int time = 0;
    private final double costLabor = 120000;
    private final double costDump = 57000;
    private int count = 0;
    private ArrayList<GarbageStation> garbageStations;
    public GarbageTruck() {
        garbageStations = new ArrayList<>();
    }
    public GarbageTruck(int total, int time) {
        this.total = total;
        this.time = time;
    }

    public ArrayList<GarbageStation> getGarbageStations() {
        return garbageStations;
    }

    public void setGarbageStations(ArrayList<GarbageStation> garbageStations) {
        this.garbageStations = garbageStations;
    }
    
    public void calculate() {
        for (int i = 0; i < garbageStations.size(); i++) {
            if (total + garbageStations.get(i).getAmount() > 10000) {
                System.out.println("Dump the garbage.");
                time = time + 30;
                count++;
                total = 0;
            }
            total = total + garbageStations.get(i).getAmount();
            time = time + 8;
        }
        System.out.println("Dump the garbage.");
        time = time + 30;
        count++;
    }
    public double calculateTheCost() {
        if (garbageStations.size() != 0)
            calculate();
        double a = (double) time/60;
        return a * costLabor + count * costDump;
    }

    @Override
    public String toString() {
        return "The total cost is: " + calculateTheCost();
    }
}

