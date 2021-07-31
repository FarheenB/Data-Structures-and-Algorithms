/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
  public int maxProfit(int[] prices) {
    int sold = Integer.MIN_VALUE, inHand = Integer.MIN_VALUE, reset = 0;

    for (int priceToday : prices) {
      int lastSold = sold;

      sold = inHand + priceToday;
      inHand = Math.max(inHand, reset - priceToday);
      reset = Math.max(reset, lastSold);
    }
    return Math.max(sold, reset);
  }
}
