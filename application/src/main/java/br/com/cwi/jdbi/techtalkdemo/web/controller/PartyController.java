package br.com.cwi.jdbi.techtalkdemo.web.controller;

import br.com.cwi.jdbi.techtalkdemo.dto.PartyDTO;
import br.com.cwi.jdbi.techtalkdemo.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parties")
@RequiredArgsConstructor
public class PartyController {

    private final PartyService partyService;

    @GetMapping("/{id}")
    public PartyDTO findPartyById(@PathVariable("id") Long id) {
        return partyService.findPartyById(id);
    }
}
