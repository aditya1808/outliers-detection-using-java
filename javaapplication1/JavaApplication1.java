/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author DELL
 */
class Box{
           int weight;
           int width;
           int height;
       
Box(int w,int h,int we){
width=w;
height=h;
weight=we;
}

Box(int w,int h){
width=w;
height=h;
weight=20;
}
Box(){
 width=10;
 height=10;
 weight=20;
}
}

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("hello everybody");
       
       Box mybox=new Box();
       int vol;
       int vol1;
       int vol2;
       mybox.width=10;
       mybox.height=10;
       mybox.weight=10;
       
       vol=mybox.width+mybox.height+mybox.weight;
       
       System.out.println("volume is "+vol);
       
    Box testbox1=new Box(10,20,30);
    
       
    vol1=testbox1.width+testbox1.height+testbox1.weight;
    System.out.println("volume is "+vol1);
    
    Box testbox2=new Box(10,20);
    
    vol2=testbox2.width+testbox2.height+testbox2.weight;
    System.out.println("volume is "+vol2);
    
    }
    
    
}
