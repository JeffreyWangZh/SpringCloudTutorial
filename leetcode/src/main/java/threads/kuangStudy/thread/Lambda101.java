package threads.kuangStudy.thread;

/**
 * Lamda 表达式
 * ()-> express
 * 函数式接口：一个接口值包含一个抽象方法
 * @Author jw9j
 * @create 2021/6/22 0:55
 */
public class Lambda101 {
    //3.静态内部类
    static class Like2 implements Ilike{

        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }
    public static void main(String[] args) {
        Ilike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        // 4.局部内部类
        class Like3 implements Ilike{

            @Override
            public void lambda() {
                System.out.println("局部内部类");
            }
        }
        like = new Like3();
        like.lambda();

        //5. 匿名类
        like = new Ilike() {
            @Override
            public void lambda() {
                System.out.println("匿名类");
            }
        };
        like.lambda();

        //6. 使用Lambda 简化
        like = ()->{
            System.out.println("Lambda 表达式");
        };
        like.lambda();

        // 带参数
        Ilove love =(String s)->{
            System.out.println("I love you"+ s);
        };

        // 简化一： 参数类型
        love = (s)->{
            System.out.println("简化1" + s);
        };

        // 简化二：去掉括号 仅有一个参数
        love = s ->{
            System.out.println("简化2"+s);
        };

        // 简化三: 去掉花括号 仅有一行代码
        love = s -> System.out.println("简化3"+s);

        love.love("sss");

    }
}

//1. 定义一个函数接口
interface Ilike{
    void lambda();
}
//2. 实现类
class Like implements Ilike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
interface Ilove{
    void love(String a);
}

