/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import weka.classifiers.evaluation.Evaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author TOAN
 */
public class KMeans_Model extends Classification{
    SimpleKMeans sk;
    String[] model_option;
    Evaluation eval;
    public KMeans_Model(){
        this.sk = new SimpleKMeans();
    }
    
    public void buildSimpleKMeans(int k) throws Exception{
//    this.model_option = weka.core.Utils.splitOptions(option);
    Instances data = this.getDataTrain();
    sk.setOptions(model_option);
    sk.setNumClusters(k);
    sk.setDistanceFunction(new EuclideanDistance());
    sk.buildClusterer(data);
    }
    
    public void predictCluster(Instances data) throws Exception
    {
        for (Instance instance : data){
        int predict = sk.clusterInstance(instance);
            System.out.println("Instace" + instance.toString() + " thuoc vao cluster :  :  "+ predict);
        }
    }
    public String output_Model(){
        return sk.toString();
    }
}
