package controller;

import model.MilkTea;
import storage.MilkTeaReaderWriterFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MilkTeaManager {
    private List<MilkTea> milkTeaList;
    private MilkTeaReaderWriterFile milkTeaReaderWriterFile;

    public MilkTeaManager(List<MilkTea> milkTeaList) {
        this.milkTeaList = milkTeaList;
    }

    public void addNewMilkTea(MilkTea milkTea) throws IOException {
        milkTeaList.add(milkTea);
        milkTeaReaderWriterFile.fileWriter(milkTeaList);
    }
    public void removeMilkTea(int index) throws IOException {
        milkTeaList.remove(index);
        milkTeaReaderWriterFile.fileWriter(milkTeaList);
    }
    public void editMilkTeaList(int index, MilkTea milkTea) throws IOException {
        milkTeaList.set(index,milkTea);
        milkTeaReaderWriterFile.fileWriter(milkTeaList);
    };
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
