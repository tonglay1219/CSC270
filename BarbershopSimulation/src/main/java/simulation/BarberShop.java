package simulation;

import org.omg.CORBA.CustomMarshal;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BarberShop
{
    private static int NUM_OF_CUSTOMER = 1000000;
    protected static int clock = 0;
    protected static Random random = new Random();

    public void runSimulation()
    {
        int totalWaitTime = 0;
        int tempWaitTime;

        Customer previousCustomer = initiateFirstCustomer();
        Customer currentCustomer;

        for(int i = 1; i < NUM_OF_CUSTOMER; i++)
        {
            currentCustomer = new Customer();

            //Add the previous SI to the clock
            //  turn the clock to after the previous is served
            //Add before initiate a new C so that doesn't mess up the AT in the new C
            clock += previousCustomer.getServerInterval();

            tempWaitTime = clock - currentCustomer.getArrivalTime();
            System.out.print(currentCustomer + ", clock - " + clock);
            System.out.println(", Wait time - " + (tempWaitTime < 0 ? 0 : tempWaitTime));
            if(tempWaitTime > 0)
                totalWaitTime += tempWaitTime;
            else
                clock = currentCustomer.getArrivalTime();

            previousCustomer = currentCustomer;
        }

        System.out.println("Average wait time - " + totalWaitTime / (float)NUM_OF_CUSTOMER);
    }

    private Customer initiateFirstCustomer()
    {
        Customer customer = new Customer();
        clock += customer.getArrivalInterval();
        System.out.print(customer + ", clock - " + clock);
        System.out.println(", Wait time - " + 0);

        return customer;
    }
}
