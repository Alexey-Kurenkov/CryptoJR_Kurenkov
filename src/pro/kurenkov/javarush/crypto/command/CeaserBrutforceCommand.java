package pro.kurenkov.javarush.crypto.command;

import pro.kurenkov.javarush.crypto.ConsoleHelper;
import pro.kurenkov.javarush.crypto.CryptoSolution;
import pro.kurenkov.javarush.crypto.crypto.Crypto;
import pro.kurenkov.javarush.crypto.exceptions.FileNotFoundException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CeaserBrutforceCommand implements Command {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Начинаем brut force шифрованного файла шифром Цезаря.");
            ConsoleHelper.writeMessage("");
            FileManager manager = FileManager.getManager();

            ConsoleHelper.writeMessage("Введите полное имя исходного файла, который будем пытаться дешифровать:");
            List<String> source = manager.read(ConsoleHelper.readString());
            Crypto crypto = CryptoSolution.crypto;

            ConsoleHelper.writeMessage("Что бы проверить результат дешифрации необходимо понимать что мы ищем.");
            ConsoleHelper.writeMessage("Введите через пробел ряд слов которые будем искать в дешифрованном тексте:");
            List<String> words = List.of(ConsoleHelper.readString().toLowerCase().split(" "));
            Map<Long, Long> keyCount = new HashMap<>();

            for (long key = 0; key < crypto.getDictLen(); key++) {
                List<String>targetLines = crypto.decrypt(source, key); // получим файл в List<String> после дешифрации
                long count = checkWordsTarget(targetLines, words); // получим количество совпадений слов
                if (count > 0)
                    keyCount.put(key, count);
            }

            if (keyCount.isEmpty())
                ConsoleHelper.writeMessage("Brutforce не нашел совпадений. Попробуйте с другими словами снова.");
            else {
                ConsoleHelper.writeMessage("Brutforce подобрал следующие возможные ключи:");
                ConsoleHelper.writeMessage("");
                ConsoleHelper.writeMessage("\tКлюч\tКолич.совпадений");
                keyCount.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .forEach(map -> System.out.println(String.format("\t%d\t\t%d", map.getKey(), map.getValue())));
            }
        } catch (FileNotFoundException e) {
            ConsoleHelper.writeMessage("Файл не найден.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Считаем сколько какое слово words.get встречается раз в targetLines и количество для каждого слова кладём в мапу
     * @param lines
     * @param words
     * @return
     */
    private long checkWordsTarget(List<String> lines, List<String> words) {
        long count = 0;
        StringBuilder sb = new StringBuilder();
        for (String line: lines)
            sb.append(line.toLowerCase()
                            .replace(",", " ")
                            .replace(".", " ")
                            .replace(":", " ")
                            .replace("-", " ")
                            .replace("!", " ")
                            .replace("?", " ")
                            .replace(String.valueOf('"'), " ")
                    ).append(" ");
        List<String> lineWords = List.of(sb.toString().split(" "));

        for (String word: words)
            for (String lineWord: lineWords)
                if (word.equals(lineWord))
                    count++;

        return count;
    }
}
