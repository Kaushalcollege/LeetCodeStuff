/**
 * @param {number} numBottles
 * @param {number} numExchange
 * @return {number}
 */
var numWaterBottles = function(numBottles, numExchange) {
    /*
        -- Given:
            -- numBottles are initially full of water.
            -- we can get i full water bottle if we exchange numExchange empty water bottles.
            -- the operation of drinking a full water bottle turns it into an empty water bottle.
            -- RTF:
            -- The maximum number of water bottle we can drink.
            -- Constraints:
            -- 1 <= numBottles <= 100
            -- 2 <= numExchange <= 100

            -- Initially let empty = numBottles.
            -- drank = numBottles.
            -- while (empty > numExchange){
                newBottles = empty / numExchange
                empty = empty % numExchange

                drank += newBottles
                empty = empty + newBottles
            }
            -- and then return drank.
    */

    let empty = numBottles;
    let drank = numBottles;

    while (empty >= numExchange) {
        let newBottles = Math.floor(empty / numExchange);
        empty %= numExchange;
        drank += newBottles;
        empty += newBottles;
    }

    return drank;
};