import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class InputFile {
    Character[] letters = {'.', ',', '”', ':', '-', '—', '!', '?', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я',
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'};
    int plusLetters;
    int num = letters.length - 1;
    String inputFileCod = "d:\\resolveProject\\FileInput.txt";
    String outputFileCod = "d:\\resolveProject\\File.txt";

    String inputFileDecod = "d:\\resolveProject\\File.txt";
    String outputFileDecod = "d:\\resolveProject\\FileOutputDecod.txt";

    private void coder(int plusLetters) throws IOException {
        this.plusLetters = plusLetters;
        try (FileReader fr = new FileReader(inputFileCod);
             FileWriter fw = new FileWriter(outputFileCod)) {
            while (fr.ready()) {
                char ch = (char) fr.read();
                for (int i = 0; i <= num; i++) {
                    if (ch == letters[i]) {
                        char resLet = letters[i];
                        if(i <= num - plusLetters)
                            fw.append(letters[i + plusLetters]);
                        else {
                            for (int j = 0; j < plusLetters; j++) {
                                if (resLet == letters[num - plusLetters + j + 1])
                                    fw.append(letters[j]);
                            }
                        }
                    }
                }
            }
        } catch (NoSuchFileException e) {
            System.out.println("file with name " + inputFileCod + " do not exit");
        }
    }

    private void decoder(int plusLetters) throws IOException {
        try (FileReader fr = new FileReader(inputFileDecod);
             FileWriter fw = new FileWriter(outputFileDecod)) {
            while (fr.ready()) {
                char ch = (char) fr.read();
                for (int i = 0; i <= num; i++) {
                    if (ch == letters[i]) {
                        char resLet = letters[i];
                        if(i >= plusLetters)
                            fw.append(letters[i - plusLetters]);
                        else {
                            for (int j = 0; j < plusLetters; j++) {
                                if (resLet == letters[j])
                                    fw.append(letters[num - plusLetters + j + 1]);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner enter = new Scanner(System.in);
        System.out.println("Введіть число, яке вказує на кількість позицій праворуч(+) або ліворуч(-) від літери для шифрування та дешифрування: ");
        int number = enter.nextInt();
        InputFile file = new InputFile();
        file.coder(number);
        file.decoder(number);

    }
}