package tournamentftc;

import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    public static int[] sortDescending(ArrayList<Double> data) {
        int[] outArray = new int[data.size()];
        ArrayList<Double> unsortedData = data;
        
        for(int i = 0; i < data.size(); i++) data.set(i, data.get(i) + (.000001 * i));
        Collections.sort(data, Collections.reverseOrder());
        
        for(int i = 0; i < data.size(); i++)
            outArray[i] = unsortedData.indexOf(data.get(i));
        
        return outArray;
    }
}
