package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class IOFile {
    // doc ra
    public static <T> List <T> doc(String file){
        List<T> list=new ArrayList<>();
        try{
            ObjectInputStream o=new ObjectInputStream(new FileInputStream(file));
            list=(List<T>) o.readObject();
            o.close();
        }catch(IOException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return list;
    }
    //viet vao
     public static <T> void viet(String file, List<T> arr){
         try{
             ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream(file));
             o.writeObject(arr);
             o.close();
         }catch(IOException e){
             System.out.println(e);
         }
     }
}
