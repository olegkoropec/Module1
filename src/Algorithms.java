import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Algorithms {
    Character[] letters = {'.', ',', '”', ':', '-', '—', '!', '?', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я',
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'};

    int lengthOfArray = letters.length - 1;
    int numberForDecoder = 0;
    int sizeOfFile = 0;
    int characterForDecoding = 222;

    public void coder(int moveLetters, String inputFileCode, String outputFileCode) throws IOException {
        try (FileReader fileReader = new FileReader(inputFileCode);
             FileWriter fileWriter = new FileWriter(outputFileCode)) {
            while (fileReader.ready()) {
                sizeOfFile++;
                char ch = (char) fileReader.read();
                for (int i = 0; i <= lengthOfArray; i++) {
                    if (ch == letters[i]) {
                        char resLet = letters[i];
                        if (i <= lengthOfArray - moveLetters)
                            fileWriter.append(letters[i + moveLetters]);
                        else {
                            for (int j = 0; j < moveLetters; j++) {
                                if (resLet == letters[lengthOfArray - moveLetters + j + 1])
                                    fileWriter.append(letters[j]);
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < moveLetters; i++) {
                fileWriter.append((char) 222);
                numberForDecoder++;
            }
        }
    }

    public int keyMethod(String inputFileDecode) throws IOException {
        int moveLetters = 0;
        try (FileReader fileReader = new FileReader(inputFileDecode)) {
            while (fileReader.ready()) {
                sizeOfFile++;
                int ch = fileReader.read();
                if (ch == characterForDecoding)
                    moveLetters++;
            }
        }
        return moveLetters;
    }

    public void decoder(String inputFileDecode, String outputFileDecode) throws IOException {
        int moveLetters = keyMethod(inputFileDecode);
        try (FileReader fileReader = new FileReader(inputFileDecode);
             FileWriter fileWriter = new FileWriter(outputFileDecode)) {
            while (fileReader.ready()) {
                char characterOfFileReader = (char) fileReader.read();
                for (int i = 0; i <= lengthOfArray; i++) {
                    if (characterOfFileReader == letters[i] && (int) characterOfFileReader != characterForDecoding) {
                        char correctCharacter = letters[i];
                        if (i >= moveLetters)
                            fileWriter.append(letters[i - moveLetters]);
                        else {
                            for (int j = 0; j < moveLetters; j++) {
                                if (correctCharacter == letters[j])
                                    fileWriter.append(letters[lengthOfArray - moveLetters + j + 1]);
                            }
                        }
                    }
                }
            }
        }
    }
}