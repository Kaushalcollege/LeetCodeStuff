/**
 * @param {string[]} operations
 * @return {number}
 */
var finalValueAfterOperations = function(operations) {
    const dict = {
        "++X" : 1,
        "X++" : 1,
        "--X" : -1,
        "X--" : -1,
    };

    let total = 0;

    for (let op of operations){
        total += dict[op];
    }

    return total;
};