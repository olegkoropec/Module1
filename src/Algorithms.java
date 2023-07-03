import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Algorithms {
    List<Character> list = Arrays.asList('.', ',', '”', ':', '-', '—', '!', '?', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я',
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я');

    int length = list.size() - 1;
    int numberForDecoder = 0;
    int sizeOfFile = 0;
    char characterForDecoding = 222;

    public void encoderFile(int moveLetters, String inputFileCode, String outputFileCode) throws IOException {
        try (FileReader fileReader = new FileReader(inputFileCode);
             FileWriter fileWriter = new FileWriter(outputFileCode)) {
            while (fileReader.ready()) {
                sizeOfFile++;
                char ch = (char) fileReader.read();
                int index = list.indexOf(ch);
                if (list.contains(ch) && index <= length - moveLetters)
                    fileWriter.append(list.get(index + moveLetters));
                else {
                    for (int j = 0; j < moveLetters; j++) {
                        if (ch == list.get(length - moveLetters + j + 1))
                            fileWriter.append(list.get(j));
                    }
                }
            }
            for (int i = 0; i < moveLetters; i++) {
                fileWriter.append(characterForDecoding);
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

    public void decoderFile(String inputFileDecode, String outputFileDecode) throws IOException {
        int moveLetters = keyMethod(inputFileDecode);
        try (FileReader fileReader = new FileReader(inputFileDecode);
             FileWriter fileWriter = new FileWriter(outputFileDecode)) {
            while (fileReader.ready()) {
                char characterOfFileReader = (char) fileReader.read();
                if (list.contains(characterOfFileReader) && (int) characterOfFileReader != characterForDecoding && list.indexOf(characterOfFileReader) >= moveLetters)
                    fileWriter.append(list.get(list.indexOf(characterOfFileReader) - moveLetters));
                else {
                    for (int j = 0; j < moveLetters; j++) {
                        if (characterOfFileReader == list.get(j))
                            fileWriter.append(list.get(length - moveLetters + j + 1));
                    }
                }
            }
        }
    }
}
