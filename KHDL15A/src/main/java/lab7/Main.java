/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import weka.core.Instances;

/**
 *
 * @author TOAN
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        /* Lab 9 */
           String filename = "E:\\data weka\\labor_train70.arff";
//           KMeans_Model kmeans = new KMeans_Model();
//           kmeans.setDataTrain(kmeans.loadData(filename));
//           kmeans.buildSimpleKMeans(3);
//           System.out.println(kmeans.output_Model());
//           System.out.println("==========Predict==========");
           String filetest = "E:\\data weka\\labor_test30.arff";
//           kmeans.predictCluster(kmeans.loadData(filetest));
        
           
           Hierarchical_Model hc = new Hierarchical_Model();
           hc.setDataTrain(hc.loadData(filename));
           hc.buildHierarchicalModel(3, 0); // 0:Single Link
           System.out.println(hc.outputMModel());
           System.out.println("==========Predict==========");
           hc.predictCluster(hc.loadData(filetest));
           
         
          /* Thực hành Lab 7 */
//        String data_train = "E:\\data weka\\mushroom.train70.arff";
//        String data_test = "E:\\data weka\\mushroom._test30_new.arff";
//        String data_predict = "E:\\data weka\\mushroom.unlabel.arff";
//        String pathfolder = "E:\\data weka\\";
//        
//        /*Xây dựng mô hình phân lớp NaviesBayes bằng weka với dữ liệu mushroom : Bài 1*/
//        String nb_option = "-batch-size 100";
//        NavieBayes_Model nb_model = new NavieBayes_Model();
//        nb_model.setDataTrain(nb_model.loadData(data_train));
//        nb_model.fitModel(nb_option);
//        nb_model.crossValidation(nb_model.loadData(data_test),10);
//        System.out.println(nb_model.outputEval());
//        // Xuất dữ liệu predict vào file mới 
//        Instances predData1 = nb_model.predictModel(nb_model.loadData(data_predict));
//        nb_model.saveARFF(predData1,pathfolder + "predict1.arff");
//        
//        
//        /*Xây dựng mô hình phân lớp DecisionTree J48  bằng weka với dữ liệu mushroom : Bài 2*/
//        String data_train2 = "E:\\data weka\\mushroom.train80.arff";
//        String data_test2 = "E:\\data weka\\mushroom.test20_new.arff";
//        String data_predict2 = "E:\\data weka\\mushroom.unlabel16.arff";
//        
//        String j48_option ="-C 0.25 -M 2";
//        DecisionTree_Model j48_model = new DecisionTree_Model();
//        j48_model.setDataTrain(j48_model.loadData(data_train2));
//        j48_model.fitModel(j48_option);
//        // Sử dụng crossValiadtion để đánh giá 
//        j48_model.crossValidation(j48_model.loadData(data_test2), 10 );
//        System.out.println(j48_model.outputEval());
//        // Sử dụng tập test để đánh giá 
//        j48_model.evalPerformance(j48_model.loadData(data_test2));
//        System.out.println(j48_model.outputEval());
//        
//        // Xuất dữ liệu predict vào file mới 
//        Instances predData2 = j48_model.predictModel(j48_model.loadData(data_predict2));
//        j48_model.saveARFF(predData2,pathfolder + "predict2.arff");
//        // lưu mô hình 
//        j48_model.saveModel(pathfolder+"j48model.model");
//        
//        // Tải mô hình lên 
//        DecisionTree_Model new_j48_model = new DecisionTree_Model();
//        new_j48_model.loadModel(pathfolder+"j48model.model");
//        //Sử dụng để phân lớp 
//        
//        Instances predDataEx2 = new_j48_model.predictModel(new_j48_model.loadData(data_predict2));
//        new_j48_model.saveARFF(predDataEx2,pathfolder +"predictEx2.arff");
//        
//        /*Xây dựng mô hình phân lớp KNN bằng weka với dữ liệu mushroom : Bài 3*/
//        String knn_option = "-K 5 -W 0 -A \"weka.core.neighboursearch.LinearNNSearch -A \\\"weka.core.EuclideanDistance -R first-last\\\"\"";
//        KNN_Model knn_model = new KNN_Model();
//        knn_model.setDataTrain(knn_model.loadData(data_train2));
//        knn_model.fitModel(knn_option);
//        // Sử dụng tập test để đánh giá 
//        knn_model.evalPerformance(knn_model.loadData(data_test2));
//        System.out.println(knn_model.outputEval());
//        // Sử dụng crossValidation để đánh giá 
//        knn_model.crossValidation(knn_model.loadData(data_test2), 10);
//        System.out.println(knn_model.outputEval());
//        
//        Instances predData3 = knn_model.predictModel(knn_model.loadData(data_predict2));
//        knn_model.saveARFF(predData3,pathfolder + "predict3.arff");

//        String filename = "C:\\Program Files\\Weka-3-8-5\\data\\weather.numeric.arff";
////        String opt = "-init 0 -max-candidates 100 -periodic-pruning 10000 -min-density 2.0 -t1 -1.25 -t2 -1.0 -N 2 -A \"weka.core.EuclideanDistance -R first-last\" -I 500 -num-slots 1 -S 10";
////        KMeans_Model kmeans = new KMeans_Model();
////        kmeans.setDataTrain(kmeans.loadData(filename));
////        kmeans.buildSimpleKMeans(7); 
////        System.out.println(kmeans.output_Model());
////        String opt2 = "-N 2 -L SINGLE -P -A \"weka.core.EuclideanDistance -R first-last";
//        Hierarchical_Model hie = new Hierarchical_Model();
//        hie.setDataTrain(hie.loadData(filename));
//        hie.buildHierarchicalModel(3,0);
//        System.out.println(hie.toString());
////      kmeans.predictCluster(kmeans.getDataTrain());

           
    }
    
}
