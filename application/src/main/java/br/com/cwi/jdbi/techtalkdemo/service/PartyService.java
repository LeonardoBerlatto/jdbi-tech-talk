package br.com.cwi.jdbi.techtalkdemo.service;

import br.com.cwi.jdbi.techtalkdemo.dto.PartyDTO;
import br.com.cwi.jdbi.techtalkdemo.exception.PartyNotFoundException;
import br.com.cwi.jdbi.techtalkdemo.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartyService {

    private final PartyRepository repository;

    public PartyDTO findPartyById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(PartyNotFoundException::new);
    }
}
