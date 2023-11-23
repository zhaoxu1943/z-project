import time
# 朴素算法计算a的N次方

def slow_pow(num, power):
    ans = 1
    for i in range(power):
        ans = ans * num
    return ans


if __name__ == '__main__':
    a = 3
    n = 150000
    start_time = time.time()
    print(slow_pow(a, n))
    end_time = time.time()
    execution_time = end_time - start_time
    print("函数执行时间：", execution_time, "秒")
