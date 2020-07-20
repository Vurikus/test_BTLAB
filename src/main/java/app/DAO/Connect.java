package app.DAO;


import app.config.AppProperties;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = "app")
@PropertySource(value = "classpath:config.properties")
public class Connect {
    //Field

    //Constructor

    //Function
    public JdbcTemplate jdbcTemplate() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(AppProperties.getProperties().getProperty("driverClassName"));
        dataSource.setUrl(AppProperties.getProperties().getProperty("url"));
        dataSource.setUsername(AppProperties.getProperties().getProperty("login"));
        dataSource.setPassword(AppProperties.getProperties().getProperty("password"));

        return new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        Connect connect = new Connect();
        connect.jdbcTemplate().update("insert into test (name) values ('sd9000')");
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
//        List<Customer> results = jdbcTemplate.query(
//                "select * from customers where first_name = ?", new Object[]{"Josh"},
//                new RowMapper<Customer>() {
//                    @Override
//                    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        return new Customer(rs.getLong("id"), rs.getString("first_name"),
//                                rs.getString("last_name"));
//                    }
//                });
//
//        for (Customer customer : results) {
//            System.out.println(customer);
//        }
}
