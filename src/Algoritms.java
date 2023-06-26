import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class Algoritms {
    Character[] letters = {'.', ',', '”', ':', '-', '—', '!', '?', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я',
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'};

    int num = letters.length - 1;
    int numberForDecoder = 0;
    int sizeOfFile = 0;
    int charakterForDecoding = 222;

    public void coder(int plusLetters, String inputFileCod, String outputFileCod) {
        try (FileReader fr = new FileReader(inputFileCod);
             FileWriter fw = new FileWriter(outputFileCod)) {
            while (fr.ready()) {
                sizeOfFile ++;
                char ch = (char) fr.read();
                for (int i = 0; i <= num; i++) {
                    if (ch == letters[i]) {
                        char resLet = letters[i];
                        if (i <= num - plusLetters)
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
            for (int i = 0; i < plusLetters; i++){
                fw.append((char) 222);
                numberForDecoder ++;
            }

        } catch (NoSuchFileException | FileNotFoundException e) {
            System.out.println("file with full name " + inputFileCod + " do not exit");
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int moveLetters(String inputFileDecod){
        int plusLetters = 0;
        try (FileReader fr = new FileReader(inputFileDecod)){
            while (fr.ready()){
                sizeOfFile ++ ;
                int ch = fr.read();
                if(ch == charakterForDecoding)
                    plusLetters ++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return plusLetters;
    }

    public void decoder(String inputFileDecode, String outputFileDecode) {

        int plusLetters = moveLetters(inputFileDecode);
        try (FileReader fr = new FileReader(inputFileDecode);
             FileWriter fw = new FileWriter(outputFileDecode)) {

            while (fr.ready()) {
                char ch = (char) fr.read();
                for (int i = 0; i <= num; i++) {
                    if (ch == letters[i] && (int)ch != charakterForDecoding) {
                        char resLet = letters[i];
                        if (i >= plusLetters)
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

        } catch (FileNotFoundException e) {
            System.out.println("This file does not exit!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}