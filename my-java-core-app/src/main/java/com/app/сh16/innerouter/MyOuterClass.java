package com.app.сh16.innerouter;

public class MyOuterClass {
    private int n=10;

    public void doAction(int param){
        System.out.println("param="+param);
    }

    private static int m=20;

    public static void doStaticAction(int param){
        System.out.println("param="+param);
    }



    public class MyInnerA{
        private int n = 100;

        public void myMethod(){
            //MyOuterClass.this.n++;
            doAction(n);
            //doAction(MyOuterClass.this.n);
            doStaticAction(m);
        }


    }

    public static class MyInnerStaticA {

        public void method(){
            //MyOuterClass.this.n++;
            m++;
            doStaticAction(m);
        }
    }

    protected class MyInnerB{

    }

    class MyInnerC {

    }

    private class MyInnerD {

    }



}
