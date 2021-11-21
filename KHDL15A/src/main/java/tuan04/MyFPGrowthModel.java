/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan04;

import weka.associations.FPGrowth;
import weka.core.Instances;

/**
 *
 * @author Hao
 */
public class MyFPGrowthModel extends MyKnowkedgeModel{
    Instances newData;
    FPGrowth fp;

    public MyFPGrowthModel() {
    }

    public MyFPGrowthModel(String fileName, String m_options, String d_options) throws Exception {
        super(fileName, m_options, d_options);
        this.fp = new FPGrowth();
    }
    
    public void nineAssociationRules3() throws Exception{
        //Loc du lieu
        
        this.newData = convert2Binary(this.dataset);
        //thiet lap thong so
        fp.setOptions(this.model_options);
        //khai pha du lieu
        fp.buildAssociations(this.newData);
    }

    @Override
    public String toString() {
        return fp.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
