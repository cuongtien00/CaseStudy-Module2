package controller;

import model.MilkTea;
import storage.MilkTeaFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MilkTeaManager {
    private static MilkTeaManager milkTeaManager;
    private static List<MilkTea> milkTeaList= new ArrayList<>();
    private static MilkTeaFile milkTeaFile = MilkTeaFile.getInstance();

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
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――TRÀ SỮA――――――――――――――――――――――――――――――――――――――――――――――――――");
        for (int i = 0; i < 5; i++) {
            System.out.println("                  "+milkTeaList.get(i));
        }
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――TRÀ TRÁI CÂY――――――――――――――――――――――――――――――――――――――――――――――――");

        for (int i = 5; i <10 ; i++) {
            System.out.println("                  "+milkTeaList.get(i));
        }
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――TRÀ ĐẶC BIỆT ĐÀI LOAN――――――――――――――――――――――――――――――――――――――――――――");
        for (int i = 10; i <milkTeaList.size() ; i++) {
            System.out.println("                  "+milkTeaList.get(i));
        }
        System.out.println("");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　  募茶");
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――DING――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　   どうぞお召し上がりくださいTEA");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　   ～⊝～⊝～⊝～");

    }


    public List<MilkTea> getMilkTeaList() {
        return milkTeaList;
    }

    public void setMilkTeaList(List<MilkTea> milkTeaList) {
        this.milkTeaList = milkTeaList;
    }
}
