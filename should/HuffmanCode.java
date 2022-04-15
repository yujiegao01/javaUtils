package should;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanCode {
    static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();

    public static byte[] huffmanZip(byte[] arr) {
        ArrayList nodeList = byteToList(arr);

        Node huffmanNode = createHuffmanTree(nodeList);
        getHuffmanCode(huffmanNode, "", new StringBuilder());
        byte[] huffmanCodeByte = zip(arr);
        return huffmanCodeByte;
    }

    public static byte[] deHuffmanZip(byte[] arr) {
        String binStr = codeByteToBinStr(arr);
        byte[] assicByte = huffmanBinStrToAsicByte(binStr);
        return assicByte;

    }

    public static byte[] huffmanBinStrToAsicByte(String huffmanBinStr) {
        HashMap<String, Byte> reversCodeMap = new HashMap<String, Byte>();
        List<Byte> assicList = new ArrayList<>();
        for (Entry<Byte, String> e : huffmanCode.entrySet()) {
            reversCodeMap.put(e.getValue(), e.getKey());
        }
        for (int i = 0; i < huffmanBinStr.length();) {
            int j = i;
            while (true) {
                String str = huffmanBinStr.substring(i, ++j);
                Byte b = reversCodeMap.get(str);
                if (b != null) {
                    assicList.add(b);
                    i = j;
                    break;
                }

            }
        }
        byte arr[] = new byte[assicList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = assicList.get(i);
        }

        return arr;

    }

    public static String codeByteToBinStr(byte arr[]) {
        StringBuilder stringBuild = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            boolean flag = (i == arr.length - 1);
            String binStr = byteToBinStr(!flag, arr[i]);
            stringBuild.append(binStr);
        }
        return stringBuild.toString();
    }

    public static String byteToBinStr(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String strBin = Integer.toBinaryString(temp);
        if (flag) {
            return strBin.substring(strBin.length() - 8);
        } else {
            return strBin;
        }

    }

    public static byte[] zip(byte arr[]) {
        String binStr = byteToBinStr(arr);
        // System.out.println(binStr);
        int len = (binStr.length() + 7) / 8;
        byte[] huffmanCodeByte = new byte[len];
        int index = 0;
        String strByte;
        for (int i = 0; i < binStr.length(); i += 8) {
            if (i + 8 < binStr.length()) {
                strByte = binStr.substring(i, i + 8);
            } else {
                strByte = binStr.substring(i);
            }
            // System.out.print(strByte);
            huffmanCodeByte[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return huffmanCodeByte;
    }

    public static String byteToBinStr(byte[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : arr) {
            stringBuilder.append(huffmanCode.get(b));
        }

        return stringBuilder.toString();
    }

    public static void getHuffmanCode(Node node, String code, StringBuilder jointCode) {

        StringBuilder stringBuilder = new StringBuilder(jointCode);
        stringBuilder.append(code);
        if (node != null) {
            if (node.data != null) {
                huffmanCode.put(node.data, stringBuilder.toString());
            } else {
                getHuffmanCode(node.left, "0", stringBuilder);
                getHuffmanCode(node.right, "1", stringBuilder);
            }

        }

    }

    public static Node createHuffmanTree(ArrayList<Node> nodeList) {
        if (nodeList == null || nodeList.size() == 0) {
            return null;
        }
        while (nodeList.size() > 1) {
            Collections.sort(nodeList);
            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);
            Node parent = new Node(leftNode.value + rightNode.value, null);
            parent.left = leftNode;
            parent.right = rightNode;
            nodeList.add(parent);
            nodeList.remove(0);
            nodeList.remove(0);
        }
        return nodeList.get(0);
    }

    public static ArrayList<Node> byteToList(byte arr[]) {
        Map<Byte, Integer> map = countNum(arr);

        ArrayList<Node> nodeList = new ArrayList<Node>();
        for (Entry<Byte, Integer> entry : map.entrySet()) {

            nodeList.add(new Node(entry.getValue(), entry.getKey()));
        }

        return nodeList;

    }

    public static Map<Byte, Integer> countNum(byte[] arr) {
        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
        for (int i = 0; i < arr.length; i++) {
            Integer count = map.get(arr[i]);
            if (count == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], ++count);
            }
        }
        return map;
    }

    public static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }

    }

    public static void codeStrToAsicByte(HashMap<Byte, String> codeMap, byte[] b) {

    }
}

class Node implements Comparable<Node> {
    Integer value;
    Byte data;
    Node left;
    Node right;

    public Node(Integer value, Byte data) {
        this.value = value;
        this.data = data;
    }

    @Override
    public int compareTo(Node o) {

        return this.value - o.value;
    }
}
