package app.DAO;


import app.config.AppProperties;
import app.domain.Product;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@PropertySource(value = "classpath:config.properties")
public class ImplProductDAO implements ProductDAO {
    //Field


    //Constructor

    //Function
 
    @Override
    public void addProduct(Product product) {
        jdbcTemplate().update("insert into product (name, description, create_date, place_storage, reserved) values (?, ?, ?, ?, ?)",
                product.getName(), product.getDescription(), product.getCreateDate(), product.getPlace_storage(), product.isReserved());
    }

    @Override
    public void removeProduct(Product product) {
        jdbcTemplate().update("delete from product where id=?", product.getId());
    }

    @Override
    public void updateProduct(Product product) {
        jdbcTemplate().update("update product set name=?, description=?, create_date=?, place_storage=?, reserved=? where id=?",
                product.getName(), product.getDescription(), product.getCreateDate(), product.getPlace_storage(), product.isReserved(), product.getId());
    }

    @Override
    public Product getProduct(int id) {
        Product product = jdbcTemplate().queryForObject("select * from product where id=?", new Object[]{id}, new ProductRowMapper());
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        List <Product> result = jdbcTemplate().query("select * from product", new ProductRowMapper());
        return result;
    }

    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @PostConstruct
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/trainingDB");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123");
        return dataSource;
    }
//    public DataSource dataSource(){
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(AppProperties.getProperties().getProperty("driverClassName"));
//        dataSource.setUrl(AppProperties.getProperties().getProperty("url"));
//        dataSource.setUsername(AppProperties.getProperties().getProperty("login"));
//        dataSource.setPassword(AppProperties.getProperties().getProperty("password"));
//        return dataSource;
//    }

}

class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        return new Product(rs.getInt("id"), rs.getString("name"),
                rs.getString("description"), rs.getDate("create_date").toLocalDate(),
                rs.getInt("place_storage"), rs.getBoolean("reserved"));
    }
}
