package test.ttt;


import java.util.ArrayList;

public class MainRedList {
    public static void main(String[] args) {
        //实例化对象
        Manager manager = new Manager("群主",100);
        Member one = new Member("A",0);
        Member two = new Member("B",0);
        Member three = new Member("C",0);
        //初始化赋值
        //manager.setMoney(100);
        //manager.setName("群主");
        //manager.Manager(100,"群主");

        System.out.println("我是：" + manager.getName() + ",余额：" + manager.getMoney() );
        //one.setMoney(0);
        //one.setName("A");
        System.out.println("我是：" + one.getName() + ",余额：" + one.getMoney() );
        //two.setMoney(0);
        //two.setName("B");
        System.out.println("我是：" + two.getName() + ",余额：" + two.getMoney() );
        //three.setMoney(0);
        //three.setName("C");
        System.out.println("我是：" + three.getName() + ",余额：" + three.getMoney() );
        System.out.println("=========================");

        //new一个集合接收传递过来的redList
        ArrayList<Integer> list = new ArrayList<>() ;//此处下划线不知道为什么意思
        //执行发红包操作
        list = manager.send(25,3);

        //抽取红包
        one.Receive(list);
        //抽取红包
        two.Receive(list);
        //抽取红包
        three.Receive(list);

        System.out.println("我是：" + manager.getName() + ",余额：" + manager.getMoney() );
        System.out.println("我是：" + one.getName() + ",余额：" + one.getMoney() );
        System.out.println("我是：" + two.getName() + ",余额：" + two.getMoney() );
        System.out.println("我是：" + three.getName() + ",余额：" + three.getMoney() );
    }
}
