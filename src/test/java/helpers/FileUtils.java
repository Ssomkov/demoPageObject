package helpers;

import java.io.*;

public class FileUtils {

    public static String readFile(String path) {
        StringBuffer buffer = null;
        try {
            BufferedReader in = getBufferedReaderForFile(path);
            String inputLine;
            buffer = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                buffer.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла");
        }
        return buffer.toString();
    }

    private static BufferedReader getBufferedReaderForFile(final String path) {
        InputStream in = null;
        try {
            in = new FileInputStream(path);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Не удалось прочитать файл-шаблон");
        }
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(in, "UTF8"));
        } catch (UnsupportedEncodingException e) {
        }
        return bf;
    }
}
