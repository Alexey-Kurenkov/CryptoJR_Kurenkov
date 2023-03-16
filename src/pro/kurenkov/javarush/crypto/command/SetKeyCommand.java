package pro.kurenkov.javarush.crypto.command;

import pro.kurenkov.javarush.crypto.ConsoleHelper;
import pro.kurenkov.javarush.crypto.CryptoSolution;
import pro.kurenkov.javarush.crypto.exceptions.FileNotFoundException;

import java.io.IOException;
import java.nio.file.Path;

public class SetKeyCommand  implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Изменяем ключ шифрования.");

        long key = 0;
        while (true)
            try {
                ConsoleHelper.writeMessage(String.format("Введите натуральное число - новый ключ шифрования (текущий ключ - %d):", CryptoSolution.crypto.getKey()));
                key = ConsoleHelper.readInt();
                break;
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Ошибка, введено не целое число.");
            }

        CryptoSolution.crypto.setKey(key);
        ConsoleHelper.writeMessage("Ключ шифрования изменен.");
    }
}
