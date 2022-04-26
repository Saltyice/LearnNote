package collection;

public class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return ""+year+month+day;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate){
            MyDate myDate = (MyDate) o;
            int result =(this.year*10000+this.month*100+this.day)-(myDate.year*10000+myDate.month*100+myDate.day) ;
            if(result>0){
                return 1;
            } else if (result<0){
                return -1;
            }else {
                return 0;
            }
        }
        throw new RuntimeException();
    }
}
