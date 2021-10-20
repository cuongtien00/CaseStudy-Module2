package controller;

import model.MilkTea;
import storage.MilkTeaFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MilkTeaManager {
    private static MilkTeaManager milkTeaManager;
    private static List<MilkTea> milkTeaList= new ArrayList<>();
    private MilkTeaFile milkTeaFile = MilkTeaFile.getInstance();

    private MilkTeaManager(){}
    public static MilkTeaManager getInstance(){
        if(milkTeaManager==null){
            milkTeaManager = new MilkTeaManager();
        }
        return milkTeaManager;
    }

    public static MilkTeaManager getMilkTeaManager() {        return milkTeaManager;
    }

    public static void setMilkTeaManager(MilkTeaManager milkTeaManager) {
        MilkTeaManager.milkTeaManager = milkTeaManager;
    }

    public MilkTeaFile getMilkTeaReaderWriterFile() {
        return milkTeaFile;
    }

    public void setMilkTeaReaderWriterFile(MilkTeaFile milkTeaFile) {
        this.milkTeaFile = milkTeaFile;
    }


    public int findByCode(String code){
        for (MilkTea a:milkTeaList) {
            if(a.getCode().equalsIgnoreCase(code)){
               return milkTeaList.indexOf(a);
            }
        }
        return -1;
    }


    public void addNewMilkTea(MilkTea milkTea) throws IOException {
        milkTeaList.add(milkTea);
        milkTeaFile.fileWriter(milkTeaList);
    }
    public void removeMilkTea(String code) throws IOException {
        int index = findByCode(code);
        milkTeaList.remove(index);
        milkTeaFile.fileWriter(milkTeaList);
    }
    public void editMilkTeaList(String code, MilkTea milkTea) throws IOException {
        int index = findByCode(code);
        milkTeaList.set(index,milkTea);
        milkTeaFile.fileWriter(milkTeaList);
    }
    public int getBestSeller(){
        return 1;
    };
    public void showList(){
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　＝＝TEA_MENU＝＝");
        for (MilkTea a:milkTeaList) {
            System.out.println("                  "+a);
        }
    }

    public List<MilkTea> getMilkTeaList() {
        return milkTeaList;
    }

    public void setMilkTeaList(List<MilkTea> milkTeaList) {
        this.milkTeaList = milkTeaList;
    }
}
