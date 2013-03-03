package tournamentftc;

import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    public static ArrayList<Integer> sortDescendingDbl(ArrayList<Double> data) {
        ArrayList<Double> unsortedData = new ArrayList<>();
        for(int i = 0; i < data.size(); i++) {
            unsortedData.add(data.get(i).doubleValue() + 0.000001 * (double)i);
            data.set(i, data.get(i).doubleValue() + 0.000001 * (double)i);
        }

        Collections.sort(data, Collections.reverseOrder());
        
        ArrayList<Integer> outData = new ArrayList<>();
        
        for(int i = 0; i < data.size(); i++)
            outData.add(unsortedData.indexOf(data.get(i)));
        
        return outData;
    }
    
    public static ArrayList<Integer> sortDescendingInt(ArrayList<Integer> data) {
        ArrayList<Double> newData = new ArrayList<Double>();
        
        for(int i = 0; i < data.size(); i++)
            newData.add(data.get(i).doubleValue());
        
        return sortDescendingDbl(newData);
        /*ArrayList<Integer> unsortedData = new ArrayList<>();
        for(int i = 0; i < data.size(); i++) unsortedData.add(data.get(i));
        
        Collections.sort(data, Collections.reverseOrder());

        ArrayList<Integer> outData = new ArrayList<>();
        for(int i = 0; i < data.size(); i++)
            outData.add(unsortedData.indexOf(data.get(i).intValue()));
        
        return outData;*/
    }
}
