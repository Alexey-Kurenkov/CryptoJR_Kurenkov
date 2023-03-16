package pro.kurenkov.javarush.crypto;

import pro.kurenkov.javarush.crypto.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();

    static {
        allKnownCommandsMap.put(Operation.SET_KEY, new SetKeyCommand());
        allKnownCommandsMap.put(Operation.ENCRYPT, new CeaserEncryptCommand());
        allKnownCommandsMap.put(Operation.DECRYPT, new CeaserDecryptCommand());
        allKnownCommandsMap.put(Operation.BRUTFORCE, new CeaserBrutforceCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
    }

    /**
     * запретим создание экземпляра
     */
    private CommandExecutor() {}

    /**
     * В зависимости от переданной операции вызываем execute нужного класса - маппин в allCommandsMap
     * @param operation
     * @throws Exception
     */
    public static void execute(Operation operation) throws Exception {
        allKnownCommandsMap.get(operation).execute();
    }
}