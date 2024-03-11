package stock.view;

import stock.controller.StockController;
import stock.model.dto.MemDTO;
import stock.model.dto.StockDTO;
import stock.model.dto.TransactionDTO;

import java.util.Scanner;

public class StockMenu {
    private Scanner sc = new Scanner(System.in);
    StockController stockController = new StockController();

    public StockMenu(){}
    public void mainPage(){
        System.out.println("주식 프로그램 실행");

        stockController.registerMember(insertMember());

        label: while(true){
            System.out.println("=== 메인 메뉴 ===\n0. 프로그램 종료\n1. 전체 주식보기\n2. 내 정보\n3. 현금 추가입금\n4. 주식 구매\n5. 주식 판매");
            System.out.println("6. 주식 검색\n7. 전체 거래내역 보기\n8. 거래되는 주식 삭제");
            System.out.print("메뉴 선택 : ");
            String index = sc.nextLine();

            switch (index){
                case "0" : stockController.truncateData();
                    System.out.println("프로그램 종료");
                    break;
                case "1" : stockController.viewallStock();
                    continue label;
                case "2" : stockController.showAccount(findMember());
                    continue label;
                case "3" : stockController.addMoney(updateMoney());
                    continue label;
                case "4" : stockController.transactStock(buyInfo());
                    continue label;
                case "5" : stockController.transactStock(sellInfo());
                    continue label;
                case "6" : stockController.searchStock(inputTitle());
                    continue label;
                case "7" : stockController.showTransaction();
                    continue label;
                case "8" : stockController.deleteStock(inputTitle());
                    continue label;
                default:
                    System.out.println("보기중에서 선택해주세요.");
                    continue label;
            }
            break;
        }
    }

    private MemDTO insertMember() {
        System.out.print("아이디 입력 : ");
        String id = sc.nextLine();
        System.out.print("이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("현금 입금 : ");
        int money = sc.nextInt();
        sc.nextLine();

        MemDTO memDTO = new MemDTO();
        memDTO.setId(id);
        memDTO.setName(name);
        memDTO.setMoney(money);

        return memDTO;
    }

    private MemDTO updateMoney() {
        System.out.print("아이디 입력 : ");
        String id = sc.nextLine();
        System.out.print("현금 입금 : ");
        int money = sc.nextInt();
        sc.nextLine();

        MemDTO memDTO = new MemDTO();
        memDTO.setId(id);
        memDTO.setMoney(money);

        return memDTO;
    }

    private StockDTO inputTitle() {
        System.out.print("검색 주식명 : ");
        String title = sc.nextLine();

        StockDTO stockDTO = new StockDTO();
        stockDTO.setTitle(title);

        return stockDTO;
    }

    private TransactionDTO buyInfo() {
        MemDTO memDTO = findMember();
        StockDTO stockDTO = findPrice();

        System.out.print("주식 개수 : ");
        int count = sc.nextInt();
        sc.nextLine();

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setName(memDTO.getName());
        transactionDTO.setTitle(stockDTO.getTitle());
        transactionDTO.setPrice(stockDTO.getPrice());
        transactionDTO.setCount(count);

        return transactionDTO;
    }

    private TransactionDTO sellInfo() {
        MemDTO memDTO = findMember();
        StockDTO stockDTO = findPrice();

        System.out.print("주식 개수 : ");
        int count = sc.nextInt();
        sc.nextLine();

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setName(memDTO.getName());
        transactionDTO.setTitle(stockDTO.getTitle());
        transactionDTO.setPrice(stockDTO.getPrice());
        transactionDTO.setCount(-count);

        return transactionDTO;
    }

    private MemDTO findMember() {
        System.out.print("아이디 입력 : ");
        String id = sc.nextLine();

        MemDTO memDTO = new MemDTO();
        memDTO.setId(id);

        MemDTO memName = stockController.findMemebr(memDTO);
        memDTO.setName(memName.getName());

        return memDTO;
    }

    private StockDTO findPrice() {
        System.out.print("주식명 : ");
        String title = sc.nextLine();

        StockDTO stockDTO = new StockDTO();
        stockDTO.setTitle(title);

        StockDTO stockPrice = stockController.findPrice(stockDTO);
        stockDTO.setPrice(stockPrice.getPrice());

        return stockDTO;
    }
}
