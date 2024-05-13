package test.ttt;

public class Users {
    private String name ;
    private int money;

    public  Users(){
    }

    public  Users(String name,int money){
        this.money = money;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
