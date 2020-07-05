package br.com.cwi.jdbi.techtalkdemo.repository;

import br.com.cwi.jdbi.techtalkdemo.domain.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@UseClasspathSqlLocator
public interface UserRepository {

    @SqlUpdate // insert, update ou delete
    @GetGeneratedKeys // retorna a chave primária gerada por padrão
    Long createUser(@BindBean User user); // permite usar cada campo do objeto na query

    @SqlQuery
    @RegisterBeanMapper(User.class) // mapeia automaticamente o retorno da query para os campos da classe
    Optional<User> findById(Long id);

    @SqlQuery
    boolean existsByName(String name);

}
