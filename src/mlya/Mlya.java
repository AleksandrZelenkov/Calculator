package mlya;

public class Mlya {
    public void say() {

        Thread thread = new Thread(new MlyaRun());
        thread.start();
    }
}