/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Debug.Random;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;


/**
 *
 * @author TOAN
 */
public class NavieBayes_Model extends Classification{
    NaiveBayes nb ;     
    String[] model_option;
    Evaluation eval;
    public NavieBayes_Model(){
        nb = new NaiveBayes();
    }
    
    public void fitModel(String option) throws Exception{
        this.model_option = weka.core.Utils.splitOptions(option);
        Instances data = super.getDataTrain();
        data.setClassIndex(data.numAttributes()-1);
        nb.setOptions(model_option);
        nb.buildClassifier(data);
    }
    public Instances predictModel(Instances data) throws Exception{
        data.setClassIndex(data.numAttributes()-1);
        for (Instance i : data) {
            Double y_predict = nb.classifyInstance(i);
            i.setClassValue(y_predict);
        }
        return data;
    }
    public void crossValidation(Instances testData, int k) throws Exception{
        Instances trainData = this.getDataTrain();
        testData.setClassIndex(testData.numAttributes()-1);
        Random rd = new Random(1);
        eval = new Evaluation(trainData);
        eval.crossValidateModel(nb,testData, k, rd);
    }
    public void evalPerformance(Instances testData) throws Exception{
        Instances data = testData;
        data.setClassIndex(data.numAttributes()-1);
        eval = new Evaluation(this.getDataTrain());
        eval.evaluateModel(nb,data);
    }
    public void loadModel(String pathfile) throws Exception{
        nb = (NaiveBayes) SerializationHelper.read(pathfile);
    }
    
    public void saveModel(String pathfile) throws Exception{
        SerializationHelper.write(pathfile, nb);
    }
    
    public String output_Model(){
        return nb.toString();
    }
    
    public String outputEval() throws Exception{
        String res = eval.toSummaryString() + eval.toMatrixString();
        return res;
    }
    
    
}

