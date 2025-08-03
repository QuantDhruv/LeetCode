class Solution:
    def maxTotalFruits(self, fruits, startPos, k):
        n = len(fruits)
        left = 0
        total = 0
        max_total = 0

        for right in range(n):
            total += fruits[right][1]

            # Shrink the window from the left if steps exceed k
            while left <= right:
                l_pos = fruits[left][0]
                r_pos = fruits[right][0]
                min_steps = min(
                    abs(startPos - l_pos) + (r_pos - l_pos),
                    abs(startPos - r_pos) + (r_pos - l_pos)
                )
                if min_steps <= k:
                    break
                total -= fruits[left][1]
                left += 1

            max_total = max(max_total, total)

        return max_total
