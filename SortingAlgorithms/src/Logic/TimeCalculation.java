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

    Algorithms algoritms;

    public TimeCalculation() {
        algoritms = new Algorithms();
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
       // algoritms.BubbleSort();
        double realTime = (float) (TIME_SPENT_NS / NS_PER_SECUND);

        return realTime;
    }

    public void simpleTest() {
        double resultNano = 0;
        double resultMili = 0;

        System.out.println("We are testing at: " + new Date()
                + "\n Algorithm name: BubbleSort");// <- Name of the algorithm you are going to test
        //algoritms.mergeSort();
        algoritms.BubbleSort();
        resultMili = ms_Calculation();
        //Algorithm test in miliseconds:
        algoritms.BubbleSort();
        //algoritms.mergeSort();
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
                + "\n algorithm name 1: "// <- Name algorithm 1 to be compared
                + "\n algorithm name 2: ");// <- Name algorithm 2 to be compared
        resultMili = ms_Calculation();
        //Algorithm test in miliseconds:

        resultMili2 = ms_Calculation();
        //Algorithm test in miliseconds:

        resultNano = ns_Calculation();
        //Algorithm test in nanoseconds:

        resultNano2 = ns_Calculation();
        //Algorithm test in nanoseconds:

        System.out.println("TEST: Results from the execute"
                + "\n" + "The algorithm 1 spent : " + resultMili + " miliSeconds"
                + "\n" + "The algorithm 2 spent : " + resultMili2 + " miliSeconds"
                + "\n" + "The algorithm 1 spent : " + resultNano + " nanoSeconds"
                + "\n" + "The algorithm 2 spent : " + resultNano2 + " nanoSeconds"
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
                //Enter the test method you want to run:

                simpleTest();

            }// end run
        };//End of ImplicitClass 

        // Schedule
        timer.schedule(reapeat, 0, 10);
    }// end reapeat calculation 

}
