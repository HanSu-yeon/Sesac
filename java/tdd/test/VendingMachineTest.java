import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {
    private VendingMachine vm;

    @Before
    public void setup(){
        vm = new VendingMachine();
    }

    @Test
    public void test_잔액을_보여준다(){
        vm.inputMoney(2000);
        assertEquals(2000, vm.showMoney());
    }

    @Test
    public void test_상품을_선택하면_입금액에서_상품가격을_차감한다(){
        vm.inputMoney(2000);
        vm.chooseProduct(1350);
        assertEquals(2000-1350,  vm.showMoney());
    }

    @Test
    public void test_잔액이_1000원이상인_경우_1000원지폐를_지급한다(){
        vm.inputMoney(3000);
        vm.chooseProduct(1350);
        //지급되어야 할 지폐의 개수
        int bills = (3000 - 1350) / 1000;
        assertEquals(bills ,vm.billsToRetrun());

        int coins = (3000 - 1350) - (1000 * bills);
        assertEquals(coins, vm.showMoney());
    }


    @Test
    public void test_잔액이_1000원미만인_경우_동전으로_지급한다(){
        vm.inputMoney(2000);
        vm.chooseProduct(1350);

        assertEquals(0,vm.billsToRetrun());
    }

    //각각의 동전을 최소 개수를 사용 --> 테스트 메서드 여러개로 나눈다
    @Test
    public void test_잔액이_1000원미만_500원이상인_경우_500원동전_지급(){
        vm.inputMoney(2000);
        vm.chooseProduct(1350);
        int coin500=(2000-1350)/500;
        assertEquals(coin500,vm.coin500ToReturn());
        assertEquals((2000-1350)-(500*coin500),vm.showMoney());
        assertEquals(150,vm.showMoney());
    }
    @Test
    public void test_잔액이_500원미만인_경우_500원동전_없음(){
        vm.inputMoney(2000);
        vm.chooseProduct(1850);

        assertEquals(0,vm.coin500ToReturn());
    }

    @Test
    public void test_잔액이_500원미만_100원이상인_경우_100원동전_지급(){
        vm.inputMoney(1000);
        vm.chooseProduct(650);

        int coin100=(1000-650)/100;
        assertEquals(coin100,vm.coin100ToReturn());

        assertEquals(50,vm.showMoney());
    }
    @Test
    public void test_잔액이_100원미만인_경우_100원동전_없음(){
        vm.inputMoney(1000);
        vm.chooseProduct(950);

        assertEquals(0,vm.coin100ToReturn());
    }

    @Test
    public void test_잔액이_100원미만_50원이상인_경우_50원동전_지급(){
        vm.inputMoney(100);
        vm.chooseProduct(15);
        int coin50=(100-15)/50;
        assertEquals(coin50,vm.coin50ToReturn());
        assertEquals(35,vm.showMoney());
    }

    @Test
    public void test_잔액이_50원미만인_경우_50원동전_없음(){
        vm.inputMoney(100);
        vm.chooseProduct(75);

        assertEquals(0,vm.coin50ToReturn());
    }

    @Test
    public void test_잔액이_50원미만인_경우_10원동전_지급(){
        vm.inputMoney(100);
        vm.chooseProduct(80);

        int coin10 = (100-80)/10;
        assertEquals(coin10,vm.coin10ToReturn());

        assertEquals(0,vm.showMoney());
    }


    @Test
    public void test_잔액이_1000원_이상인_경우(){
        vm.inputMoney(3000);
        vm.chooseProduct(1340);

        vm.calculate();
        vm.display();
        /*
         * 1000원: 1개
         * 500원: 1개
         * 100원: 1개
         * 50원: 1개
         * 10원: 1개

         */

    }
    @Test
    public void test_잔액이_1000원_미만인_경우(){
        vm.inputMoney(2000);
        vm.chooseProduct(1340);

        vm.calculate();
        vm.display();
    }
}