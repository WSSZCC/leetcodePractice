package test.leetcode2024;

import test.entry.Employee;

import java.util.*;

/**
 *  员工的重要性
 */
public class GetImportance {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1, 3, Arrays.asList(2, 3)));
        list.add(new Employee(2, 3, Collections.emptyList()));
        list.add(new Employee(3, 3, Collections.emptyList()));
        getImportance(list, 1);
    }

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.add(id);
        int totalImportance = 0;
        while (!queue.isEmpty()) {
            Integer key = queue.poll();
            Employee employee = map.get(key);
            totalImportance += employee.importance;
            if (!employee.subordinates.isEmpty()) {
                queue.addAll(employee.subordinates);
            }

        }
        return totalImportance;
    }
}
