

import java.util.Random;


public class Petrol {

    String name;
    int pump;
    Semaphore ob;
    public Random rand = new Random();
    int random1 = rand.nextInt(10000) + 1;

    public Petrol() {
        name = "";
        ob = null;
        pump=0;
    }
    ///////////////////////////////////////
    public Petrol(String name, Semaphore res) {
        this.name = name;
        this.ob = res;
        pump=0;
    }
    //////////////////////////////////////
    public void arrive()
    {
        pump=ob.P(name);
        try {
            Thread.sleep(random1);
        } catch (InterruptedException ex) {

        }
    }
    ////////////////////////////////////////
    public void occupyPump(){

        System.out.println("- Pump "+(pump+1)+": "+name +" Occupied.");
        try {
            Thread.sleep(random1);
        } catch (InterruptedException ex) {
        }
    }
    /*************************************************/
    public void getServed(){

        System.out.println("- Pump"+(pump+1)+": "+name +" Get served ");
        try {
            Thread.sleep(random1);
        } catch (InterruptedException ex) {

        }
    }
    /*******************************************************************/

    public void pay(){

        System.out.println("- pump"+(pump+1)+": "+name +" is paying");
        try {
            Thread.sleep(random1);
        } catch (InterruptedException ex) {

        }

    }
    /**********************************************************************/
    public void leaves(){
        ob.V(name, pump);
    }
}
