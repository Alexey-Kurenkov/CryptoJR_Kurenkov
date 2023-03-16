package pro.kurenkov.javarush.crypto.command;

import pro.kurenkov.javarush.crypto.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
