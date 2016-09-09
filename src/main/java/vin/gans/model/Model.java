package vin.gans.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by DELL on 09.08.2016.
 */
public class Model {
    private String[][] data;
    private String [][] coordinates;
    private  Map<String, String> mappedData;
    private static char currentLetter = 'A';
    private static int currentrow;

    public Model(String filePath) throws IOException {
        data = createDataModel(filePath);
        coordinates = createCoordinateModel(filePath);
        mappedData = createMappedData(data);

    }
    public Map<String, String> getMappedData() {
        return mappedData;
    }

    public  String[][] getData() {
        return data;
    }
    public String[][] getCoordinates() {
        return coordinates;
    }


    private  Map<String, String> createMappedData(String[][] cellData){
        currentrow = 1;
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
    private  String[][] createCoordinateModel(String filepath) throws IOException {
        BufferedReader bufferedReader = null;
        List <String[]> lines = new ArrayList<String[]>();
        List <String[]> coordinates = new ArrayList<String[]>();
        currentrow = 1;

        try {
            bufferedReader = new  BufferedReader(new FileReader(filepath));
            String line;
            while((line = bufferedReader.readLine()) != null){
                int columnSize = line.split(";").length;
                String[] buffer = new String[columnSize];
                for (int i = 0; i<columnSize;i++){
                    String coordinate = currentLetter + String.valueOf(currentrow);
                    buffer[i] = coordinate;
                    currentLetter++;
                }
                coordinates.add(buffer);
                currentLetter = 'A';
                currentrow++;
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bufferedReader.close();
        }

        String [][] data = new String[coordinates.size()][];
        coordinates.toArray(data);
        return  data;
    }
    private  String[][] createDataModel(String filepath) throws IOException {
        BufferedReader bufferedReader = null;
        List <String[]> lines = new ArrayList<String[]>();
        List <String[]> coordinates = new ArrayList<>();
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
