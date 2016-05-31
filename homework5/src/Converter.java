import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * Created by shido on 31.05.16.
 */

public class Converter {

    private String filename_input;
    private String filename_output;
    private Charset encoding_input;
    private Charset encoding_output;

    public Converter(){}

    public void setInputStream(String filename, String encoding) throws ConverterException {
        try {
            filename_input = filename;
            encoding_input = Charset.forName(encoding);
        }catch (UnsupportedCharsetException e){
            throw new ConverterException("Недопустимая кодировка");
        }
    }

    public void setOutputStream(String filename, String encoding) throws ConverterException {
        try {
            filename_output = filename;
            encoding_output = Charset.forName(encoding);
        }catch (UnsupportedCharsetException e){
            throw new ConverterException("Недопустимая кодировка");
        }
    }

    public void convert() throws ConverterException {

        Reader reader = null;
        Writer writer = null;
        FileInputStream myfile_in = null;
        FileOutputStream myfile_out = null;

        try {
            // Открытие бинарных потоков чтения и записи
            myfile_in = new FileInputStream(filename_input);
            myfile_out = new FileOutputStream(filename_output);

            // Открытие символьных потоков чтения и записи
            reader = new InputStreamReader(myfile_in, encoding_input);
            writer = new OutputStreamWriter(myfile_out, encoding_output);

            char[] buffer = new char[1024];
            int read;
            while ((read = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, read);
            }

        } catch (FileNotFoundException e) {
            throw new ConverterException("Файлы не найдены");
        } catch (IOException e) {
            throw new ConverterException("Ошибка ввода-вывода");
        } finally {

            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new ConverterException("Ошибка при закрытии потоков");
                }
            }
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new ConverterException("Ошибка при закрытии потоков");
                }
            }

            if(myfile_in != null){
                try {
                    myfile_in.close();
                } catch (IOException e) {
                    throw new ConverterException("Ошибка при закрытии потоков");
                }
            }
            if(myfile_out != null){
                try {
                    myfile_out.close();
                } catch (IOException e) {
                    throw new ConverterException("Ошибка при закрытии потоков");
                }
            }


        }
    }



}
