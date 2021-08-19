import java.util.concurrent.Executors;

public class UsingHolder {

    private static class ResourceHolder {
        public static final Resource resource = new Resource();
    }

    public static Resource getInstance() {
        return ResourceHolder.resource;
    }

    public static void main(String[] args) {
        Tester.test(UsingHolder::getInstance);
    }

}
