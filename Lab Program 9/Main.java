class Thread1 implements Runnable{
    Thread t;
    String name;
    Thread1(String name){
        this.name = name;
        t = new Thread(this,this.name);
        t.start();
    }
    public void run(){
        try{
            for(int i=0;i<20;i++){
                System.out.println("CSE");
                Thread.sleep(2000);
            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}

class Thread2 implements Runnable{
    Thread t;
    String name;
    Thread2(String name){
        this.name = name;
        t = new Thread(this,this.name);
        t.start();
    }
    public void run(){
        try{
            for(int i=0;i<5;i++){
                System.out.println("BMS college of Engineering");
                Thread.sleep(10000);
            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}

class Main{
    public static void main(String[] args){
        Thread2 obj2 = new Thread2("College name");
	Thread1 obj1 = new Thread1("Dept. name");
        
        try{
            obj1.t.join();
            obj2.t.join();
        }catch(Exception e){
            System.out.println("Interrupted");
        }
    }
}
