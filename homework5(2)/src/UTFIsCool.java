import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * Created by shido on 31.05.16.
 */
public class UTFIsCool {
    
    public void main(String[] args){
        try {
            RandomAccessFile raf = new RandomAccessFile(args[0], "r");

            try {
                Boolean isUTFChar = false;
                long pos = -1;

                while (!isUTFChar){
                    pos = raf.getFilePointer();
                    Byte b = raf.readByte();
                    int bit7 = (b >> 7) & 1; // (b >> 0) & 1
                    int bit6 = (b >> 6) & 1; // (b >> 1) & 1

                    if (bit7 == 0) isUTFChar = true; //Нашли ASCII символ
                    if ((bit7 == 1) && (bit6 == 0)) isUTFChar = false; //В середине UTF8 символа
                    if ((bit7 == 1) && (bit6 == 1)) isUTFChar = true; //Начало UTF8 символа

                    if (!isUTFChar){
                        System.out.print(String.format("Пропущен символ с бинарным кодом: %8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
                    }
                }

                raf.seek(pos);

                //Вывод файла на экран как строки
                String smb;
                while (true) {
                    smb = raf.readUTF();
                    System.out.print(smb);
                }
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
