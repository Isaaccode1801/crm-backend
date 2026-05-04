package com.facilitoCRM.demo.service;

import com.facilitoCRM.demo.dto.NotaFiscalDTO;
import com.facilitoCRM.demo.entity.NotaFiscal;
import com.facilitoCRM.demo.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository repository;

    public List<NotaFiscalDTO> findAllByLeadId(UUID leadId) {
        return repository.findByLeadId(leadId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public NotaFiscalDTO save(NotaFiscalDTO dto) {
        NotaFiscal nf = toEntity(dto);
        return toDTO(repository.save(nf));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public NotaFiscalDTO update(UUID id, NotaFiscalDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setNumeroNf(dto.getNumeroNf());
            existing.setDataEmissao(dto.getDataEmissao());
            existing.setNomeArquivo(dto.getNomeArquivo());
            existing.setTipo(dto.getTipo());
            existing.setTamanho(dto.getTamanho());
            existing.setDataBase64(dto.getDataBase64());
            return toDTO(repository.save(existing));
        }).orElse(null);
    }

    private NotaFiscalDTO toDTO(NotaFiscal nf) {
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

    private NotaFiscal toEntity(NotaFiscalDTO dto) {
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
