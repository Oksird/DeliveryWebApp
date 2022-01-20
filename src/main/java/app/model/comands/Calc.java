package app.model.comands;

public class Calc {
    public static double calculateCost(int distanceMod, int size, int weight){
        return distanceMod * size  * weight - 0.01;
    }
}
