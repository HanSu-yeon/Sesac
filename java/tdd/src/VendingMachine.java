public class VendingMachine {
    private int money=0;
    private int bill1000=0;
    private int coin500=0;
    private int coin100=0;
    private int coin50=0;
    private int coin10=0;

    public void inputMoney(int moeny) {
        this.money+=moeny;
    }

    public int showMoney() {
        return this.money;
    }

    public void chooseProduct(int price) {
        this.money -=price;

    }

    public int billsToRetrun() {
        int bills = this.money / 1000;
        this.money -= 1000 * bills;
        return bills;
    }

    public int coin500ToReturn() {
        int coins = this.money / 500;
        this.money -=500*coins;
        return coins;

    }

    public int coin100ToReturn() {
        int coins = this.money / 100;
        this.money -=100*coins;
        return coins;

    }

    public int coin50ToReturn() {
        int coins = this.money / 50;
        this.money -=50*coins;
        return coins;
    }

    public int coin10ToReturn() {
        int coins = this.money / 10;
        this.money -=10*coins;
        return coins;
    }

    public void calculate(){
        this.bill1000 = this.billsToRetrun();
        this.coin500 = this.coin500ToReturn();
        this.coin100 = this.coin100ToReturn();
        this.coin50 = this.coin50ToReturn();
        this.coin10 = this.coin10ToReturn();
    }
    public void display(){
        System.out.println("1000원:"+this.bill1000);
        System.out.println("500원:"+this.coin500);
        System.out.println("100원:"+this.coin100);
        System.out.println("50원:"+this.coin50);
        System.out.println("10원:"+this.coin10);
    }
}
