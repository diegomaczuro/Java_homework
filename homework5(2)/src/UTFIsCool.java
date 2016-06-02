import java.io.*;
import java.util.Random;

/**
 * Created by shido on 31.05.16.
 */
public class UTFIsCool {

    final static Random random = new Random();

    public static String readUTF(String fileName, long offset) throws IOException {

        FileInputStream is = new FileInputStream(fileName);
        Reader fileReader = new InputStreamReader(is, "UTF-8");
        StringBuilder stringBuilder = new StringBuilder();

        fileReader.skip(offset);

        int charsRead;
        char buf[] = new char[256];

        //Read until there is no more characters to read.
        while ((charsRead = fileReader.read(buf)) > 0) {
            stringBuilder.append(buf, 0, charsRead);
        }

        fileReader.close();

        return stringBuilder.toString();
    }
    
    public static void main(String[] args){
        try {
            RandomAccessFile raf = new RandomAccessFile(args[0], "r");

            try {
                Boolean isUTFChar = false;
                raf.seek(random.nextInt((int)raf.length()));
                long pos = raf.getFilePointer();
                System.out.print(String.format("Начало чтения с: %s\n", pos));

                while (!isUTFChar){
                    pos = raf.getFilePointer();
                    Byte b = raf.readByte();
                    int bit7 = (b >> 7) & 1; // (b >> 0) & 1
                    int bit6 = (b >> 6) & 1; // (b >> 1) & 1

                    if (bit7 == 0) isUTFChar = true; //Нашли ASCII символ
                    if ((bit7 == 1) && (bit6 == 0)) isUTFChar = false; //В середине UTF8 символа
                    if ((bit7 == 1) && (bit6 == 1)) isUTFChar = true; //Начало UTF8 символа

                    if (!isUTFChar){
                        System.out.print(String.format("Пропущен символ с бинарным кодом: %8s\n", Integer.toBinaryString(b & 0xFF)));
                    }
                }

                System.out.print(String.format("Первый символ в позиции: %s\n\n", pos));
                raf.seek(pos);

                String str = readUTF(args[0], pos);
                System.out.print(str);
            }
            catch(EOFException e){
                System.out.println("\nЧтение закончено");
            }

            raf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
