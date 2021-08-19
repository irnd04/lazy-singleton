import java.util.concurrent.atomic.AtomicReference;

public class UsingCAS {

    private final static AtomicReference<Resource> resource = new AtomicReference<>();

    public static Resource getInstance() {
        while (resource.compareAndSet(null, new Resource()));
        return resource.get();
    }

    public static void main(String[] args) {
        Tester.test(UsingCAS::getInstance);
    }

}
