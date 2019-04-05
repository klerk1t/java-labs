package model.filework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class WriteStringData {

    public void writeData(String str) {
        try(FileOutputStream fos = new FileOutputStream("res/" + str.hashCode() + ".txt")){
            byte[] arr = str.getBytes();
            fos.write(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
