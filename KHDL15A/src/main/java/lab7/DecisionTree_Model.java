/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug.Random;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;


/**
 *
 * @author TOAN
 */
public class DecisionTree_Model extends Classification{
    J48 dct ;     
    String[] model_option;
    Evaluation eval;
    public DecisionTree_Model(){
        dct = new J48();
    }
    
    public void fitModel(String option) throws Exception{
        this.model_option = weka.core.Utils.splitOptions(option);
        Instances data = super.getDataTrain();
        data.setClassIndex(data.numAttributes()-1);
        dct.setOptions(model_option);
        dct.buildClassifier(data);
    }
    public Instances predictModel(Instances data) throws Exception{
        data.setClassIndex(data.numAttributes()-1);
        for (Instance i : data) {
            Double y_predict = dct.classifyInstance(i);
            i.setClassValue(y_predict);
        }
        return data;
    }
    public void crossValidation(Instances testData, int k) throws Exception{
        Instances trainData = this.getDataTrain();
        testData.setClassIndex(testData.numAttributes()-1);
        Random rd = new Random(1);
        eval = new Evaluation(trainData);
        eval.crossValidateModel(dct,testData, k, rd);
    }
    public void evalPerformance(Instances testData) throws Exception{
        Instances data = testData;
        data.setClassIndex(data.numAttributes()-1);
        eval = new Evaluation(this.getDataTrain());
        eval.evaluateModel(dct,data);
    }
    public void loadModel(String pathfile) throws Exception{
        dct = (J48) SerializationHelper.read(pathfile);
    }
    
    public void saveModel(String pathfile) throws Exception{
        SerializationHelper.write(pathfile, dct);
    }
    
    public String output_Model(){
        return dct.toString();
    }
    
    public String outputEval() throws Exception{
        String res = eval.toSummaryString() + eval.toMatrixString();
        return res;
    }
    
    
}

