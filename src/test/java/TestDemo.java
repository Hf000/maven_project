import org.junit.Test;

/**
 * @Author:hufei
 * @CreateTime:2020-07-29
 * @Description:
 */
public class TestDemo {

    @Test
    public void myTest() {
        FucInterface fucInterface = new FucInterface() {
            @Override
            public void execute() {
                System.out.println("重写函数接口方法");
            }
        };
//        FucInterface fucInterface = () -> {
//            System.out.println("实现的是哪个方法");
//        } ;
        fucInterface.execute();
    }

}
