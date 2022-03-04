public class Movie {
    private int sumOfRate=0;
    private int countOfRate =0;

    public int averateRate(){
        if(this.countOfRate ==0)
            return 0;

        return this.sumOfRate/this.countOfRate;
    }

    public void rate(int i){
        this.countOfRate++;
        this.sumOfRate+=i;

    }
}
