package managers;

public class DriverManager {
    private static ThreadLocal<Object> driver = new ThreadLocal<>();
    public static void setDriver(Object d)   { driver.set(d); }
    public static Object getDriver()         { return driver.get(); }
    public static void unload()              { driver.remove(); }
}