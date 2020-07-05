package br.com.cwi.jdbi.techtalkdemo.repository;

import br.com.cwi.jdbi.techtalkdemo.dto.PartyDTO;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@UseClasspathSqlLocator // usa arquivos .sql da pasta resources
public interface PartyRepository { // cada arquivo deve seguir nomeDoMetodoDoRepository.sql

    @SqlQuery // consulta
    @UseRowMapper(PartyDTOMapper.class) // row mapper customizado
    Optional<PartyDTO> findById(Long id);
}
