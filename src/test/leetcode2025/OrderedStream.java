package test.leetcode2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 设计有序流
 */
public class OrderedStream {
    String[] strings;
    int total;
    int flag;
    public OrderedStream(int n) {
        flag = 0;
        total = n;
        strings = new String[n];
        Arrays.fill(strings,"");
    }

    public List<String> insert(int idKey, String value) {
        strings[idKey] = value;
        List<String>  list = new ArrayList<>();
        if(idKey==flag){
            for (int i = flag; i < total; i++) {
                if(Objects.equals(strings[i], "")){
                    flag = i;
                }
                list.add(strings[i]);
            }
        }
        return list;
    }
}
