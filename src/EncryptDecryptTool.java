import java.io.IOException;
import java.util.Scanner;

public class EncryptDecryptTool{
    public static final int EXIT_NUMBER = 0;
    public static final int ENCODE_FILE = 1;
    public static final int DECODE_FILE = 2;
    public static final String MENU_INFO =
            """
                    1. Encode
                    2. Decode
                    0. Exit
                    """;
    public boolean isRunning = true;
    EncryptDecryptFunctions file = new EncryptDecryptFunctions();

    public void perform() {
        Scanner menuScanner = new Scanner(System.in);
        while (isRunning) {
            System.out.println(MENU_INFO);
            int itemMenu = menuScanner.nextInt();
            try {
                switch (itemMenu) {
                    case EXIT_NUMBER -> methodExit();
                    case ENCODE_FILE -> methodEncode();
                    case DECODE_FILE -> methodDecode();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void methodExit() {
        isRunning = false;
        System.out.println("it's a pity that you are leaving the program");
    }

    public void methodEncode() throws IOException {
        Scanner keyScanner = new Scanner(System.in);
        Scanner inputFileScanner = new Scanner(System.in);
        Scanner outputFileScanner = new Scanner(System.in);
        System.out.println("Enter a number indicating the number of positions to the right (+) of the letter to be encrypted, but not more than 85");
        int key = keyScanner.nextInt();
        System.out.println("Enter the full name of the file you want to encode");
        String readFile = inputFileScanner.nextLine();
        System.out.println("Enter the full name of the file where you want to save the encoded code");
        String writeEncodingFile = outputFileScanner.nextLine();
        file.encoderFile(key, readFile, writeEncodingFile);
    }

    public void methodDecode() throws IOException {
        Scanner inputFileScanner = new Scanner(System.in);
        Scanner outputFileScanner = new Scanner(System.in);
        System.out.println("Enter the full name of the encoded file");
        String readFile = inputFileScanner.nextLine();
        System.out.println("Enter the full name of the file where the decoded text should be saved");
        String writeDecodingFile = outputFileScanner.nextLine();
        file.decoderFile(readFile, writeDecodingFile);
    }
}
