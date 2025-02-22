package test.practice;

/**
 * 饿汉式
 */
public class SingLeton {
    private static final SingLeton instance = new SingLeton();
    private SingLeton(){

    }

    public static SingLeton getInstance(){
        return instance;
    }
}
