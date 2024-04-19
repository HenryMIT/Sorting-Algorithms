/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Henry
 */
public class TimeCalculation {

    //Attributes 
    private int arrayTest[] = new int[100000];

    public TimeCalculation() {
        //Fill the vector with numbers from 1 to 100000
        fillArray();
    }

    public void fillArray() {
        Random randon = new Random();
        for (int i = 0; i < this.arrayTest.length; i++) {
            this.arrayTest[i] = randon.nextInt(100000);
        }
    }

    public double ms_Calculation() {
        final double MS_PER_SECUND = 1000;
        long START_MS = System.currentTimeMillis();
        long TIME_SPENT_MS = System.currentTimeMillis() - START_MS;
        double realTime = (float) (TIME_SPENT_MS / MS_PER_SECUND);

        return realTime;
    }

    public double ns_Calculation() {
        String result = "";
        final double NS_PER_SECUND = 1000000000;
        long START_NS = System.nanoTime();
        long TIME_SPENT_NS = System.nanoTime() - START_NS;
        double realTime = (float) (TIME_SPENT_NS / NS_PER_SECUND);

        return realTime;
    }

    public void simpleTest() {
        double resultNano = 0;
        double resultMili = 0;

        System.out.println("We are testing at: " + new Date()
                + "\n Algorithm name: ");// <- Name of the algorithm you are going to test
        resultMili = ms_Calculation();
        //Algorithm test in miliseconds:

        resultNano = ns_Calculation();
        //Algorithm test in nanoseconds:

        System.out.println("TEST: Results from the execute"
                + "\n" + "The algorithm spent : " + resultMili + " miliSeconds"
                + "\n" + "The algorithm spent : " + resultNano + " nanoSeconds"
                + "\n-----------------------------------------");
    }

    public void compareTest() {
        double resultNano = 0;
        double resultMili = 0;
        double resultNano2 = 0;
        double resultMili2 = 0;

        System.out.println("We are testing at: " + new Date()
                + "\n Algorithm name: ");
        resultMili = ms_Calculation();
        //Algorithm test in miliseconds:

        resultNano = ns_Calculation();
        //Algorithm test in nanoseconds:

        System.out.println("TEST: Results from the execute"
                + "\n" + "The algorithm spent : " + resultMili + " miliSeconds"
                + "\n" + "The algorithm spent : " + resultNano + " nanoSeconds"
                + "\n-----------------------------------------");
    }

    public void repeatCalculartion() {

        Timer timer = new Timer();

        TimerTask reapeat;
        reapeat = new TimerTask() {
            double resultNano = 0;
            double resultMili = 0;

            @Override
            public void run() {

            }// end run
        };//End of ImplicitClass 

        // Schedule
        timer.schedule(reapeat, 0, 30);
    }// end reapeat calculation 

}
