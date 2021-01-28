import java.util.*;

class ageException extends Exception{
    int detail;
    ageException(int a){
        detail = a;
    }
    public String toString(){
        return "Exception :"+detail+" The enterred age has a problem";
    }
}
class Father{
    int age;
    Father(int age) throws ageException{
        this.age = age;
    }
    void display(){
        System.out.println("Father's age:"+this.age);
    }
}

class Son extends Father{
    Father f;
    Son(int age,Father f) throws ageException{
        super(age);
        this.f = f;
    }
    void display(){
        this.f.display();
        System.out.println("Son's age:"+this.age);
    }
}

public class Main{
    public static void main(String[] args) throws ageException{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Father Age");
	Father f = new Father(input.nextInt());
        System.out.println("Enter Son Age");
	Son s = new Son(input.nextInt(),f);
        try{
            if(s.age>=f.age)
                throw new ageException(s.age);
            if(f.age<=0)
                throw new ageException(f.age);
            if(s.age<=0)
                throw new ageException(s.age);
            s.display();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
