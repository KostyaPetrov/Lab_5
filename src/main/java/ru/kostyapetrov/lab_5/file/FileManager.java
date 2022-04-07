package file;

import collection.Product;
import console.ConsoleManager;
import java.io.*;
import java.util.LinkedList;
public class FileManager {
    public void fileWrite(LinkedList<Product> collection){
        ConsoleManager consoleManager = new ConsoleManager();
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(consoleManager.getNameFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        try {
            outputStreamWriter.write(collection+"\n");
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public LinkedList<Product> fileRead(String path) throws IOException{
        String fileData="";
        FileInputStream fileInputStream = new FileInputStream(path);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);

        int i;

        while((i = bufferedInputStream.read())!= -1){
            fileData = fileData + (char) i;

        }

        LinkedList<Product> fileCollection = new LinkedList<>();//TODO

        if (fileData!="") {
            if (fileData.indexOf(",")!=-1){
                String[] arrStr;
                String delimeter = ",";
                arrStr = fileData.split(delimeter);
                for (int k = 0; i < arrStr.length+1; i++) {
                    fileCollection.add(arrStr[i]);
                }
            }else{
                fileCollection.add(fileData);
            }

        }
        return fileCollection;
    }
}
