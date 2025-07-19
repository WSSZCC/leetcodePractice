package test.leetcode2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 删除子文件夹
 */
public class RemoveSubfolders {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();
        String str = null;
        for (String s : folder) {
            if(str==null){
                str = s;
                list.add(s);
                continue;
            }
            if(!s.startsWith(str+"/")){
                str = s;
                list.add(s);
            }

        }
        return list;
    }
}
