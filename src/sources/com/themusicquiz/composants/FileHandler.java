package com.themusicquiz.composants;

import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;

public class FileHandler {

    public FileHandler() {}

    public String ReadFile_Files_ReadAllBytes(String filePath) throws IOException {
        char singleChar;
        String texte = "";
        try {
            File file = new File(filePath);
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            for(byte b : fileBytes) {
                singleChar = (char) b;
                texte+=String.valueOf(singleChar);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return texte;
    }

    public List<Item> GetItemListFromDB(String filePath) throws IOException {
        List<Item> itemList = new ArrayList<Item>();
        char singleChar;
        String texte = "";
        try {
            File file = new File(filePath);
            String fileDir = file.getParent();
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            for(byte b : fileBytes) {
                singleChar = (char) b;
                if(singleChar == '\n') {
                    String[] stringSplit = texte.split(" \\|\\|\\| ");
                    itemList.add(new Item(stringSplit[0], stringSplit[1], stringSplit[2], stringSplit[3], fileDir+"/covers/"+stringSplit[4].concat(".jpeg"), fileDir+"/summaries/"+stringSplit[4].concat(".txt")));
                    texte = "";
                }
                else {
                    texte+=String.valueOf(singleChar);
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
