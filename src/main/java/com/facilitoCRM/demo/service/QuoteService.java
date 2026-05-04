package com.facilitoCRM.demo.service;

import com.facilitoCRM.demo.dto.QuoteDTO;
import com.facilitoCRM.demo.entity.Quote;
import com.facilitoCRM.demo.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository repository;

    public List<QuoteDTO> findAllByLeadId(UUID leadId) {
        return repository.findByLeadId(leadId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public QuoteDTO create(QuoteDTO dto) {
        Quote quote = toEntity(dto);
        if (quote.getStatus() == null) {
            quote.setStatus("PENDENTE");
        }
        quote = repository.save(quote);
        return toDTO(quote);
    }

    public QuoteDTO update(UUID id, QuoteDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setServicoId(dto.getServicoId());
            existing.setPrestadorId(dto.getPrestadorId());
            existing.setValorEstimado(dto.getValorEstimado());
            existing.setValorNegociado(dto.getValorNegociado());
            existing.setComissaoPercentual(dto.getComissaoPercentual());
            existing.setStatus(dto.getStatus());
            existing.setObservacoes(dto.getObservacoes());
            return toDTO(repository.save(existing));
        }).orElse(null);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private QuoteDTO toDTO(Quote quote) {
        QuoteDTO dto = new QuoteDTO();
        dto.setId(quote.getId());
        dto.setLeadId(quote.getLeadId());
        dto.setServicoId(quote.getServicoId());
        dto.setPrestadorId(quote.getPrestadorId());
        dto.setValorEstimado(quote.getValorEstimado());
        dto.setValorNegociado(quote.getValorNegociado());
        dto.setComissaoPercentual(quote.getComissaoPercentual());
        dto.setStatus(quote.getStatus());
        dto.setObservacoes(quote.getObservacoes());
        dto.setCreatedAt(quote.getCreatedAt());
        dto.setUpdatedAt(quote.getUpdatedAt());
        dto.setApprovedAt(quote.getApprovedAt());
        return dto;
    }

    private Quote toEntity(QuoteDTO dto) {
        Quote quote = new Quote();
        if (dto.getId() != null) {
            quote.setId(dto.getId());
        }
        quote.setLeadId(dto.getLeadId());
        quote.setServicoId(dto.getServicoId());
        quote.setPrestadorId(dto.getPrestadorId());
        quote.setValorEstimado(dto.getValorEstimado());
        quote.setValorNegociado(dto.getValorNegociado());
        quote.setComissaoPercentual(dto.getComissaoPercentual());
        quote.setStatus(dto.getStatus());
        quote.setObservacoes(dto.getObservacoes());
        return quote;
    }
}
