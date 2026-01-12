/**
 * @param {number[][]} points
 * @return {number}
 */
var minTimeToVisitAllPoints = function(p) {
    let min = 0;
    for (let i = 0; i < p.length - 1; i++) {
        let x = p[i][0]
        let y = p[i][1]
        let X = p[i + 1][0]
        let Y = p[i + 1][1]

        min += Math.max(Math.abs(X - x), Math.
        abs(Y - y));
    }
    return min;
};