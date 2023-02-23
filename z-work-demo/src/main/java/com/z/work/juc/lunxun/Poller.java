//package com.z.work.juc.lunxun;
//
//import java.util.Queue;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
///**
// *
// *
// 在这个示例代码中，Poller类使用ScheduledExecutorService创建定时器，并创建PollingTask来执行轮询任务。当获取到任务时，设置任务状态为“运行中”，并使用TaskExecutor来执行任务。任务执行完成后，将任务状态设置为“完成”，并从数据库或队列中移除。注意，在Poller类中，start()方法启动轮询任务，stop()方法停止轮询任务。
// *
// * @param
// * @return
// * @throws
// * @author zhaoxu
// */
//public class Poller {
//    private ScheduledExecutorService executorService;
//    private Database database;
//    private Queue queue;
//    private boolean isRunning;
//
//    public Poller(Database database, Queue queue) {
//        this.database = database;
//        this.queue = queue;
//        this.isRunning = false;
//    }
//
//    public void start() {
//        if (isRunning) {
//            throw new IllegalStateException("Poller is already running");
//        }
//        executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleAtFixedRate(new PollingTask(), 0, 10, TimeUnit.SECONDS);
//        isRunning = true;
//    }
//
//    public void stop() {
//        if (!isRunning) {
//            throw new IllegalStateException("Poller is not running");
//        }
//        executorService.shutdown();
//        isRunning = false;
//    }
//
//    private class PollingTask implements Runnable {
//        public void run() {
//            // Get tasks from database or queue
//            List<Task> tasks = database.getTasks();
//
//            for (Task task : tasks) {
//                if (task.getStatus() == Task.Status.RUNNING) {
//                    continue;
//                }
//
//                // Set task status to running
//                task.setStatus(Task.Status.RUNNING);
//
//                // Execute task
//                executorService.submit(new TaskExecutor(task));
//
//                // Remove task from database or queue
//                database.removeTask(task.getId());
//            }
//        }
//    }
//
//    private class TaskExecutor implements Runnable {
//        private Task task;
//
//        public TaskExecutor(Task task) {
//            this.task = task;
//        }
//
//        public void run() {
//            // Execute task
//            task.execute();
//
//            // Set task status to complete
//            task.setStatus(Task.Status.COMPLETE);
//        }
//    }
//}