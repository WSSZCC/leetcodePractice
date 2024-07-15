package test.leetcode2024;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 账户合并
 */
public class AccountsMerge {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("David", "David4@m.co", "David2@m.co", "David4@m.co");
        List<String> list1 = Arrays.asList("John", "John7@m.co", "John5@m.co", "John3@m.co");
        List<String> list2 = Arrays.asList("Fern", "Fern6@m.co", "Fern4@m.co", "Fern5@m.co");
        List<String> list3 = Arrays.asList("Celine", "Celine0@m.co", "Celine7@m.co", "Celine7@m.co");
        List<String> list4 = Arrays.asList("Gabe", "Gabe8@m.co", "Gabe8@m.co", "Gabe1@m.co");
        List<String> list5 = Arrays.asList("Ethan", "Ethan1@m.co", "Ethan6@m.co", "Ethan6@m.co");
        List<String> list6 = Arrays.asList("Celine", "Celine4@m.co", "Celine8@m.co", "Celine6@m.co");
        List<String> list7 = Arrays.asList("Celine", "Celine0@m.co", "Celine0@m.co", "Celine4@m.co");
        List<List<String>> lists = Arrays.asList(list, list1, list2, list3);
        accountsMerge(lists);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Set<Integer> indexSet = new HashSet<>();
        List<List<String>> accountsLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!indexSet.contains(i)) {
                String s = accounts.get(i).get(0);
                Set<String> accountsSet = new HashSet<>(accounts.get(i));
                for (int j = i + 1; j < n; j++) {
                    if (!indexSet.contains(j)) {
                        List<String> account = accounts.get(j);
                        if (!accountsSet.contains(account.get(0))) {
                            break;
                        }
                        for (int k = 1; k < account.size(); k++) {
                            if (accountsSet.contains(account.get(k))) {
                                accountsSet.addAll(account);
                                indexSet.add(j);
                                break;
                            }
                        }
                    }
                }
                List<String> accountsList = new ArrayList<>();
                accountsList.add(s);
                if (!accountsLists.isEmpty()) {
                    List<Integer> deleteIndex = new ArrayList<>();
                    for (int k = 0; k < accountsLists.size(); k++) {
                        List<String> list = accountsLists.get(k);
                        if (accountsSet.contains(list.get(0))) {
                            for (int m = 1; m < list.size(); m++) {
                                if (accountsSet.contains(list.get(m))) {
                                    accountsSet.addAll(list);
                                    deleteIndex.add(k);
                                    break;
                                }
                            }
                        }
                    }
                    int flag = 0;
                    for (Integer index : deleteIndex) {
                        accountsLists.remove(index - flag);
                        flag++;
                    }
                }
                accountsSet.remove(accountsList.get(0));
                accountsList.addAll(accountsSet.stream().sorted().collect(Collectors.toList()));
                accountsLists.add(accountsList);
            }
        }
        return accountsLists;
    }
}
