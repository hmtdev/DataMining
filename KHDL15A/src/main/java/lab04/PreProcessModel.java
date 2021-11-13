/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;


import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.RemoveByName;

/**
 *
 * @author TOAN
 */
public class PreProcessModel {
    DataSource dtsource;
    Instances dataset,test_data;
    String[] data_option;

    public PreProcessModel() {
        
    }
    
    
    public void load_data(String filename) throws Exception{
        DataSource dtSource =  new DataSource(filename);
        this.dataset = dtSource.getDataSet();
    }
    public void load_data_test(String filename) throws Exception{
        DataSource dtSource = new DataSource(filename);
        this.test_data = dtSource.getDataSet();
    }
    public void exportToCSV(String path_file) throws IOException{
        CSVSaver cs = new CSVSaver();
        cs.setInstances(dataset);
        cs.setFile(new File(path_file));
        cs.writeBatch();
    }
    public void exportToArff(String path_file) throws IOException{
        ArffSaver as = new ArffSaver();
        as.setInstances(this.dataset);
        as.setFile(new File(path_file));
        as.writeBatch();
    }
    public void convertNominalToBinary(Instances data , String data_opt) throws Exception{
        this.data_option = weka.core.Utils.splitOptions(data_opt);
        NominalToBinary num_to_bi = new NominalToBinary();
        num_to_bi.setOptions(data_option);
        num_to_bi.setBinaryAttributesNominal(true);
        num_to_bi.setInputFormat(data);
        this.dataset = Filter.useFilter(data, num_to_bi);
    }
    public void removeByName(String data_opt) throws Exception{
       this.data_option = weka.core.Utils.splitOptions(data_opt);
        RemoveByName rm = new RemoveByName();
        rm.setOptions(data_option);
        rm.setInputFormat(dataset);
        this.dataset = Filter.useFilter(dataset, rm);
    }
    @Override
    public String toString() {
        return dataset.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}