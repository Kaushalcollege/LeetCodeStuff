class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        if hour == 12 : hour = 0

        ratio = minutes / 60
        actual_hour = 30 * (hour + ratio)
        res = abs((6 * minutes) - actual_hour)

        if res <= 180 : return res

        return 360 - res