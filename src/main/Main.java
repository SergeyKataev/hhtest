package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        List<Integer> cash = new ArrayList();
        int n = Integer.parseInt(line.split("\\s+")[0]);
        int m = Integer.parseInt(line.split("\\s+")[1]);
        while (in.hasNextLine()) {
            String current = in.nextLine();
            if (current.equals("")) {
                break;
            }
            cash.add(Integer.parseInt(current));
        }

        if (cash.stream()
                .reduce(0, Integer::sum) <m) {
            System.out.println(0);
            return;
        };

        int min = 1;
        while (m < countMaxEmpSalary(cash, min)) {
            min++;
        }
        System.out.println(min);


    }

    private static int countMaxEmpSalary(List<Integer> cash, int minValue) {
        int count = 0;
        for (Integer a: cash) {
            count+= a / minValue;
        }
        return  count;
    }
}
