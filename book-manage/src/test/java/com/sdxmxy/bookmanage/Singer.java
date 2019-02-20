package com.sdxmxy.bookmanage;


//饿汉
public class Singer {

    private Singer(){}

    private static Singer s=new Singer();

    public static Singer getInstance(){
        return s;
    }
}

//懒汉
class Singer2{
    private Singer2(){}

    private static Singer2 s=null;

    public static Singer2 getInstance(){
        if(s==null){
            synchronized(Singer2.class){
                if(s==null){
                    s=new Singer2();
                }
            }
        }
        return s;
    }
}