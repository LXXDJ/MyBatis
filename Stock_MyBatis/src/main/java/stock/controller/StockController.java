package stock.controller;

import stock.model.dto.MemDTO;
import stock.model.dto.StockDTO;
import stock.model.dto.TransactionDTO;
import stock.model.service.StockService;
import stock.view.StockPrint;

import java.util.List;

public class StockController {
    private final StockPrint stockPrint;
    private final StockService stockService;

    public StockController(){
        stockPrint = new StockPrint();
        stockService = new StockService();
    }

    public void registerMember(MemDTO memDTO) {
        if(stockService.registerMember(memDTO)){
            stockPrint.printSuccessMessage("insertMember");
        }else{
            stockPrint.printErrorMessage("insertMember");
        }
    }

    public void truncateData() {
        stockService.truncateData();
    }

    public void viewallStock() {
        List<StockDTO> stockList = stockService.viewallStock();

        if(stockList != null){
            stockPrint.printAllStockList(stockList);
        }else{
            stockPrint.printErrorMessage("allStockList");
        }
    }

    public void showAccount() {
        List<MemDTO> memList = stockService.showAccount();

        if(memList != null){
            stockPrint.printAccount(memList);
        }else{
            stockPrint.printErrorMessage("memList");
        }
    }

    public void addMoney(MemDTO memDTO) {
        if(stockService.addMoney(memDTO)){
            stockPrint.printSuccessMessage("addMoney");
        }else{
            stockPrint.printErrorMessage("addMoney");
        }
    }

    public void searchStock(StockDTO stockDTO) {
        List<StockDTO> searchStockList = stockService.searchStock(stockDTO);

        if(searchStockList != null){
            stockPrint.printSearchStockList(searchStockList);
        }else{
            stockPrint.printErrorMessage("searchStockList");
        }
    }

    public void showTransaction() {
        List<TransactionDTO> transactionList = stockService.showTransaction();

        if(transactionList != null){
            stockPrint.printTransactionList(transactionList);
        }else{
            stockPrint.printErrorMessage("transactionList");
        }
    }

    public void deleteStock(StockDTO stockDTO) {
        if(stockService.deleteStock(stockDTO)){
            stockPrint.printSuccessMessage("delete");
        }else{
            stockPrint.printSuccessMessage("delete");
        }
    }

    public MemDTO findMemebr(MemDTO memDTO) {
        return stockService.findMemebr(memDTO);
    }

    public StockDTO findPrice(StockDTO stockDTO) {
        return stockService.findPrice(stockDTO);
    }

    public void transactStock(TransactionDTO transactionDTO) {
        if(stockService.transactStock(transactionDTO)){
            stockPrint.printSuccessMessage("transactStock");
        }else{
            stockPrint.printSuccessMessage("transactStock");
        }
    }
}
