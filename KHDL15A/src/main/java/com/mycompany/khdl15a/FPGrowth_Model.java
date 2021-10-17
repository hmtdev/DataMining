/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.khdl15a;

import weka.associations.FPGrowth;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;

/**
 *
 * @author TOAN
 */
public class FPGrowth_Model {
    ConverterUtils.DataSource dtSource;
    Instances dataset, new_data;
    FPGrowth fpgrowth;
    String[] model_option;
    String[] data_option;
//    String[] mine_opti
    public FPGrowth_Model(){
    this.fpgrowth = new FPGrowth();}
    public FPGrowth_Model(String filename) throws Exception{
        this.dtSource = new ConverterUtils.DataSource(filename);
        this.dataset = dtSource.getDataSet();
        this.fpgrowth = new FPGrowth();
    }
    public void mine_AR(String model_opt, String data_opt) throws Exception{
        this.new_data = convertNumericToNorminal(dataset, data_opt);
        this.model_option = weka.core.Utils.splitOptions(model_opt); // tachs thuoc tinh
        fpgrowth.setOptions(model_option);// set tham so
        fpgrowth.buildAssociations(new_data); // built thuat toan
    }
    public Instances convertNumericToNorminal(Instances data ,String data_opt) throws Exception{
        this.data_option = weka.core.Utils.splitOptions(data_opt);
        NumericToNominal num_to_nominal = new NumericToNominal();
        num_to_nominal.setOptions(this.data_option);
        num_to_nominal.setInputFormat(data);
        return Filter.useFilter(data, num_to_nominal); // bien doi 
    }
    public Instances nomialtoBinomial(Instances data , String data_opt) throws Exception{
        this.data_option = weka.core.Utils.splitOptions(data_opt);
        NominalToBinary num_to_binary = new NominalToBinary();
        num_to_binary.setOptions(data_option);
        return Filter.useFilter(data, num_to_binary);
    }
    @Override
    public String toString(){
        return dataset.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    public String toStringFPGrowth(){
        return fpgrowth.toString();
    }
    
}
