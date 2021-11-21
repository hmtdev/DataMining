/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan04;


import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;

/**
 *
 * @author Hao
 */
public class MyKnowkedgeModel {
    DataSource source;
    Instances dataset;
    String[] model_options;//thông số cho mô hình
    String[] data_options;// thông số xử lý dữ liệu,...

    public MyKnowkedgeModel() {
    }

    public MyKnowkedgeModel(String fileName, String m_options, String d_options) throws Exception {
        this.source = new DataSource(fileName);
        this.dataset =  source.getDataSet();
        this.model_options = weka.core.Utils.splitOptions(m_options);
        this.data_options = weka.core.Utils.splitOptions(d_options);
        
    }
    // má chó này, t chạy ngon lành, m sửa giờ t thức khuya không, t sãi mỗi cái chữ N, méo hỉu
    public Instances removeData(Instances originalData) throws Exception{
        Remove remove = new Remove();
        remove.setOptions(data_options);
        remove.setInputFormat(dataset);
        return Filter.useFilter(originalData, remove);
    }
    
    public Instances convertData(Instances originalData) throws Exception{
        NumericToNominal n2n = new NumericToNominal();
        n2n.setOptions(data_options);
        n2n.setInputFormat(originalData);
        return Filter.useFilter(originalData, n2n);
    }
    public Instances convert2Binary(Instances originalData) throws Exception{
        NominalToBinary n2b = new NominalToBinary();
        n2b.setOptions(data_options);
        n2b.setBinaryAttributesNominal(true);
        n2b.setInputFormat(originalData);
        return Filter.useFilter(originalData, n2b);
    }
    
    public MyKnowkedgeModel(String fileName) throws Exception {
        this.source = new DataSource(fileName);
        this.dataset =  source.getDataSet();
    }

    public void saveData(String fileName) throws IOException{
        ArffSaver outData = new ArffSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(fileName));
        outData.writeBatch();
        System.out.println("Finished");
    }
    
    public void saveData2CSV(String fileName) throws IOException{
        CSVSaver outData = new CSVSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(fileName));
        outData.writeBatch();
        System.out.println("Converted");
    }
    
    @Override
    public String toString() {
        return dataset.toSummaryString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
