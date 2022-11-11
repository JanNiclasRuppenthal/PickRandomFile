import java.io.File;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        String pathToDirectory = args[0];
        String fileExtension = args[1];
        File directory = new File(pathToDirectory);
        File tempFile = new File(pathToDirectory);

        if (!directory.isDirectory())
        {
            throw new RuntimeException(pathToDirectory + " is not a directory!");
        }
        
        while (!directory.getName().endsWith(fileExtension))
        {
            directory = pickUpFile(tempFile);
        }

        System.out.println("Pick up file: " + directory.getName() + " in " + directory.getPath());
    }

    private static File pickUpFile(File directory)
    {
        int numberOfFiles = 0;
        int randomNumber = 0;
        while (directory.isDirectory() && (numberOfFiles = directory.listFiles().length) > 0)
        {
            randomNumber = new Random().nextInt(numberOfFiles);
            directory = directory.listFiles()[randomNumber];
        }
        return directory;
    }
}
