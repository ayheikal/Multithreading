import java.util.Vector;

public class Semaphore {

    protected int value = 0;
    public Vector<Integer> t = new Vector<Integer>();

   
    protected Semaphore(int initial) {
        value = initial;
        for (int i = 0; i < value; i++)
            t.addElement(1);
    }

    //////////////////////////////////////
    public synchronized int P(String name) {
        System.out.print("- " + name + " arrived ");

        value--;
        if (value < 0) {

            System.out.println(" and waiting.");
            try {
                wait();
            } catch (InterruptedException e) {
                int first_free_pump = t.indexOf(1);
                t.set(first_free_pump, 0);
                return first_free_pump;
            }

        }
        System.out.println();
        int first_free_pump = t.indexOf(1);
        t.set(first_free_pump, 0);
        return first_free_pump;
    }

    /*****************************************************/
    public synchronized void V(String name, int pump) {

        System.out.println("- " + name + " leaves.");
        t.set(pump, 1);
        value++;
        if (value <= 0) notify();
    }

}
