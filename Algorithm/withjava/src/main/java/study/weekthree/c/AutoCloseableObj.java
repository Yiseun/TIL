package study.weekthree.c;

public class AutoCloseableObj implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("리소스가 close() 되었습니다");
    }
}