package vin.gans.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 09.08.2016.
 */
public class DataModel {

    public static String[][] buildDataModel(String filepath) throws IOException {
        BufferedReader bufferedReader = null;
        List <String[]> lines = new ArrayList<String[]>();
        try {
            bufferedReader = new  BufferedReader(new FileReader(filepath));
            String line;
            while((line = bufferedReader.readLine()) != null){
                lines.add(line.split(";"));
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bufferedReader.close();
        }

        String [][] data = new String[lines.size()][];
        lines.toArray(data);
        return  data;
     }
}
