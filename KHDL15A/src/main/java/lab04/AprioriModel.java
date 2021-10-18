/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

import weka.associations.Apriori;

/**
 *
 * @author TOAN
 */
public class AprioriModel extends PreProcessModel{
    Apriori apriori;
    String[] model_option;
    public AprioriModel() {
        this.apriori = new Apriori();
    }
    public void mine_Model(String model_opt) throws Exception{
        this.model_option = weka.core.Utils.splitOptions(model_opt);
        apriori.setOptions(model_option);
        apriori.buildAssociations(dataset);
    }
    public String toStringRules(){
        return apriori.toString();
    }
     @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
