package simulation;

import com.sun.jndi.ldap.Ber;

public class Customer
{
    private int arrivalInterval;
    private int arrivalTime;
    private int serverInterval;

    public Customer()
    {
        this.arrivalInterval = MathHelper.getTimeFromEquation(20);
        this.arrivalTime = BarberShop.clock + arrivalInterval;
        this.serverInterval = MathHelper.getTimeFromEquation(15);
    }

    public Customer(int arrivalInterval, int arrivalTime, int serverInterval)
    {
        this.arrivalInterval = arrivalInterval;
        this.arrivalTime = arrivalTime;
        this.serverInterval = serverInterval;
    }

    public int getArrivalInterval()
    {
        return arrivalInterval;
    }

    public int getArrivalTime()
    {
        return arrivalTime;
    }

    public int getServerInterval()
    {
        return serverInterval;
    }

    @Override
    public String toString()
    {
        return "Customer - " + arrivalInterval +
                " - " + arrivalTime +
                " - " + serverInterval;
    }
}
