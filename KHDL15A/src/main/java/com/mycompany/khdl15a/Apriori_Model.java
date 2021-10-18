/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.khdl15a;

import java.io.File;
import java.io.IOException;
import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.*;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;

/**
 *
 * @author TOAN
 */
public class Apriori_Model {
    DataSource dtSource;
    Instances dataset, new_data;
    Apriori apriori;
    String[] model_option;
    String[] data_option;
//    String[] mine_opti
    public Apriori_Model(){
    this.apriori = new Apriori();}
    public Apriori_Model(String filename) throws Exception{
        this.dtSource = new DataSource(filename);
        this.dataset = dtSource.getDataSet();
        this.apriori = new Apriori();
    }
    public void mine_AR(String model_opt, String data_opt) throws Exception{
        this.new_data = convertNumericToNorminal(dataset, data_opt);
        this.model_option = weka.core.Utils.splitOptions(model_opt); // tachs thuoc tinh
        apriori.setOptions(model_option);// set tham so
        apriori.buildAssociations(new_data); // built thuat toan
    }
    public Instances convertNumericToNorminal(Instances data ,String data_opt) throws Exception{
        this.data_option = weka.core.Utils.splitOptions(data_opt);
        NumericToNominal num_to_nominal = new NumericToNominal();
        num_to_nominal.setOptions(this.data_option);
        num_to_nominal.setInputFormat(data);
        return Filter.useFilter(data, num_to_nominal); // bien doi 
    }
    public void exportToArff(String path_file) throws IOException{
        ArffSaver as = new ArffSaver();
        as.setInstances(this.dataset);
        as.setFile(new File(path_file));
        as.writeBatch();
    } //xong 
    public void exportToCSV(String path_file) throws IOException{
        CSVSaver cs = new CSVSaver();
        cs.setInstances(dataset);
        cs.setFile(new File(path_file));
        cs.writeBatch();
    } // xong 
    @Override
    public String toString() {
        return dataset.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    public String toStringApriori(){
        return apriori.toString();
    }
    
}
