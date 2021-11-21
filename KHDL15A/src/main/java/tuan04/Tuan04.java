/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tuan04;

/**
 *
 * @author Hao
 */
public class Tuan04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//        MyKnowkedgeModel model = new MyKnowkedgeModel("D:\\Down\\App\\Weka\\Weka-3-8-5\\data\\iris.arff");
//        System.out.println(model);
//        model.saveData("D:\\BaiTap\\KhaiThacDuLieu&UngDung\\Data04\\iris.arff");
//        model.saveData2CSV("D:\\BaiTap\\KhaiThacDuLieu&UngDung\\Data04\\iris.csv");
//
//            MyAprioriModel model = new MyAprioriModel("D:\\Down\\App\\Weka\\Weka-3-8-5\\data\\supermarket.arff",
//                                    "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1",
//                                    "-R 1-9,11,57,70,79-81,88-89,98,100-102,107-114,116-120,122-130,137-179,189,192-199,201-216");
//        model.nineAssociationRules();
//        System.out.println(model);


//        MyAprioriModel model = new MyAprioriModel("D:\\Down\\App\\Weka\\Weka-3-8-5\\data\\weather.numeric.arff",
//                                    "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1",
//                                    "-R 2-3");
//        model.nineAssociationRules2();
//        System.out.println(model);


//          MyFPGrowthModel model = new MyFPGrowthModel("D:\\Down\\App\\Weka\\Weka-3-8-5\\data\\supermarket.arff",
//                                    "-P 2 -I -1 -N 10 -T 0 -C 0.8 -D 0.05 -U 1.0 -M 0.2",
//                                    "-R 1-9,11,57,70,79-81,88-89,98,100-102,107-114,116-120,122-130,137-179,189,192-199,201-216");
//          model.nineAssociationRules3();
//          System.out.println(model);


            MyFPGrowthModel model = new MyFPGrowthModel("D:\\Down\\App\\Weka\\Weka-3-8-5\\data\\weather.nominal.arff",
                                    "-P 2 -I -1 -N 10 -T 0 -C 0.7 -D 0.05 -U 1.0 -M 0.2",
                                    "-N -R first-last");
            model.nineAssociationRules3();
            System.out.println(model);
            //cái nào
    }
    
}
