package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        List<Integer> bankAccounts = new ArrayList();
        int managerCount = Integer.parseInt(line.split("\\s+")[1]);
        while (in.hasNextLine()) {
            String currentLine = in.nextLine();
            if (currentLine.equals("")) {
                break;
            }
            bankAccounts.add(Integer.parseInt(currentLine));
        }

        if (bankAccounts
                .stream()
                .reduce(0, Integer::sum) < managerCount
        ) {
            System.out.println(0);
            return;
        }

        int minimumBonus = 1;
        while (managerCount < maxManagerWithMinumumBonus(bankAccounts, minimumBonus)) {
            minimumBonus++;
        }
        System.out.println(minimumBonus);
    }

    private static int maxManagerWithMinumumBonus(List<Integer> bankAccounts, int minimumBonus) {
        int managerCount = 0;
        for (Integer a : bankAccounts) {
            managerCount += a / minimumBonus;
        }
        return managerCount;
    }
}
