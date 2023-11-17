# 快速幂算法计算

def slow_pow(num, power):
    if (power & 1 == 1):
        power>>2

if __name__ == '__main__':
    a = 2
    n = 3
    print(slow_pow(a, n))
