import java.io.File;

/**
 * Created by shido on 31.05.16.
 */
public class LoadData {
    public static void main(String[] args) {
        String fileNameIn = null;
        String encodingIn = null;
        String filenameOut = null;
        String encodingOut = null;

        try {
            fileNameIn =  args[0];
            encodingIn =  args[1];
            filenameOut =  args[2];
            encodingOut =  args[3];
            System.out.println(args[0]);
            System.out.println(args[1]);
            System.out.println(args[2]);
            System.out.println(args[3]);
        }
        catch (Exception e) {
            System.out.println("Неправильные аргументы командной строки");
            return;
        }

        try {

            Converter cnv = new Converter();
            cnv.setInputStream(fileNameIn, encodingIn);
            cnv.setOutputStream(filenameOut, encodingOut);
            cnv.convert();

        }
        catch (ConverterException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Программе совсем поплохело!");
        }
    }
}

//Параметры для запуска из командной строки: test_input.txt UTF-8 test_output.txt windows-1251
