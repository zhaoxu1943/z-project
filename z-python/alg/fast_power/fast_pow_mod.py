import time


# 快速幂应用之一: 快速幂取模
# num^power % mod的结果
# mod 性质 (3*3*3*3...) %p = [3%p*3%p*3%p*3%p*3%p*3%p.....] %p
def binary_exp_mod(num, power, mod):
    res = 1
    while power != 0:
        if power & 1 == 1:
            res = res * num
        num = (num * num) % mod
        power = power >> 1
    return res % mod


if __name__ == '__main__':
    a = 321
    n = 3212
    mod = 1232
    start_time = time.time()
    print(binary_exp_mod(a, n, mod))
    end_time = time.time()
    execution_time = end_time - start_time
    print("函数执行时间：", execution_time, "秒")

    result = (a ** n) % mod
    print("正确答案: ", result)
