from collections import Counter

class Solution:
    def minCost(self, basket1, basket2):
        freq1 = Counter(basket1)
        freq2 = Counter(basket2)

        total = Counter(basket1 + basket2)
        for val in total:
            if total[val] % 2 != 0:
                return -1  # Cannot make baskets equal

        min_val = min(min(basket1), min(basket2))

        excess1 = []
        excess2 = []

        for val in total:
            diff = freq1[val] - total[val] // 2
            if diff > 0:
                excess1.extend([val] * diff)
            elif diff < 0:
                excess2.extend([val] * (-diff))

        excess1.sort()
        excess2.sort(reverse=True)

        swaps = len(excess1)
        cost = 0
        for i in range(swaps):
            a = excess1[i]
            b = excess2[i]
            cost += min(2 * min_val, min(a, b))
        return cost
