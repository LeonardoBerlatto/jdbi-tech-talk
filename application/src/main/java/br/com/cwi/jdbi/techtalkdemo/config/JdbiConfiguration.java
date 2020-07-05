package br.com.cwi.jdbi.techtalkdemo.config;

import br.com.cwi.jdbi.techtalkdemo.repository.PartyRepository;
import br.com.cwi.jdbi.techtalkdemo.repository.UserRepository;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;


/**
 * Configuração para usar o JDBI
 **/
@Configuration
public class JdbiConfiguration {

    @Bean
    public Jdbi jdbi(DataSource ds, List<JdbiPlugin> jdbiPlugins, List<RowMapper<?>> rowMappers) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(ds);

        Jdbi jdbi = Jdbi.create(proxy);

        jdbiPlugins.forEach(jdbi::installPlugin);
        rowMappers.forEach(jdbi::registerRowMapper);

        return jdbi;
    }

    /**
     * Plugin para usar arquivos .sql
     */
    @Bean
    public JdbiPlugin sqlObjectPlugin(DataSource dataSource) {
        return new SqlObjectPlugin();
    }

    /**
     * Para cada repository deve ser fornecido um bean
     */
    @Bean
    public UserRepository userRepository(Jdbi jdbi) {
        return jdbi.onDemand(UserRepository.class);
    }

    @Bean
    public PartyRepository partyRepository(Jdbi jdbi) {
        return jdbi.onDemand(PartyRepository.class);
    }

}