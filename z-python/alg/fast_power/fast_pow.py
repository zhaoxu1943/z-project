import time


# 快速幂算法计算


# step1 : to binary array
# eg:  3^13 转换为 3^(0b1101)
# 结合律: 3^(1*2^3) * 3^(1*2^2) * 3^(0*2^1) * 3^(1*2^0)
#        3^8 * 3^4 * 3^2*(假设存在) * 3*1
# 进一步的,找项之间的规律
# 当 &1 为0,res *1 即可,但仍需计算
# 当 &1 为1, res需要乘上,

# 以3^3举例 2 11
# 1次循环 需要计算3^(1*2^1) 3^1(num)

def binary_exp(num, power):
    res = 1
    while power != 0:
        if power & 1 == 1:
            res = res * num
        num = num * num
        power = power >> 1
    return res


if __name__ == '__main__':
    a = 3
    n = 150000
    start_time = time.time()
    print(binary_exp(a, n))
    end_time = time.time()
    execution_time = end_time - start_time
    print("函数执行时间：", execution_time, "秒")
