package com.uit.cinemaportalapi.service;

import com.uit.cinemaportalapi.payload.dto.PaymentHistoryDTO;
import com.uit.cinemaportalapi.payload.dto.TicketInfoDTO;

import java.util.List;

public interface TicketService {

    TicketInfoDTO getTicketInfo(Long ticketId);

    List<PaymentHistoryDTO> getTicketsByUserId(Long userID);
}
