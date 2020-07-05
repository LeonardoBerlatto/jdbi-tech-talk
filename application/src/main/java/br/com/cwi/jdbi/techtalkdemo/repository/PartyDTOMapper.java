package br.com.cwi.jdbi.techtalkdemo.repository;

import br.com.cwi.jdbi.techtalkdemo.domain.User;
import br.com.cwi.jdbi.techtalkdemo.dto.PartyDTO;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartyDTOMapper implements RowMapper<PartyDTO> {

    @Override
    public PartyDTO map(ResultSet rs, StatementContext ctx) throws SQLException {
        return PartyDTO.builder()
                .partyId(rs.getLong("partyId"))
                .partyName(rs.getString("partyName"))
                .user(User.builder()
                        .id(rs.getLong("userId"))
                        .name(rs.getString("userName"))
                        .build())
                .build();
    }
}
