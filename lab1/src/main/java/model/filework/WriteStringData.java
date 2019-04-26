package model.filework;

import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Formatter;
import java.util.Locale;

public class WriteStringData {

    private final static Logger LOGGER = Logger.getLogger(WriteStringData.class);

    public void writeData(String str) {
        try(FileOutputStream fos = new FileOutputStream("src/main/files/"
                + getFileName() + ".txt")){
            byte[] arr = str.getBytes();
            fos.write(arr);
            LOGGER.info("Data successfully write to file");
        } catch (IOException e) {
            LOGGER.info("impossible write data to file", e);
            e.printStackTrace();
        }
    }

    private String getFileName() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        DateTimeFormatter timeFormatter = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.MEDIUM)
                .withLocale(Locale.getDefault());
        String text1 = date.format(dateFormatter);
        String text2 = time.format(timeFormatter);
        return text1 + " " + text2.replaceAll(":", " ");
    }

}
