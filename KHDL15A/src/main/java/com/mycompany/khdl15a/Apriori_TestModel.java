/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.khdl15a;

import weka.core.Instances;

/**
 *
 * @author TOAN
 */
public class Apriori_TestModel {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //String data_paths ="C:\\Program Files\\Weka-3-8-5\\data\\weather.numeric.arff";
        //Apriori_Model ar_model = new Apriori_Model(data_paths);// "E:\\data weka\\apriorest.arff"
        //System.out.println(ar_model.toString());
        //String apriori_opt = "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1";
        //String data_option = "-R 2-3"; 
        //ar_model.mine_AR(apriori_opt,data_option);
        //System.out.println(ar_model.toStringApriori());
        //System.out.println("Xuat file ne : ");
        //String path_file = "E:\\data weka\\export\\a.arff";
        //String path_file = "E:\\data weka\\export\\a.csv";
        //ar_model.exportToCSV(path_file);
        //System.out.println("Ok xong roi ne");
        // ===============================================
        String data_paths = "C:\\Program Files\\Weka-3-8-5\\data\\supermarket.arff";
        String model_opt = "-P 2 -I -1 -N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1";
        String data_opt = "-E department[0-9]+";
        FPGrowth_Model fpgrowth = new FPGrowth_Model(data_paths);
        fpgrowth.mine_AR(model_opt,data_opt);
        
        System.out.println(fpgrowth.toStringFPGrowth());
        
             
    }
    
}
