package tn.esprit.devops_project.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import tn.esprit.devops_project.entities.Stock;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@ActiveProfiles("test")
class StockServiceImplTest {
    @Autowired
    private StockServiceImpl stockService;

    @DatabaseSetup("/data-set/stock-data.xml")
    @Test
    void addStock() {
        Stock stock = new Stock();
        stock.setTitle("bon");
        stockService.addStock(stock);
        List <Stock> allStocks = stockService.retrieveAllStock();
        assertEquals(allStocks.size(),2);

    }

    @DatabaseSetup("/data-set/stock-data.xml")
    @Test
    void retrieveStock() {
        final Stock stock = this.stockService.retrieveStock(1L);
        assertEquals("stock:1", stock.getTitle());
    }

    @DatabaseSetup("/data-set/stock-data.xml")
    @Test
    void retrieveAllStock() {
        final List <Stock> allStocks = this.stockService.retrieveAllStock();
        assertEquals(allStocks.size(), 1);
    }
}