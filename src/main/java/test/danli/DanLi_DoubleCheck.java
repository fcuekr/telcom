package test.danli;

public class DanLi_DoubleCheck {
    private static volatile Object object;

    public static void main(String[] args) {
        DanLi_Enum instance = DanLi_Enum.Instance;
        DanLi_Enum instance2 = DanLi_Enum.Instance;
        System.out.println(instance==instance2);
    }

    public static Object wocao(){
        if (object==null){
            synchronized (DanLi_DoubleCheck.class){
                if (object==null){
                    return new Object();
                }
            }
        }
        return object;
    }
}
