package should;

import java.util.Arrays;
import java.util.Map.Entry;

import org.junit.Test;

public class TestShould {
    @Test
    public void test3() {
        String s1 = "BBC ABCDAB ABCDABCDABDE";
        String s2 = "ABCDABD";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(Arrays.toString(Kmp.kmpNext(s2)));
        System.out.println(Kmp.kmp(s1, s2));
    }

    @Test
    public void test2() {
        Horse horse = new Horse();
        horse.horse(0, 0);
        for (int i = 0; i < horse.bz.size(); i++) {
            System.out.println(horse.bz.get(i));
        }
    }

    @Test
    public void test1() {

        String str = "i like like like java do you like a java i";
        byte[] arr = HuffmanCode.huffmanZip(str.getBytes());
        byte[] dearr = HuffmanCode.deHuffmanZip(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(new String(dearr));

    }

}
