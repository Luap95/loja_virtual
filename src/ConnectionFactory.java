import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public DataSource dataSource;

    public ConnectionFactory(){
        //Criando um pool de conexões
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("bd@Lucas95");

        comboPooledDataSource.setMaxPoolSize(10);

        //atribuindo o pool de conexões para a datasource
        this.dataSource = comboPooledDataSource;
    }
    public Connection RecuperaConexao() throws SQLException {
        //recuperando a conexão já aberta pelo pool
        return this.dataSource.getConnection();
    }
}
