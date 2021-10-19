package controller;

import model.MilkTea;
import storage.MilkTeaReaderWriterFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MilkTeaManager {
    private static MilkTeaManager milkTeaManager;
    private static List<MilkTea> milkTeaList= new ArrayList<>();
    private  MilkTeaReaderWriterFile milkTeaReaderWriterFile;

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

    public MilkTeaReaderWriterFile getMilkTeaReaderWriterFile() {
        return milkTeaReaderWriterFile;
    }

    public void setMilkTeaReaderWriterFile(MilkTeaReaderWriterFile milkTeaReaderWriterFile) {
        this.milkTeaReaderWriterFile = milkTeaReaderWriterFile;
    }


    public int findByCode(String code){
        for (MilkTea a:milkTeaList) {
            if(a.getCode().equalsIgnoreCase(code)){
               return milkTeaList.indexOf(a);
            }
        }
        return -1;
    }


    public void addNewMilkTea(MilkTea milkTea) {
        milkTeaList.add(milkTea);
//        milkTeaReaderWriterFile.fileWriter(milkTeaList);
    }
    public void removeMilkTea(String code) {
        int index = findByCode(code);
        milkTeaList.remove(index);
//        milkTeaReaderWriterFile.fileWriter(milkTeaList);
    }
    public void editMilkTeaList(String code, MilkTea milkTea)  {
        int index = findByCode(code);
        milkTeaList.set(index,milkTea);
//        milkTeaReaderWriterFile.fileWriter(milkTeaList);
    }
    public int getBestSeller(){
        return 1;
    };
    public void showList(){
        for (MilkTea a:milkTeaList) {
            System.out.println(a);
        }
    }

    public List<MilkTea> getMilkTeaList() {
        return milkTeaList;
    }

    public void setMilkTeaList(List<MilkTea> milkTeaList) {
        this.milkTeaList = milkTeaList;
    }
}
