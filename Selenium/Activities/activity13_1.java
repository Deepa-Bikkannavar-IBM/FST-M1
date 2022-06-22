package Activities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;



public class activity13_1 {

    public static void main(String args[]) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader("C://Users//003AY8744//Desktop//csvfile.csv"));
        List<String[]> list = reader.readAll();
        System.out.println("Size of the list is :"+list.size());

        Iterator<String[]> itr = list.iterator();
        while (itr.hasNext()){
            String[] str = itr.next();
            for (int i=0; i< str.length;i++){
                System.out.println(" "+str[i]);
            }
            System.out.println(" ");
        }
        reader.close();
    }
}
