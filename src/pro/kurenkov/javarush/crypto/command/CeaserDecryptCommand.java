package pro.kurenkov.javarush.crypto.command;

import pro.kurenkov.javarush.crypto.ConsoleHelper;
import pro.kurenkov.javarush.crypto.CryptoSolution;
import pro.kurenkov.javarush.crypto.exceptions.FileNotFoundException;

import java.util.List;

public class CeaserDecryptCommand implements Command {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Начинаем дешифрацию файла шифром Цезаря.");
            FileManager manager = FileManager.getManager();

            ConsoleHelper.writeMessage("Введите полное имя исходного файла, который будем расшифровывать:");
            List<String> source = manager.read(ConsoleHelper.readString());

            ConsoleHelper.writeMessage("Введите полное имя файла который будет результатом дешифрации:");
            manager.write(ConsoleHelper.readString(), CryptoSolution.crypto.decrypt(source));

        } catch (FileNotFoundException e) {
            ConsoleHelper.writeMessage("Файл не найден.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
