package pro.kurenkov.javarush.crypto.crypto;

import java.util.List;

public interface Crypto {
    List<String> encrypt(List<String> source, long key);
        List<String> decrypt(List<String> source, long key);
    long brutforce(List<String> source);
    long getKey();
    void setKey(long key);
    default List<String> encrypt(List<String> source) {
        return encrypt(source, getKey());
    };
    default List<String> decrypt(List<String> source) {
        return decrypt(source, getKey());
    };
}
