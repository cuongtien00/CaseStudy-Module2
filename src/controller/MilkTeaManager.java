package controller;

import model.MilkTea;

import java.util.ArrayList;
import java.util.List;

public class MilkTeaManager {
    private List<MilkTea> milkTeaList;

    public MilkTeaManager() {
        milkTeaList = new ArrayList<>();
    }
    public void addNewMilkTea(MilkTea milkTea){
        milkTeaList.add(milkTea);
    }
    public void removeMilkTea(MilkTea milkTea){
        milkTeaList.remove(milkTea);
    }
    public void editMilkTeaList(){};
    public int getBestSeller(){
        return 1;
    };
    public void showList(){
        for (MilkTea a:milkTeaList) {
            System.out.println(a);
        }
    }

}
