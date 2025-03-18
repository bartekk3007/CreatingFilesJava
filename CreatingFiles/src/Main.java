import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //Path workPath = Paths.get("C:\\JavaRepo\\RandomAccessFile\\test");
        //Files.createFile(workPath);

        Path newPath = Files.createTempFile(null, ".txt");
        System.out.println(newPath);

        Path dirPath = Paths.get(System.getProperty("user.dir"));
        UserPrincipal owner = Files.getOwner(dirPath);
        System.out.println(owner);

        try (var entities = Files.list(dirPath))
        {
            entities.forEach(System.out::println);
        }
        System.out.println();
        try (var entities = Files.walk(dirPath, 3))
        {
            entities.forEach(System.out::println);
        }
    }
}