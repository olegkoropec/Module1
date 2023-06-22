import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;


public class InputFile {
    public static void main(String[] args) throws IOException {

        Character[] letters = {'.', ',', '”', ':', '-', '—', '!', '?', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я',
                'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'};
        String inputFile = null;
        Path path;
        int plusLetters = 3;
        int num = letters.length - 1;
        try {
            inputFile = "d:\\resolveProject\\FileInput.txt";
            FileReader fr = new FileReader(inputFile);
            while (fr.ready()) {
                char ch = (char) fr.read();
                for (int i = 0; i <= num; i++)
                    if (ch == letters[i]) {
                        char resLet = letters[i];
                        if (resLet == letters[num - plusLetters + 1])
                            System.out.print(letters[0]);
                        else if (resLet == letters[num - plusLetters + 2])
                            System.out.print(letters[1]);
                        else if (resLet == letters[num])
                            System.out.print(letters[2]);
                        else System.out.print(letters[i + plusLetters]);
                    }
            }

        } catch (NoSuchFileException e) {
            System.out.println("file with name " + inputFile + " do not exit");
        }
    }
}