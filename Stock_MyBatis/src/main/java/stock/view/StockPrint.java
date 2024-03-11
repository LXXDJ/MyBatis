package stock.view;

import stock.model.dto.MemDTO;
import stock.model.dto.StockDTO;
import stock.model.dto.TransactionDTO;

import java.util.List;

public class StockPrint {
    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch (successCode){
            case "insertMember" : successMessage = "내정보 등록 성공"; break;
            case "addMoney" : successMessage = "입금 성공"; break;
            case "buyStock" : successMessage = "매수 성공"; break;
            case "delete" : successMessage = "삭제 성공"; break;
            case "transactStock" : successMessage = "주식 거래 성공"; break;
        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch (errorCode){
            case "insertMember" : errorMessage = "내정보 등록 실패"; break;
            case "allStockList" : errorMessage = "전체 주식 조회 실패"; break;
            case "memList" : errorMessage = "내정보 조회 실패"; break;
            case "addMoney" : errorMessage = "입금 실패"; break;
            case "buyStock" : errorMessage = "매수 실패"; break;
            case "searchStockList" : errorMessage = "주식 조회 실패"; break;
            case "transactionList" : errorMessage = "전체 거래내역 조회 실패"; break;
            case "delete" : errorMessage = "삭제 실패"; break;
            case "transactStock" : errorMessage = "주식 거래 실패"; break;
        }

        System.out.println(errorMessage);
    }

    public void printAllStockList(List<StockDTO> stockList) {
        for(StockDTO stock : stockList){
            System.out.println(stock);
        }
    }

    public void printAccount(List<MemDTO> memList) {
        for(MemDTO mem : memList){
            System.out.println(mem);
        }
    }

    public void printTransaction(List<StockDTO> myList) {
        for(StockDTO stock : myList){
            System.out.println(stock);
        }
    }

    public void printSearchStockList(List<StockDTO> searchStockList) {
        for(StockDTO stock : searchStockList){
            System.out.println(stock);
        }
    }

    public void printTransactionList(List<TransactionDTO> transactionList) {
        for(TransactionDTO transaction : transactionList){
            System.out.println(transaction);
        }
    }
}
