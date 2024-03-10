package stock.model.dao;

import stock.model.dto.MemDTO;
import stock.model.dto.StockDTO;
import stock.model.dto.TransactionDTO;

import java.util.ArrayList;
import java.util.List;

public interface StockDAO {
    int insertMember(MemDTO memDTO);

    int truncateMember();

    int truncateTransaction();

    List<StockDTO> viewallStock();

    List<MemDTO> showAccount();

    List<TransactionDTO> myTransaction(TransactionDTO transactionDTO);

    int addMoney(MemDTO memDTO);

    List<StockDTO> searchStock(StockDTO stockDTO);

    List<TransactionDTO> showTransaction();

    int deleteStock(StockDTO stockDTO);

    MemDTO findMemebr(MemDTO memDTO);

    StockDTO findPrice(StockDTO stockDTO);

    int transactStock(TransactionDTO transactionDTO);
}
