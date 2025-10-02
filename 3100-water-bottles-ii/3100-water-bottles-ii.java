class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        /*
            -- Previously on Water Bottles 1, it was really simple.
            -- This is also very very simple.
            -- previously, we did:
            -- Initially let empty = numBottles.
            -- drank = numBottles.
            -- while (empty > numExchange){
                newBottles = empty / numExchange
                empty = empty % numExchange

                drank += newBottles
                empty = empty + newBottles
            }
            -- and then return drank.

            -- But now in the question, it is clearly mentioned that:
            -- Cannot exchange multiple batches of empty bottles for the same value of numExchange.
            -- For example, if numBottles == 3 and numExchange == 1, you cannot exchange 3 empty water bottles for 3 full bottles.
            -- We can only Exchange numExchange empty bottles with one full water bottle. Then, increase numExchange by one.
            -- Also, a very interesting point to note is that we can drink or exchange in one iteration.
            -- This now becomes a very interesting problem.
            -- How to decide when to append drank variable? and when to exchange?
            -- What is the condition that will help decide that in every iteration?
            -- The idea here will change just a bit:
            -- Initially, let empty = numBottles.
            -- drank = newBottles.
            -- newBottles = numBottles.
            -- while (empty >= numExchange){
                empty -= numExchange;   // spend them
                numExchange++;          // cost increases
                drank++;                // drink the new bottle
                empty++;                // gain one empty back
            }

            -- return drank.
        */

        int drank = numBottles;    // initially drink all bottles
        int empty = numBottles;    // all become empty

        while (empty >= numExchange) {
            // exchange exactly numExchange empties for 1 new bottle
            empty -= numExchange;   // spend them
            numExchange++;          // cost increases
            drank++;                // drink the new bottle
            empty++;                // gain one empty back
        }

        return drank;
    }
}