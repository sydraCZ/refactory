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
    private int _priceCode;       // 價格

    public Movie(String title, int priceCode){
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle() {
        return _title;
    }


    public double getCharge(int daysRented) {
        double result = 0;
        switch(_priceCode){   // 取得影片出租價格
            case Movie.REGULAR:                     // 普通片
                result += 2;
                if(daysRented>2)
                    result += (daysRented-2)*1.5;
                break;

            case Movie.NEW_RELEASE:         // 新片
                result += daysRented*3;
                break;

            case Movie.CHILDREN:           // 兒童片
                result += 1.5;
                if(daysRented>3)
                    result += (daysRented-3)*1.5;
                break;
        }
        return result;
    }
    public int getFrequentRenterPoints(int daysRented){
        // add bonus for a two day new release rental
        if ((_priceCode == Movie.NEW_RELEASE) && daysRented > 1)
            return 2;
        else
            return 1;
    }
}

