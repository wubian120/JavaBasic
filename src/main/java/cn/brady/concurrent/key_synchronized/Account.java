package cn.brady.concurrent.key_synchronized;




public class Account {

    String name;
    float amount;

    public Account(String name, float amount){
        this.name = name;
        this.amount = amount;
    }
    /**存*/
    public void deposit(float amt){
        amount += amt;
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void withdraw(float amt){
        amount -= amt;

        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public float getBalance(){
        return amount;
    }


}
