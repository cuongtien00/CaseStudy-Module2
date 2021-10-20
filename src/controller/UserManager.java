package controller;

import model.Topping;
import model.User;
import storage.UseFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserManager userManager;
    private List<User>userList = new ArrayList<>();
    private UseFile useFile = UseFile.getInstance();

    private UserManager() {
    }
    public UserManager getInstance(){
        if(userManager == null){
            userManager = new UserManager();
        }
        return userManager;
    }
    public void addNewTop(User user) throws IOException {
        userList.add(user);
        useFile.fileWriter(userList);
    }
    public int findById(String id){
        for (User a:userList) {
            if(a.getId().equalsIgnoreCase(id)){
                return userList.indexOf(a);
            }
        }
        return -1;
    }
    public void removeT(String id) throws IOException {
        int index = findById(id);
        userList.remove(index);
        useFile.fileWriter(userList);
    }
    public void editTop(String id, User user) throws IOException {
        int index = findById(id);
        userList.set(index,user);
        useFile.fileWriter(userList);
    }
    public void showList(){
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　   ＝＝USER＝＝");
        for (User a:userList) {
            System.out.println("                                            "+a);
        }
    }

    public static UserManager getUserManager() {
        return userManager;
    }

    public static void setUserManager(UserManager userManager) {
        UserManager.userManager = userManager;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UseFile getUseFile() {
        return useFile;
    }

    public void setUseFile(UseFile useFile) {
        this.useFile = useFile;
    }
}
