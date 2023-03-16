package pro.kurenkov.javarush.crypto;

import pro.kurenkov.javarush.crypto.crypto.CeaserCrypto;
import pro.kurenkov.javarush.crypto.crypto.Crypto;

import java.io.IOException;

public class CryptoSolution {
    public static Crypto crypto = new CeaserCrypto();
    public static void main(String[] args) {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка. Проверьте введенные данные.");
            } catch (Exception e) {
                continue;
            }
        } while (operation != Operation.EXIT);
    }

    private static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(String.format("\t %d - ввести ключ", Operation.SET_KEY.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - зашифровать файл", Operation.ENCRYPT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - расшифровать файл", Operation.DECRYPT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - брутфорс", Operation.BRUTFORCE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - выход", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }
}
