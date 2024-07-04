package test.leetcode2024;

/**
 * 取整购买后的账户余额
 */
public class AccountBalanceAfterPurchase {
    public static void main(String[] args) {

    }

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int totalAmount = 100;
        int i = purchaseAmount / 10;
        int j = purchaseAmount % 10;
        if(j>=5){
            i++;
        }
        return totalAmount-i*10;
    }
}
