package com.example.shop.entities.historyofchange.controller;

import com.example.shop.dto.HistoryOfChangeDTO;
import com.example.shop.entities.historyofchange.service.HistoryOfChangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/historyOfChange")
class HistoryOfChangeController {

    private final HistoryOfChangeService historyOfChangeService;

    @GetMapping
    public List<HistoryOfChangeDTO> getHistoryOfChange() {
        return historyOfChangeService.getHistoryOfChange();
    }

    @PostMapping
    public void addHistoryOfChange(@RequestBody HistoryOfChangeDTO historyOfChangeDTO) {
        historyOfChangeService.addHistoryOfChange(historyOfChangeDTO);
    }

    @DeleteMapping(path = "{id_history_of_change}")
    public void deleteHistoryOfChange(@PathVariable("id_history_of_change") Long idHistoryOfChange) {
        historyOfChangeService.deleteHistoryOfChange(idHistoryOfChange);
    }

    @PutMapping("/update/{idHistoryOdChange}")
    public void updateHistoryOfChange(@PathVariable long idHistoryOdChange, @RequestBody HistoryOfChangeDTO historyOfChangeDTO) {
        historyOfChangeService.updateHistoryOfChange(
                idHistoryOdChange, historyOfChangeDTO.getProduct(), historyOfChangeDTO.getEmployee(), historyOfChangeDTO.getOldPrice(), historyOfChangeDTO.getNewPrice(), historyOfChangeDTO.getDateOfChange());
    }

    @GetMapping("/audited/{idHistoryOdChange}")
    List<HistoryOfChangeDTO> getAuditHistoryOfChange(@PathVariable long idHistoryOdChange) {
        return historyOfChangeService.getAuditHistoryOfChange(idHistoryOdChange);
    }
}