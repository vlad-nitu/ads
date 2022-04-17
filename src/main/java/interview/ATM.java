package interview;

import java.util.Arrays;

class ATM {
    /* Biweekly contest 76 LeetCode
    https://leetcode.com/problems/design-an-atm-machine/
    OBS:  Long used, even though 0 <= banknotesCount[i] <= 10^9, 'deposit' may be called several times (i.e: 3) and then exceed Integer.MAX_VALUE
     */
    long[] banknotes;

    public ATM() {
        this.banknotes = new long[5];
    }

    public void deposit(int[] banknotesCount) {

        for (int i = 0; i < 5; ++i) {
            this.banknotes[i] += banknotesCount[i];
        }

        return;
    }

    public int[] withdraw(int amount) {
        long[] result = new long[5];
        int i = 4;


        while (i >= 0) {
            if (amount == 0) return Arrays.stream(result).mapToInt(integer -> (int) integer).toArray();

            if (this.banknotes[i] == 0 || price(i) > amount) i--;
            else if (price(i) <= amount) {
                long f = Math.min(amount / price(i), banknotes[i]);
                amount -= f * price(i);
                this.banknotes[i] -= f;
                result[i] += f;
            }
        }


        this.deposit(Arrays.stream(result).mapToInt(integer -> (int) integer).toArray());
        return new int[]{-1}; // impossible
    }

    public static int price(int index) {

        switch (index) {
            case 0:
                return 20;

            case 1:
                return 50;

            case 2:
                return 100;

            case 3:
                return 200;

            default:
                return 500;

        }


    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */