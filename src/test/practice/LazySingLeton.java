package test.practice;

/**
 * 懒汉式 双校验
 */
public class LazySingLeton {
    private static  volatile LazySingLeton instance;

    private LazySingLeton(){

    }

    public static LazySingLeton getInstance(){
        if(instance ==null){
            synchronized (LazySingLeton.class){
                if(instance ==null){
                   instance =  new LazySingLeton();
                }
            }
        }
        return instance;
    }
}
