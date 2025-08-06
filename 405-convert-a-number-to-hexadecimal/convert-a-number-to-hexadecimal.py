class Solution:
    def toHex(self, num):
        if num == 0:
            return "0"

        hex_chars = "0123456789abcdef"
        result = []

        # Handle negative numbers with two's complement
        num &= 0xFFFFFFFF  # simulate 32-bit unsigned int

        while num > 0:
            digit = num % 16
            result.append(hex_chars[digit])
            num //= 16

        return ''.join(reversed(result))
