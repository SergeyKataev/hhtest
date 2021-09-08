package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int[] bankAccounts = new int[Integer.parseInt(line.split("\\s+")[0])];
        int managerCount = Integer.parseInt(line.split("\\s+")[1]);
        int i = 0;
        while (in.hasNextLine()) {
            String currentLine = in.nextLine();
            if (currentLine.equals("")) {
                break;
            }
            bankAccounts[i] = Integer.parseInt(currentLine);
            i++;
        }

        int sum = 0;
        for (int value : bankAccounts) {
            sum += value;
        }

        if (sum < managerCount) {
            System.out.println(0);
            return;
        }

        int minimumBonus = 1;

        if (managerCount == 1) {
            int ret = bankAccounts[0];
            for(int k = 1; k < bankAccounts.length; k++)
                ret = Math.max(ret,bankAccounts[k]);
            System.out.println(ret);
            return;
        }

        while (managerCount <= maxManagerWithMinumumBonus(bankAccounts, minimumBonus)) {
            minimumBonus++;
        }
        System.out.println(minimumBonus - 1);
    }

    private static int maxManagerWithMinumumBonus(int[] bankAccounts, int minimumBonus) {
        int managerCount = 0;
        for (var accountSum : bankAccounts) {
            managerCount += accountSum / minimumBonus;
        }
        return managerCount;
    }
}
