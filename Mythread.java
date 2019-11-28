
public class Mythread extends Thread {
    Petrol ob;

    /**********************************/
Mythread(Petrol ob1){
    this.ob=ob1;

}

    public void run(){
        ob.arrive();
        ob.occupyPump();
        ob.getServed();
        ob.pay();
        ob. leaves();

    }

}
