package stock.model.service;

import org.apache.ibatis.session.SqlSession;
import stock.model.dao.StockDAO;
import stock.model.dto.MemDTO;
import stock.model.dto.StockDTO;
import stock.model.dto.TransactionDTO;

import java.util.List;

import static stock.common.Template.getSqlSession;

public class StockService {
    private StockDAO stockDAO;
    public boolean registerMember(MemDTO memDTO) {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        int result = stockDAO.insertMember(memDTO);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public void truncateData() {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        int result1 = stockDAO.truncateMember();
        int result2 = stockDAO.truncateTransaction();

        if(result1 > 0 && result2 > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    public List<StockDTO> viewallStock() {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        List<StockDTO> stockList = stockDAO.viewallStock();

        sqlSession.close();

        return stockList;
    }

    public List<MemDTO> showAccount() {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        List<MemDTO> memList = stockDAO.showAccount();

        sqlSession.close();

        return memList;
    }

    public boolean addMoney(MemDTO memDTO) {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        int result = stockDAO.addMoney(memDTO);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public List<StockDTO> searchStock(StockDTO stockDTO) {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        List<StockDTO> searchStockList = stockDAO.searchStock(stockDTO);

        sqlSession.close();

        return searchStockList;
    }

    public List<TransactionDTO> showTransaction() {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        List<TransactionDTO> transactionList = stockDAO.showTransaction();

        sqlSession.close();

        return transactionList;
    }

    public boolean deleteStock(StockDTO stockDTO) {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        int result = stockDAO.deleteStock(stockDTO);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public MemDTO findMemebr(MemDTO memDTO) {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        MemDTO name = stockDAO.findMemebr(memDTO);

        sqlSession.close();

        return name;
    }

    public StockDTO findPrice(StockDTO stockDTO) {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        StockDTO price = stockDAO.findPrice(stockDTO);

        sqlSession.close();

        return price;
    }

    public boolean transactStock(TransactionDTO transactionDTO) {
        SqlSession sqlSession = getSqlSession();
        stockDAO = sqlSession.getMapper(StockDAO.class);
        int result = stockDAO.transactStock(transactionDTO);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
