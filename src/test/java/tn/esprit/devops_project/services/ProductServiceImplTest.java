package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@ActiveProfiles("test")
class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @DatabaseSetup("/data-set/product-data.xml")
    @Test
    void addProduct() {
        Stock stock = new Stock();
        stock.setTitle("Stock for testing");

        Product product = new Product();
        product.setTitle("Product for testing");
        product.setPrice(10.0f);
        product.setQuantity(20);
        product.setCategory(ProductCategory.CLOTHING);
        product.setStock(stock);

        productService.addProduct(product, stock.getIdStock());

        List<Product> allProducts = productService.retreiveAllProduct();
        assertEquals(2, allProducts.size());
    }

    @DatabaseSetup("/data-set/product-data.xml")
    @Test
    void retrieveProduct() {
        final Product product = productService.retrieveProduct(1L);
        assertEquals("Product 1", product.getTitle());
    }

    @DatabaseSetup("/data-set/product-data.xml")
    @Test
    void retrieveAllProduct() {
        final List<Product> allProducts = productService.retreiveAllProduct();
        assertEquals(1, allProducts.size());
    }
}
