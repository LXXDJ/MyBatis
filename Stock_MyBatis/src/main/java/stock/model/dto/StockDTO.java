package stock.model.dto;

public class StockDTO {
    private String title;
    private int count;
    private int price;

    public StockDTO(){}

    public StockDTO(String title, int count, int price) {
        this.title = title;
        this.count = count;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "StockDTO{" +
                "title='" + title + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
