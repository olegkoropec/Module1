import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EncryptDecryptFunctions {
    private final List<Character> characterList = Arrays.asList('.', ',', '”', ':', '-', '—', '!', '?', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я',
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я');

    private final int length = characterList.size() - 1;
    private int numberForDecoder = 0;
    private int sizeOfFile = 0;
    private final char characterForDecoding = 222;

    public void encoderFile(int moveLetters, String inputFileCode, String outputFileCode) throws IOException {
        try (FileReader fileReader = new FileReader(inputFileCode);
             FileWriter fileWriter = new FileWriter(outputFileCode)) {
            while (fileReader.ready()) {
                sizeOfFile++;
                char characterOfFileReader = (char) fileReader.read();
                int index = characterList.indexOf(characterOfFileReader);
                if (characterList.contains(characterOfFileReader) && index <= length - moveLetters)
                    fileWriter.append(characterList.get(index + moveLetters));
                else
                    fileWriter.append(characterList.get(index + moveLetters - length - 1));
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
                int index = characterList.indexOf(characterOfFileReader);
                if (characterList.contains(characterOfFileReader) && (int) characterOfFileReader != characterForDecoding && index >= moveLetters)
                    fileWriter.append(characterList.get(index - moveLetters));
                else
                    fileWriter.append(characterList.get(index - moveLetters + length + 1));
            }
        }
    }
}
