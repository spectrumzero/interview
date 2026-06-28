package pojo;

public class HungrySingleton {
    // 不要破坏我的单例
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    // 公开方法
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
