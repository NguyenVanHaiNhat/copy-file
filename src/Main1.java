import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main1 {
    private static void copyUsingJava7(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException{
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = is.read(bytes)) > 0){
                os.write(bytes, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Nhập đường dẫn nguồn");
        String sourcePath = in.nextLine();
        System.out.println("Nhập đường dẫn đích");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingStream(sourceFile, destFile);
            System.out.println("Copy complete");
        } catch (IOException ioe){
            System.out.println("can't not copy");
            System.out.println(ioe.getMessage());
        }
    }
}
