package test;

public abstract class MyTest2<T> {
    public abstract void base();

    public void wocao(T t){
        System.out.println(t instanceof String);
    }
}

class Son<T> extends MyTest2<T>{
    public static void main(String[] args) {
        Son son = new Son<Integer>();
        son.base();
        son.second();
        son.wocao("123");
    }

    @Override
    public void base() {
        System.out.println();
    }

    private void second(){
        System.out.println();
    }
}


