package pojo;

public class DclLazySingleton {
    // 禁用重排序，严格：分配内存 -> 初始化对象，完整赋值 -> 返回地址
    private static volatile DclLazySingleton INSTANCE;

    private DclLazySingleton() {
    }

    public static DclLazySingleton getInstance() {
        if (INSTANCE == null) {
            // 上锁
            synchronized (DclLazySingleton.class) {
                // 只需要一个线程来创建一次单例，避免重复创建
                if (INSTANCE == null) {
                    INSTANCE = new DclLazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}
