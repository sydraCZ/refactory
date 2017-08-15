package cyd.refactor;

/**
 * Created by Administrator on 2017/8/15.
 */
public class Rental {
    private Movie _movie;         // 影片
    private int _daysRented;              // 租期

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getCharge()
    {
        double result = 0;
        switch(this.getMovie().getPriceCode()){   // 取得影片出租價格
            case Movie.REGULAR:                     // 普通片
                result += 2;
                if(this.getDaysRented()>2)
                    result += (this.getDaysRented()-2)*1.5;
                break;

            case Movie.NEW_RELEASE:         // 新片
                result += this.getDaysRented()*3;
                break;

            case Movie.CHILDREN:           // 兒童片
                result += 1.5;
                if(this.getDaysRented()>3)
                    result += (this.getDaysRented()-3)*1.5;
                break;
        }
        return result;
    }

}
