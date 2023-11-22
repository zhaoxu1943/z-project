# 快速幂算法计算

def binary_exp(num, power):
    res = 1
    while power != 0:
        if (power & 1 == 1):
            temp = num
            res = res * temp
            power = power >> 1
    return res


if __name__ == '__main__':
    a = 2
    n = 3
    print(binary_exp(a, n))
