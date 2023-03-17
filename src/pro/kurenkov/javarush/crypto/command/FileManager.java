package pro.kurenkov.javarush.crypto.command;

import pro.kurenkov.javarush.crypto.crypto.CeaserCrypto;
import pro.kurenkov.javarush.crypto.crypto.Crypto;
import pro.kurenkov.javarush.crypto.exceptions.FileNotFoundException;

import javax.xml.transform.Source;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    static FileManager manager = null;
    final static String charsetWin1251 = "Windows-1251";
    private FileManager() {}
    public static FileManager getManager() {
        return manager == null ? manager = new FileManager() : manager;
    }

    public List<String> read(String file)  throws Exception {
        if (!Files.isRegularFile(Path.of(file)))
            throw new FileNotFoundException();

        List<String> buffer = new ArrayList<>();
        try(BufferedReader stream = new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetWin1251))) {
            while (stream.ready())
                buffer.add(stream.readLine());
        }
        return buffer;
    }
    public void write(String file, List<String> buffer)  throws Exception {
        try(BufferedWriter stream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charsetWin1251))) {
            for(String line: buffer) {
                stream.write(line);
                stream.newLine();
            }
        }
    }
}
