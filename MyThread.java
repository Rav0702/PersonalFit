import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class MyThread extends Thread{

    MyThread(String name)
    {
        super(name);
    }

    @Override
    public void run() {
        synchronized (Main.personalFit){
            List<ProteinShake> shakes=Main.personalFit.stream().filter(x->x instanceof ProteinShake).map(x->(ProteinShake) x).collect(toList());
            Random rand= new Random ();
            System.out.println(shakes.get(rand.nextInt(shakes.size())));
        }

    }
}
