/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author TOAN
 */
public class Classification {
    DataSource dt ;
    private Instances data_train,data_test;
    String[] option;
    public Classification (){
      
    }
    
    public void setDataTrain(Instances data) throws Exception{
        this.data_train = data;
    }
    public void setDataTest(Instances data) throws Exception{
        this.data_test = data;
    }
    
    public Instances getDataTrain(){
        return this.data_train;
    }
    public Instances getDataTest(){
        return this.data_test;
    }
    
    public Instances loadData(String filename) throws Exception{
        dt = new DataSource(filename);
        return dt.getDataSet();
    }
    public Instances loadCSV(String filename) throws IOException{
        CSVLoader cl = new CSVLoader();
        cl.setFile(new File(filename));
        return cl.getDataSet();
    }
    
    public void saveCSV(Instances data , String filename) throws IOException{
        CSVSaver cs = new CSVSaver();
        cs.setInstances(data);
        cs.setFile(new File(filename));
        cs.writeBatch();
    }
    public void saveARFF(Instances data, String filename) throws IOException{
        ArffSaver as = new ArffSaver();
        as.setInstances(data);
        as.setFile(new File(filename));
        as.writeBatch();
        System.out.println(String.format("Save with path  = %s",filename));
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
