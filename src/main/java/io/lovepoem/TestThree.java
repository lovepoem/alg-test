package io.lovepoem;

public class TestThree {
    public int myAtoi(String str) {
        int base = 0;
        int sign = 1;
        if (str == null) {
            return 0;
        }
        int index = 0;
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index++) == '-' ? -1 : 1;
        }
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(index++) - '0');
        }
        return base * sign;
    }



    public static void main(String[] args) {
        System.out.println(new TestThree().myAtoi("-987"));
    }



}
