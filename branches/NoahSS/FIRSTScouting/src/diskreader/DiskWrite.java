package diskreader;

import java.io.*;

/*This package is for Serializable writing only - if we want to use SQL, disregard this package.*/

public class DiskWrite {
    private static boolean deleteIfExists = false;
    
    public static void writeObject(Serializable s, String fName) {
        if((new File(fName)).exists()) 
            if(!deleteIfExists) throw new Error("Writing data to existent file!");
            else (new File(fName)).delete();
        
        try {
            try (ObjectOutput out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fName)))) {
                out.writeObject(s);
                out.close();
            } finally {}
        } catch (IOException ex) {}
    }
    
    public static void setDeleteIfExists(boolean val) {
        DiskWrite.deleteIfExists = val;
    }
}
