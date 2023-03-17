package pro.kurenkov.javarush.crypto.crypto;

import java.util.ArrayList;
import java.util.List;

public class CeaserCrypto implements Crypto {
    final private static String dictStr = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ."+String.valueOf('"')+",:-!? ";
    final private static char[] dictArr = dictStr.toCharArray();
    private long key;

    @Override
    public List<String> encrypt(List<String> source, long key) {
        List<String> target = new ArrayList<>();
        for(String line: source) {
            char[] lineArr = line.toCharArray();
            StringBuilder sb = new StringBuilder();
            labLine:
            for (int l = 0; l < lineArr.length; l++) {
                char cl = lineArr[l];
                for (int d = 0; d < dictArr.length; d++) {
                    char oldChar = dictArr[d];
                    char newChar = dictArr[(int) (d + key) % dictArr.length];
                    if (cl == oldChar) {
                        sb.append(newChar);
                        continue labLine;
                    }
                }
                sb.append(cl);
            }
            target.add(sb.toString());
        }
        return target;
    }

    @Override
    public List<String> decrypt(List<String> source, long key) {
        List<String> target = new ArrayList<>();
        for(String line: source) {
            char[] lineArr = line.toCharArray();
            StringBuilder sb = new StringBuilder();
            labLine:
            for (int l = 0; l < lineArr.length; l++) {
                char cl = lineArr[l];
                for (int d = 0; d < dictArr.length; d++) {
                    char oldChar = dictArr[d];
                    char newChar = dictArr[(int) (d + dictArr.length - key) % dictArr.length];
                    if (cl == oldChar) {
                        sb.append(newChar);
                        continue labLine;
                    }
                }
                sb.append(cl);
            }
            target.add(sb.toString());
        }
        return target;
    }

    @Override
    public long brutforce(List<String> source, List<String> words) {
        return key;
    }
    @Override
    public long getKey() {
        return key;
    }
    @Override
    public void setKey(long key) {
        this.key = key;
    }
    public long getDictLen() {
        return dictArr.length;
    }
}
