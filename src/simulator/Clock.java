package simulator;

public class Clock extends Node implements Runnable {
    private Thread thread;
    private Boolean state;
    private long delay;

    public Clock(String label, long delay) {
        super(label);
        addOutputLink(false);
        state = false;
        this.delay = delay;
    }

    @Override
    public void evaluate() {
        getOutput(0).setValue(state);
    }

    @Override
    public void run() {
        while (true) {
            try {
            Thread.sleep(delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
            state = !state;
        }
    }
}