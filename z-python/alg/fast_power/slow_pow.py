# 朴素算法计算a的N次方

def slow_pow(num, power):
    ans = 1
    for i in range(power):
        ans = ans * num
    return ans


if __name__ == '__main__':
    a = 3
    n = 13
    print(slow_pow(a, n))
