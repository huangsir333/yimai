package cn.alibaba.yimai.util;
/*懒汉模式 */
public class SingLeton {
    private static  SingLeton singLeton=null;

    public synchronized SingLeton getInstance(){
        if (singLeton==null){
            synchronized (SingLeton.class){
                if (singLeton==null){

                    return new SingLeton();
                }
            }
        }
        return singLeton;
    }
}
