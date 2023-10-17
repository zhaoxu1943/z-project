# coding: UTF-8


def run():
    try:
        raise_exception()
    except Exception as e:
        # 将异常信息输出到日志
        print("run 异常")
        # 抛出
        # raise


def raise_exception():
    raise ValueError("This is a sample exception.")


if __name__ == '__main__':
    try:
        run()
    except Exception as e:
        # 将异常信息输出到日志
        print("main 异常")
