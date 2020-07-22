package app.DAO;


import app.config.AppProperties;
import app.domain.Product;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@PropertySource(value = "classpath:config.properties")
public class ImplProductDAO implements ProductDAO {
    //Field

    //Constructor

    //Function

    private JdbcTemplate jdbcTemplate() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(AppProperties.getProperties().getProperty("driverClassName"));
        dataSource.setUrl(AppProperties.getProperties().getProperty("url"));
        dataSource.setUsername(AppProperties.getProperties().getProperty("login"));
        dataSource.setPassword(AppProperties.getProperties().getProperty("password"));

        return new JdbcTemplate(dataSource);
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void removeProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

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

    public static void main(String[] args) {
        ImplProductDAO implProductDAO = new ImplProductDAO();
        List <Product> list = implProductDAO.getAllProduct();
        for (Product p:list) {
            System.out.println(p.toString());
        }
        System.out.println("");
        Product product = implProductDAO.getProduct(1);
        System.out.println(product.toString());
    }

    //        System.out.println("Creating tables");
//        jdbcTemplate.execute("drop table customers if exists");
//        jdbcTemplate.execute("create table customers(" +
//                "id serial, first_name varchar(255), last_name varchar(255))");
//
//        String[] names = "John Woo;Jeff Dean;Josh Bloch;Josh Long".split(";");
//        for (String fullname : names) {
//            String[] name = fullname.split(" ");
//            System.out.printf("Inserting customer record for %s %s\n", name[0], name[1]);
//            jdbcTemplate.update(
//                    "INSERT INTO customers(first_name,last_name) values(?,?)",
//                    name[0], name[1]);
//        }
//
//        System.out.println("Querying for customer records where first_name = 'Josh':");
//
}

class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        return new Product(rs.getInt("id"), rs.getString("name"),
                rs.getString("description"), rs.getDate("create_date").toLocalDate(),
                rs.getInt("place_storage"), rs.getBoolean("reserved"));
    }
}
