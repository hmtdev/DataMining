/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan04;

import weka.associations.Apriori;
import weka.core.Instances;

/**
 *
 * @author Hao
 */
public class MyAprioriModel extends MyKnowkedgeModel{
    Apriori apriori;
    Instances newData;

    public MyAprioriModel() {
    }

    public MyAprioriModel( String fileName, String m_options, String d_options) throws Exception {
        super(fileName, m_options, d_options);
        this.apriori = new Apriori();
    }
    
    public void nineAssociationRules() throws Exception{
        //Lọc dữ liệu
        this.newData = removeData(this.dataset);
        //Thiết lập thống kê cho thông số model Apriori
        apriori.setOptions(this.model_options);
        //Khai phá luật kết hợp bằng thuật toán Apriori
        apriori.buildAssociations(this.newData);
    }
    public void nineAssociationRules2() throws Exception{
        //Lọc dữ liệu
        this.newData = convertData(this.dataset);
        //Thiết lập thống kê cho thông số model Apriori
        apriori.setOptions(this.model_options);
        //Khai phá luật kết hợp bằng thuật toán Apriori
        apriori.buildAssociations(this.newData);
    }

    @Override
    public String toString() {
        return apriori.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
