class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int roundedAmount;

        if(purchaseAmount % 10 >= 5) {
            roundedAmount = (1 + purchaseAmount/10) * 10;
        }else {
            roundedAmount = (purchaseAmount/10) * 10;
        }


        return 100 - roundedAmount;
    }
}