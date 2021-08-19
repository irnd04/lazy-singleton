import lombok.SneakyThrows;

public class UsingDoubleCheck {

    private static volatile Resource resource;

    @SneakyThrows
    public static Resource getInstance() {
        if (resource == null) {
            synchronized (UsingDoubleCheck.class) {
                if (resource == null) {
                    resource = new Resource();
                }
            }
        }
        return resource;
    }

    public static void main(String[] args) {
        Tester.test(UsingDoubleCheck::getInstance);
    }

}
