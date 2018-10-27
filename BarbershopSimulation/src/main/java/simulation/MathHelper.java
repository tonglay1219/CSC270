package simulation;

import java.util.Random;

public class MathHelper
{
    public static int getTimeFromEquation(int meanTime)
    {
        // -Ln(1-RandomValue) * MeanTime
        double temp = (-1 * Math.log(1 - (new Random().nextInt(100) / (float)100)) * meanTime);
//        System.out.println(temp);
//        return (int)Math.round(-1 * Math.log(1 - Math.random()) * meanTime);
        return (int)temp + 1;
    }
}
