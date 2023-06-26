import java.util.Scanner;

public class Menu {
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
    Algoritms file = new Algoritms();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (isRunning){
            System.out.println(MENU_INFO);
            int itemMenu = scanner.nextInt();
            switch (itemMenu){
                case EXIT_NUMBER -> methodExit();
                case ENCODE_FILE -> methodEncode();
                case DECODE_FILE -> methodDecode();
            }
        }
    }
    public void methodExit(){
        isRunning = false;
        System.out.println("it's a pity that you are leaving the program");
    }
    public void methodEncode() {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr1 = new Scanner(System.in);
        Scanner scannerStr2 = new Scanner(System.in);
        System.out.println("Enter a number indicating the number of positions to the right (+) of the letter to be encrypted, but not more than 85");
        int numb = scannerInt.nextInt();
        System.out.println("Enter the full name of the file you want to encode");
        String read = scannerStr1.nextLine();
        System.out.println("Enter the full name of the file where you want to save the encoded code");
        String write = scannerStr2.nextLine();
        file.coder(numb, read, write);
    }

    public void methodDecode(){
        Scanner scannerStr1 = new Scanner(System.in);
        Scanner scannerStr2 = new Scanner(System.in);
        System.out.println("Enter the full name of the encoded file");
        String read = scannerStr1.nextLine();
        System.out.println("Enter the full name of the file where the decoded text should be saved");
        String write = scannerStr2.nextLine();
        file.decoder(read, write);
    }
}
