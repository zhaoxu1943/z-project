package com.z.learn.reactive.base;

/**
 * currently,there is no standard unified reactive API implementation in Java
 *
 * From RxJava 1and 2 ,or Spring reactive
 *
 * all these framework are based on the same design pattern,
 *
 *
 * PUB:
 *
 * Mono is producer or publisher that produce no data
 *
 * Mono is also a pub that produce at most a single data item
 *
 * FLux: a pub that produce multiple data items
 *
 * SUB:
 *
 * subscriber : call in both RxJava and Project Reactor
 *
 * the sub has three data channels
 * each channel is signed through one of the sub internal methods
 *
 *
 *
 *
 *
 * @author zhaoxu
 * @date 11/15/2022 12:03 PM
 * @since
 */
public interface JavaReactive {
}
