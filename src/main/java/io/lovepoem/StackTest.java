package io.lovepoem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);//入栈

        System.out.println(stack.isEmpty());//false

        stack.pop();//出栈
        System.out.println(stack.isEmpty());//true

        stack.push(1);//入栈     int 类型
        stack.push(2l);//入栈     Long类型
        stack.push(3.0);//入栈   double类型
        System.out.println("栈中有： " + stack.size() + " 个元素 。");//栈中有： 3 个元素 。

        //栈中可以存放任何类型
        Person p = new Person("xiaoming", 20);
        stack.push(p); //入栈  引用对象
        System.out.println("栈中有： " + stack.size() + " 个元素 。");//栈中有： 3 个元素 。
        //System.out.println(stack.get(4)); java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 4

        System.out.println(stack.get(3)); // main.java.io.lovepoem.Person [name=xiaoming, age=20]
        System.out.println(stack.peek()); // main.java.io.lovepoem.Person [name=xiaoming, age=20] 取栈顶值（不出栈）

        System.out.println(stack.contains(2));//false
        System.out.println(stack.contains(2l));//true

        stack.add(2, p); //入栈
        System.out.println(stack.get(2));//main.java.io.lovepoem.Person [name=xiaoming, age=20]
        System.out.println(stack.size());

        System.out.println(stack.capacity());// 10

        System.out.println(stack.empty());//false 判空
        System.out.println("栈中有： " + stack.size() + " 个元素 。");//栈中有： 5 个元素 。

        Stack stack1 = (Stack) stack.clone();//克隆一个栈结构
        System.out.println("克隆的stack1栈中有： " + stack.size() + " 个元素 。");//克隆的stack1栈中有： 5 个元素 。
        System.out.println(stack.equals(stack1));//true

        stack.push("你好");
        System.out.println(stack.equals(stack1));//false

        System.out.println(stack.elements().toString());//java.util.Vector$1@7852e922

        System.out.println("p元素的下标是：" + stack.indexOf(p));//p元素的下标是：2

        //stack.forEach();

        System.out.println(stack.firstElement());//获取栈底元素
        System.out.println(stack.lastElement());//获取栈顶元素

        //stack.insertElementAt(1, "hh");
        //stack.notify();有关线程的操作      Exception in thread "main" java.lang.IllegalMonitorStateException

        System.out.println("删除之前有" + stack.size() + "个元素"); //删除之前有6个元素
        stack.remove(3);//删除一个元素
        System.out.println("删除一个元素有" + stack.size() + "个元素");//删除之前有5个元素

        System.out.println("之前stack1中有" + stack1.size() + "个元素");
        //stack.removeAll(stack1);
        stack1.removeAll(stack1);  //之前stack1中有5个元素     奇怪的用法！！！！！
        System.out.println("removeAll之后，stack1中有" + stack1.size() + "个元素");//removeAll之后，stack1中有0个元素

        System.out.println("改变之前，下表为2的元素值为：" + stack.get(2));//改变之前，下表为2的元素值为：main.java.io.lovepoem.Person [name=xiaoming, age=20]
        stack.set(2, "改变下标为2的元素");
        System.out.println("改变之后，下表为2的元素值为：" + stack.get(2));//改变之后，下表为2的元素值为：改变下标为2的元素

        Object[] stackList = stack.toArray();
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stackList[i] + ",");
        }
        //1,2,改变下标为2的元素,main.java.io.lovepoem.Person [name=xiaoming, age=20],你好,
List aa = new ArrayList();

    }

}
