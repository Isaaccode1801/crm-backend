package com.facilitoCRM.demo.service;

import com.facilitoCRM.demo.dto.LeadDTO;
import com.facilitoCRM.demo.dto.NotaFiscalDTO;
import com.facilitoCRM.demo.dto.LeadHistoryEntryDTO;
import com.facilitoCRM.demo.entity.Lead;
import com.facilitoCRM.demo.entity.NotaFiscal;
import com.facilitoCRM.demo.entity.LeadHistoryEntry;
import com.facilitoCRM.demo.repository.LeadRepository;
import com.facilitoCRM.demo.repository.LeadHistoryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LeadService {
    
    @Autowired
    private LeadRepository leadRepository;

    public Page<LeadDTO> findAllPaged(String search, String stage, Pageable pageable) {
        return leadRepository.findBySearch(search, stage, pageable)
                .map(this::toDTO);
    }

    @Autowired
    private LeadHistoryEntryRepository historyRepository;

    public List<LeadDTO> findAll() {
        return leadRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public LeadDTO findById(UUID id) {
        return leadRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Transactional
    public LeadDTO create(LeadDTO dto) {
        Lead lead = toEntity(dto);
        lead = leadRepository.save(lead);

        // Add initial history entry
        LeadHistoryEntry history = new LeadHistoryEntry();
        history.setLeadId(lead.getId());
        history.setType("CREATION");
        history.setNewStatus(lead.getStatusFunil());
        history.setUserEmail("system"); // Default for now
        historyRepository.save(history);

        return toDTO(lead);
    }

    @Transactional
    public LeadDTO update(UUID id, LeadDTO dto) {
        return leadRepository.findById(id).map(existingLead -> {
            // Update basic fields
            updateLeadFromDTO(existingLead, dto);
            
            // Note: We don't necessarily want to overwrite notasFiscais or historico 
            // from a basic update unless they are explicitly provided in the DTO.
            // If the DTO doesn't have them, we keep the existing ones.
            
            if (dto.getNotasFiscais() != null) {
                // If the frontend sent a new list, we update it. 
                // Careful with orphanRemoval=true, this will delete existing ones not in the new list.
                existingLead.getNotasFiscais().clear();
                existingLead.getNotasFiscais().addAll(dto.getNotasFiscais().stream()
                        .map(this::toNotaFiscalEntity)
                        .collect(Collectors.toList()));
            }

            Lead saved = leadRepository.save(existingLead);
            return toDTO(saved);
        }).orElse(null);
    }

    private void updateLeadFromDTO(Lead lead, LeadDTO dto) {
        lead.setNome(dto.getNome());
        lead.setEmail(dto.getEmail());
        lead.setTelefone(dto.getTelefone());
        lead.setCpf(dto.getCpf());
        lead.setInteresse(dto.getInteresse());
        lead.setPrecoInteresse(dto.getPrecoInteresse());
        lead.setInteresseNaoListado(dto.getInteresseNaoListado());
        lead.setTipoImovel(dto.getTipoImovel());
        lead.setRelacaoImovel(dto.getRelacaoImovel());
        lead.setEnderecoCep(dto.getEnderecoCep());
        lead.setEnderecoRua(dto.getEnderecoRua());
        lead.setEnderecoNumero(dto.getEnderecoNumero());
        lead.setEnderecoComplemento(dto.getEnderecoComplemento());
        lead.setEnderecoBairro(dto.getEnderecoBairro());
        lead.setEnderecoCidade(dto.getEnderecoCidade());
        lead.setEnderecoUf(dto.getEnderecoUf());
        lead.setServicoId(dto.getServicoId());
        lead.setPrestadorId(dto.getPrestadorId());
        lead.setExternalSolicitacaoId(dto.getExternalSolicitacaoId());
        if (dto.getStatusFunil() != null) {
            lead.setStatusFunil(dto.getStatusFunil());
        }
        lead.setOrigem(dto.getOrigem());
        lead.setPrioridade(dto.getPrioridade());
        lead.setValorEstimado(dto.getValorEstimado());
        lead.setValorNegociado(dto.getValorNegociado());
        lead.setValorFechado(dto.getValorFechado());
        lead.setComissaoPercentual(dto.getComissaoPercentual());
        lead.setComissao(dto.getComissao());
        lead.setFollowUpDate(dto.getFollowUpDate());
        lead.setConversionStageDate(dto.getConversionStageDate());
        lead.setCreatedAt(dto.getCreatedAt());
        lead.setObservacoes(dto.getObservacoes());
        lead.setExternalSource(dto.getExternalSource());
        lead.setExternalId(dto.getExternalId());
    }

    public void delete(UUID id) {
        leadRepository.deleteById(id);
    }

    private LeadDTO toDTO(Lead lead) {
        LeadDTO dto = new LeadDTO();
        dto.setId(lead.getId());
        dto.setNome(lead.getNome());
        dto.setEmail(lead.getEmail());
        dto.setTelefone(lead.getTelefone());
        dto.setCpf(lead.getCpf());
        dto.setInteresse(lead.getInteresse());
        dto.setPrecoInteresse(lead.getPrecoInteresse());
        dto.setInteresseNaoListado(lead.getInteresseNaoListado());
        dto.setTipoImovel(lead.getTipoImovel());
        dto.setRelacaoImovel(lead.getRelacaoImovel());
        dto.setEnderecoCep(lead.getEnderecoCep());
        dto.setEnderecoRua(lead.getEnderecoRua());
        dto.setEnderecoNumero(lead.getEnderecoNumero());
        dto.setEnderecoComplemento(lead.getEnderecoComplemento());
        dto.setEnderecoBairro(lead.getEnderecoBairro());
        dto.setEnderecoCidade(lead.getEnderecoCidade());
        dto.setEnderecoUf(lead.getEnderecoUf());
        dto.setServicoId(lead.getServicoId());
        dto.setPrestadorId(lead.getPrestadorId());
        dto.setExternalSolicitacaoId(lead.getExternalSolicitacaoId());
        dto.setStatusFunil(lead.getStatusFunil());
        dto.setOrigem(lead.getOrigem());
        dto.setPrioridade(lead.getPrioridade());
        dto.setValorEstimado(lead.getValorEstimado());
        dto.setValorNegociado(lead.getValorNegociado());
        dto.setValorFechado(lead.getValorFechado());
        dto.setComissaoPercentual(lead.getComissaoPercentual());
        dto.setComissao(lead.getComissao());
        dto.setFollowUpDate(lead.getFollowUpDate());
        dto.setConversionStageDate(lead.getConversionStageDate());
        dto.setCreatedAt(lead.getCreatedAt());
        dto.setObservacoes(lead.getObservacoes());
        dto.setExternalSource(lead.getExternalSource());
        dto.setExternalId(lead.getExternalId());
        
        if (lead.getNotasFiscais() != null) {
            dto.setNotasFiscais(lead.getNotasFiscais().stream()
                    .map(this::toNotaFiscalDTO)
                    .collect(Collectors.toList()));
        }

        if (lead.getHistorico() != null) {
            dto.setHistorico(lead.getHistorico().stream()
                    .map(this::toLeadHistoryEntryDTO)
                    .collect(Collectors.toList()));
        }
        
        return dto;
    }

    private NotaFiscalDTO toNotaFiscalDTO(NotaFiscal nf) {
        NotaFiscalDTO dto = new NotaFiscalDTO();
        dto.setId(nf.getId());
        dto.setNomeArquivo(nf.getNomeArquivo());
        dto.setTipo(nf.getTipo());
        dto.setTamanho(nf.getTamanho());
        dto.setNumeroNf(nf.getNumeroNf());
        dto.setDataEmissao(nf.getDataEmissao());
        dto.setDataBase64(nf.getDataBase64());
        dto.setLeadId(nf.getLeadId());
        dto.setAppointmentId(nf.getAppointmentId());
        dto.setTransactionId(nf.getTransactionId());
        return dto;
    }

    private LeadHistoryEntryDTO toLeadHistoryEntryDTO(LeadHistoryEntry history) {
        LeadHistoryEntryDTO dto = new LeadHistoryEntryDTO();
        dto.setId(history.getId());
        dto.setDate(history.getDate());
        dto.setOldStatus(history.getOldStatus());
        dto.setNewStatus(history.getNewStatus());
        dto.setUserEmail(history.getUserEmail());
        dto.setType(history.getType());
        dto.setLeadId(history.getLeadId());
        return dto;
    }

    private Lead toEntity(LeadDTO dto) {
        Lead lead = new Lead();
        if (dto.getId() != null) {
            lead.setId(dto.getId());
        }
        updateLeadFromDTO(lead, dto);
        
        if (dto.getNotasFiscais() != null) {
            lead.setNotasFiscais(dto.getNotasFiscais().stream()
                    .map(this::toNotaFiscalEntity)
                    .collect(Collectors.toList()));
        }
        return lead;
    }

    private NotaFiscal toNotaFiscalEntity(NotaFiscalDTO dto) {
        NotaFiscal nf = new NotaFiscal();
        if (dto.getId() != null) {
            nf.setId(dto.getId());
        }
        nf.setNomeArquivo(dto.getNomeArquivo());
        nf.setTipo(dto.getTipo());
        nf.setTamanho(dto.getTamanho());
        nf.setNumeroNf(dto.getNumeroNf());
        nf.setDataEmissao(dto.getDataEmissao());
        nf.setDataBase64(dto.getDataBase64());
        nf.setLeadId(dto.getLeadId());
        nf.setAppointmentId(dto.getAppointmentId());
        nf.setTransactionId(dto.getTransactionId());
        return nf;
    }
}
