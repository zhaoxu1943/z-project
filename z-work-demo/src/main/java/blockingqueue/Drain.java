package blockingqueue;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import entity.Student;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Drain {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Student> linkedBlockingDeque = new LinkedBlockingDeque<>();
        linkedBlockingDeque.putFirst(new Student().setName("1").setId("1"));
        linkedBlockingDeque.putFirst(new Student().setName("2").setId("2"));
        linkedBlockingDeque.putFirst(new Student().setName("3").setId("3"));
        linkedBlockingDeque.putFirst(new Student().setName("5").setId("5"));
        linkedBlockingDeque.putFirst(new Student().setName("6").setId("6"));

        System.out.println("原始阻塞双端队列");
        System.out.println(linkedBlockingDeque);
        int i=1;

        System.out.println("开始循环");

        Student test =linkedBlockingDeque.take();

        while (test!=null){
            List<Student> students = Lists.newArrayList();
            System.out.println("第"+(i++)+"次循环,开始消费");
            Queues.drain(linkedBlockingDeque,students,2,1, TimeUnit.SECONDS);

            Thread.sleep(2000);
            System.out.println("消费后目标集合");
            System.out.println(students);
            System.out.println("消费后阻塞双端队列");
            System.out.println(linkedBlockingDeque);


            List<Student> newList =  students.stream().map(student -> {
                System.out.println("处理逻辑");
                return new Student().setId("处理");
            }).collect(Collectors.toList());

            System.out.println(newList);


        }


    }
}
