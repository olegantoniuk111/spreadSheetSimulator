package vin.gans.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 09.08.2016.
 */
public class DataModel {
    public DataModel(String filePath) throws IOException {
        this.data = buildDataModel(filePath);
        this.mappedData =buildMapFromModel(this.data);
    }

    private String[][] data;

    public Map<String, String> getMappedData() {
        return mappedData;
    }

    private  Map<String, String> mappedData;
    private static  char currentLetter = 'A';
    private static  int currentrow = 1;


    public String[][] getDataModel() {
        return data;
    }

    private static String[][] buildDataModel(String filepath) throws IOException {
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


    private static Map<String, String> buildMapFromModel(String[][] cellData){
        Map <String, String> simpleData = new LinkedHashMap<String, String>();
        for (int i = 0; i < cellData.length; i++) {
            for (int j = 0; j < cellData[i].length; j++) {
                String expression = cellData[i][j];
                String coordinate = currentLetter + String.valueOf(currentrow);
                simpleData.put(coordinate, expression);
                currentLetter++;
            }
            currentLetter = 'A';
            currentrow++;
        }

        return simpleData;
    }
}
