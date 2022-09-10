package com.fileio;

import java.io.*;

public class FileHandlling {
    void fileCreate(String filename){
        {
            try {
                File Obj = new File(filename+".txt");
                if (Obj.createNewFile()) {
                    System.out.println("File created: "
                            + Obj.getName());
                }
                else {
                    System.out.println("File already exists.");
                }
            }
            catch (IOException e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
            }
        }

    }

}
