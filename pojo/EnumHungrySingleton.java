package pojo;

public enum EnumHungrySingleton {
    // 定义唯一的一个枚举元素，它就代表了单例实例
    INSTANCE;

    // 可以在枚举类中定义具体的业务方法
    public void doSth() {
        System.out.println("枚举单例方法执行");
    }

    // 使用方式：EnumHungrySingleton.INSTANCE.doSth();
}
