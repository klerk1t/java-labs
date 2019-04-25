package model.filework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Formatter;

public class WriteStringData {

    public void writeData(String str) {
        try(FileOutputStream fos = new FileOutputStream("files/"
                + getFileName() + ".txt")){
            byte[] arr = str.getBytes();
            fos.write(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileName() {

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String text = date.format(formatter);
        //LocalDate parsedDate = LocalDate.parse(text, formatter);
        return text;
    }

}
