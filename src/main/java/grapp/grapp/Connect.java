package grapp.grapp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;
/*import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;*/
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;

public class Connect {

    
    @Value("${spring.datasource.url}")
    private String dbUrl;

    private DataSource dataSource;

    public DataSource getDataSource()throws SQLException{
      if(dataSource == null) dataSource = dataSource();
      return dataSource;
    }


    public DataSource dataSource() throws SQLException {
      if (dbUrl == null || dbUrl.isEmpty()) {
        return new HikariDataSource();
      } else {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
      }
    }
}
