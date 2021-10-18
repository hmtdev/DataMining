/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;


/**
 *
 * @author TOAN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
    String data_paths ="C:\\Program Files\\Weka-3-8-5\\data\\supermarket.arff";
    AprioriModel model= new AprioriModel();
    model.load_data(data_paths);
    //System.out.println(model.toString());
    String rm_option = "-E department[0-9]+";
    model.removeByName(rm_option);
    //System.out.println(model.toString());
    System.out.println("=========================");
    String model_option = "-P 2 -I -1 -N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1";
    model.mine_Model(model_option);
    //System.out.println(model.toStringRules());
    String file_paths = "E:\\data weka\\export\\b.txt";
    model.exportFileRules(file_paths);
        System.out.println("Oke chưa ");
    }
    
}
