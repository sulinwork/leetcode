
```java
class Solution {
    public int divide(int dividend, int divisor) {
        return mod(dividend, divisor);
    }

    int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;        // 0+1 加和
            b = (a & b) << 1;   // 进位(符号位移除不计)
            a = sum;
        }
        return sum;
    }

    int negative(int a) {
        return add(~a, 1);
    }

    int minus(int a, int b) {
        return add(a, negative(b));
    }

    int abs(int a) {
        return a < 0 ? negative(a) : a;
    }

    int mul(int a, int b) {
        int ret = 0;
        while (b != 0) {
            if ((b & 1) != 0)
                ret = add(ret, a);
            a <<= 1;    // 算术左移 低位补0
            b >>>= 1;   // >>>无符号右移(逻辑)
        }
        return ret;
    }

    int divid(int a, int b) {
        if (b == 0)
            throw new RuntimeException();
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (a == Integer.MIN_VALUE) {
            if (b == -1)
                return Integer.MAX_VALUE;
            if (b == 1)
                return Integer.MIN_VALUE;
            int res = div(add(a, 1), b);    // res = a+1 / b
            return add(res, div(minus(a, mul(res, b)), b));
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else {
            return div(a, b);
        }
    }

    boolean isNeg(int a) {
        return a < 0;
    }

    int div(int a, int b) {
        int x = abs(a);
        int y = abs(b);
        int ret = 0;
        for (int i = 31; i >= 0; --i) {
            if ((x >> i) >= y) {
                ret |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return (isNeg(a) ^ isNeg(b)) ? negative(ret) : ret;
    }

    // b对2的整数倍
    int mod2(int a, int b) {
        return a & (b - 1);
    }

    int mod(int a, int b) {
        int res = div(a, b);
        return minus(a, mul(res, b));
    }
}
```