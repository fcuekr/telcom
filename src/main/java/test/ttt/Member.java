package test.ttt;

import java.util.ArrayList;
import java.util.Random;

public class Member extends Users {
    //构建一个无参方法
    public Member() {
    }
    //构建一个有参方法
    public Member(String name, int money) {
        super(name, money);
    }

    //收红包
    public void Receive(ArrayList<Integer> list){
        Random r = new Random();
        //获取一个随机数
        int index = r.nextInt(list.size());
        //随机抽取一个红包
        int delta = list.remove(index);
        int money = this.getMoney();//当前成员有多少钱（此处为何不使用this？）
        super.setMoney(delta + money);
    }
}
