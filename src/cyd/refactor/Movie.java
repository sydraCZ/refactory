package cyd.refactor;

/**
 * Created by Administrator on 2017/8/15.
 */
//  Refactoring, a First Example, step1, (~p5)

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;        // 名稱
    private Price _priceCode;       // 價格

    public Movie(String title, int priceCode){
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _priceCode.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch(arg){   // 取得影片出租價格
            case Movie.REGULAR:                     // 普通片
                _priceCode = new RegularPrice();
                break;

            case Movie.NEW_RELEASE:         // 新片
                _priceCode = new NewReleasePrice();
                break;

            case Movie.CHILDREN:           // 兒童片
                _priceCode = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return _title;
    }


    public double getCharge(int daysRented) {
        return _priceCode.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented){
        return _priceCode.getFrequentRenterPoints(daysRented);
    }
}

abstract class Price {

    abstract int getPriceCode();
    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}
class ChildrenPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDREN;
    }
    double getCharge(int daysRented) {
        double result = 1.5;
        if(daysRented>3)
            result += (daysRented-3)*1.5;
        return result;
    }
}
class RegularPrice extends Price {
    int getPriceCode() {
        return Movie.REGULAR;
    }
    double getCharge(int daysRented) {
        double result = 2;
        if(daysRented>2)
            result += (daysRented-2)*1.5;
        return result;
    }
}
class NewReleasePrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
    double getCharge(int daysRented) {
        return daysRented*3;
    }
    int getFrequentRenterPoints(int daysRented){
        // add bonus for a two day new release rental
        return daysRented > 1?2:1;
    }
}

