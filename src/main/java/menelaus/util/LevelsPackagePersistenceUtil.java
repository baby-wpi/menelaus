package menelaus.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import menelaus.model.LevelsPackage;

public class LevelsPackagePersistenceUtil {
    public static void toFile(LevelsPackage levelsPackage, File outputFile) throws IOException {
        FileOutputStream fileToWrite = new FileOutputStream(outputFile);
        ObjectOutputStream objectToWrite = new ObjectOutputStream(fileToWrite);
        objectToWrite.writeObject(levelsPackage);
 
        fileToWrite.close();
    }
 
    public static LevelsPackage fromFile(File inputFile) throws IOException, ClassNotFoundException {
        FileInputStream fileToRead = new FileInputStream(inputFile);
        ObjectInputStream objectToRead = new ObjectInputStream(fileToRead);
        Object obj = objectToRead.readObject();
        objectToRead.close();
        
        return (LevelsPackage) obj;
    }
}
