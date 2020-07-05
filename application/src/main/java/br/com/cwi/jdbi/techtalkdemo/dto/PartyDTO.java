package br.com.cwi.jdbi.techtalkdemo.dto;

import br.com.cwi.jdbi.techtalkdemo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartyDTO {

    private Long partyId;
    private String partyName;
    private User user;
}
