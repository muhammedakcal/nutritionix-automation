package platform;

import platform.enums.PlatformType;

public class PlatformManager {

    private static ThreadLocal<PlatformType> platform = new ThreadLocal<>();

    public static void setPlatform(PlatformType platformType) {
        platform.set(platformType);
    }

    public static PlatformType getPlatform() {
        return platform.get();
    }

    public static void unloadPlatform() {
        platform.remove();
    }
}
