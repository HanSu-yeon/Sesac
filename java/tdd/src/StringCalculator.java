import com.sun.jdi.IntegerType;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int add(String number){
        number = number.trim();
        if("".equals(number))
            return 0;


        String delimeter = ",|\n";
        String data = number;
        if(number.startsWith("//")) { /*"//구분문자\n데이터" 형식인 경우*/
            delimeter = number.substring(2, number.indexOf("\n")); /*구분문자를 추출*/
            data = number.substring(number.indexOf("\n") + 1); /*데이터를 추출*/
        }

        //음수를 저장할 리스트 변수를 정의
        List negativeNumbers = new ArrayList();

        String[] numbers = data.split(delimeter);
        int sum=0;
        for(String snum : numbers ){
            int i =Integer.parseInt(snum);
            if(i<0){
                negativeNumbers.add(i);
                continue;
            }
            if(i>=1000) continue;
            sum += i;

        }

        if(negativeNumbers.size()>0){
            throw new RuntimeException("Negative not allowed : " + negativeNumbers.toString());
        }
        return sum;
    }
}