package stock.model.dto;

public class TransactionDTO {
    private int code;
    private String name;
    private String title;
    private int price;
    private int count;

    public TransactionDTO(){}
    public TransactionDTO(String name, String title, int price, int count) {
        this.name = name;
        this.title = title;
        this.price = price;
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
