package test.ttt;

import java.util.ArrayList;

public class Manager extends Users {

    public Manager(){
    }//无参构造

    public Manager(String name, int money) {
        super(name, money);
    }//有参构造

    //发红包
    public ArrayList<Integer> send(int totalMoney, int count){
        //定义一个集合接收红包
        ArrayList<Integer> redList = new ArrayList<>();
        //取红包金额平均数
        int avg = totalMoney / count;
        //取红包金额余数
        int mod = totalMoney % count;
        //判断发红包的金额是否大于余额
        if (this.getMoney() < totalMoney){
            System.out.println("对不起，余额不足！");
        }else{
            //将平均数放进集合
            for (int i = 0; i < count-1; i++) {
                redList.add(avg);
            }
            //将余数放进最后一个红包内
            redList.add(avg + mod );
            this.setMoney(this.getMoney() - totalMoney );//减去发红包后的余额
        }
        return redList;//返回集合
    }

}
