package serialization;

import org.apache.log4j.Logger;
import worker.Worker;
import java.io.*;

public class Deserializator {
    private static  Logger LOG = Logger.getLogger(Deserializator.class.toString());

    public static void deserialization(String fileName) throws InvalidClassException {
        File file = new File(fileName);

        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream istream = new ObjectInputStream(fis);
            Worker worker = (Worker)istream.readObject();
            LOG.info(worker.toString());
        }
        catch (FileNotFoundException e) {
            LOG.error(e);
            e.printStackTrace();
        }
        catch (IOException e) {
            LOG.error(e);
        }
        catch (ClassNotFoundException e) {
            LOG.error(e);
        }
    }
}
