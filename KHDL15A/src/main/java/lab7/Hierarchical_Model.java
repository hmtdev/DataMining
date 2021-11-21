/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import weka.clusterers.HierarchicalClusterer;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SelectedTag;

/**
 *
 * @author TOAN
 */
public class Hierarchical_Model extends Classification{
    HierarchicalClusterer hc  ;
    String[] model_option;
    public Hierarchical_Model(){
        this.hc = new HierarchicalClusterer();
    }
    
    public void buildHierarchicalModel(int k,int linktype) throws Exception{
        Instances data = this.getDataTrain();
//        this.model_option = weka.core.Utils.splitOptions(option);
        hc.setLinkType(new SelectedTag(linktype,HierarchicalClusterer.TAGS_LINK_TYPE));
        hc.setNumClusters(k);
        hc.buildClusterer(data);
    }
    public void predictCluster(Instances data) throws Exception
    {
        for (Instance instance : data){
        int predict = hc.clusterInstance(instance);
            System.out.println("Instace" + instance.toString() + " thuoc vao cluster :  "+ predict);
        }
    }
    
    public String outputMModel() {
        return hc.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
