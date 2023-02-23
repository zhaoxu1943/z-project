//package com.z.work.pipeline;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public interface Handler {
//    void handle(Request request, HandlerChain chain);
//}
//
//public class Request {
//    private String data;
//
//    public Request(String data) {
//        this.data = data;
//    }
//
//    public String getData() {
//        return data;
//    }
//}
//
//public class DefaultHandlerChain implements HandlerChain {
//    private List<Handler> handlers = new ArrayList<>();
//    private int index = 0;
//
//    public void addHandler(Handler handler) {
//        handlers.add(handler);
//    }
//
//    public void removeHandler(Handler handler) {
//        handlers.remove(handler);
//    }
//
//    @Override
//    public void doHandle(Request request) {
//        if (index == handlers.size()) {
//            return;
//        }
//        Handler handler = handlers.get(index);
//        index++;
//        handler.handle(request, this);
//    }
//}
//
//public class ExampleHandler implements Handler {
//    @Override
//    public void handle(Request request, HandlerChain chain) {
//        // 处理请求
//        String data = request.getData();
//        System.out.println("ExampleHandler: handling request with data " + data);
//
//        // 调用下一个处理器
//        chain.doHandle(request);
//    }
//}
//
//// HandlerChain 接口
//public interface HandlerChain {
//    void doHandle(Request request);
//}
//
//// 可编排责任链
//public class ConfigurableHandlerChain implements HandlerChain {
//    private List<Handler> handlers = new ArrayList<>();
//
//    public void addHandler(Handler handler) {
//        handlers.add(handler);
//    }
//
//    public void removeHandler(Handler handler) {
//        handlers.remove(handler);
//    }
//
//    public void configure(List<String> handlerNames) {
//        // 根据 handlerNames 配置处理器顺序
//        // ...
//
//        // 根据配置构建责任链
//        handlers.clear();
//        for (String name : handlerNames) {
//            // 根据名称创建处理器
//            Handler handler = createHandler(name);
//            handlers.add(handler);
//        }
//    }
//
//    private Handler createHandler(String name) {
//        // 根据名称创建处理器
//        // ...
//
//        return new ExampleHandler();
//    }
//
//    @Override
//    public void doHandle(Request request) {
//        DefaultHandlerChain chain = new DefaultHandlerChain();
//        for (Handler handler : handlers) {
//            chain.addHandler(handler);
//        }
//        chain.doHandle(request);
//    }
//}
//
//// 使用示例
//public class Example {
//    public static void main(String[] args) {
//        // 创建可编排责任链
//        ConfigurableHandlerChain chain = new ConfigurableHandlerChain();
//        chain.addHandler(new ExampleHandler());
//
//        // 配置责任链
//        List<String> handlerNames = new ArrayList<>();
//        handlerNames.add("handler1");
//        handlerNames.add("handler2");
//        chain.configure(handlerNames);
//
//        // 使用责任链处理请求
//        Request request = new Request("example");
//        chain.doHandle(request);
//    }
//}