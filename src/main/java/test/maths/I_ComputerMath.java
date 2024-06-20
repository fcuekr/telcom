package test.maths;

public class I_ComputerMath {
    public static void main(String[] args) {
        System.out.println(add2(78, 25));
        System.out.println(minus2(78, 25));
        System.out.println(multi2(78, 25));
        System.out.println(divide2(-1025, 25));
        System.out.println(divide2(Integer.MIN_VALUE, 100));
        System.out.println(divide2(123, Integer.MIN_VALUE));
    }

    //a+b 等于a和b的异或 加上 a和b的与然后向左移1位,即 a和b的不进位和+a和b的进位，a和b的进位就是a&b往左移一位
    public static int add(int arg1,int arg2){
        //因为不能出现+号，所以只有当arg2为0的时候才是答案。
        if (arg2==0){
            return arg1;
        }
        return add(arg1^arg2,(arg1&arg2)<<1);
    }

    //a-b 等于a+(-b)
    public static int minus(int arg1,int arg2){
        arg2=negative(arg2);
        return add(arg1,arg2);
    }

    //a*b 等于 a*b的每一位 1101*111 = 1101<<2*1+1101<<1*1+1101<<0*1 = 1101<<2+1101<<1+1101
    public static int multi(int arg1,int arg2){
        int sum=0;
        while (arg2>0){
            if ((arg2&1)==1){
                sum = add(sum,arg1);
            }
            arg2=arg2>>>1;
            arg1=arg1<<1;
        }
        return sum;
    }

    //a/b 等于 a不断左移，直到刚好大于b，a等于减去b右移 a的左移位，然后结果加上a的左移i个位的数再+1，直到被除数小于除数
    public static int divide(int arg1,int arg2) {
        int result = 0;
        for (int i = 30; i >=0; i = minus(i,1)) {
            if ((arg1>>i)>=arg2){
                arg1=arg1-(arg2<<i);
                result = result+(1<<i);
            }
        }
        return result;
    }

    public static int negative(int arg){
        return ~arg+1;
    }

    public static int add2(int arg1,int arg2){
        if (arg2==0){
            return arg1;
        }
        return add2(arg1^arg2,(arg1&arg2)<<1);
    }

    public static int minus2(int arg1,int arg2){
        return add2(arg1,negative2(arg2));
    }

    public static int negative2(int arg){
        return ~arg+1;
    }

    public static int multi2(int arg1,int arg2){
        int result = 0;
        while (arg2!=0){
            if ((arg2&1)==1){
                result = result + arg1;
            }
            arg2=arg2>>1;
            arg1=arg1<<1;
        }
        return result;
    }

    //由于int的最小值不能反转，因为int取值范围是-2^31 ~ 2^31-1，所以需要特殊判断
    public static int divide2(int arg1,int arg2){
        if (arg1==Integer.MIN_VALUE&&arg2==Integer.MIN_VALUE){
            return 1;
        }else if (arg2==Integer.MIN_VALUE){
            return 0;
        }else if (arg1==Integer.MIN_VALUE){
            //arg1+1=a
            //a/arg2=b
            //arg1-(b*arg2)=c
            //c/arg2=d
            //b+d=e
            if (arg2==1){
                return arg1;
            }
            return add2(divideSuffix(add2(arg1,1),arg2),divideSuffix(minus2(arg1,multi2(divideSuffix(add2(arg1,1),arg2),arg2)),arg2));
        }else {
            return divideSuffix(arg1,arg2);
        }
    }

    public static int divideSuffix(int arg1,int arg2){
        int x = isNeg(arg1)?negative2(arg1):arg1;
        int y = isNeg(arg2)?negative2(arg2):arg2;
        int result = 0;
        for (int i = 30; i >= 0; i= minus(i,1)) {
            if ((x>>i)>=y){
                result |=1<<i;
                x=minus(x,y<<i);
            }
        }
        return isNeg(arg1)^isNeg(arg2)?negative2(result):result;
    }

    public static boolean isNeg(int arg){
        return arg<0;
    }
}
