package com.uit.cinemaportalapi.service.impl;

import com.uit.cinemaportalapi.entity.Cinema;
import com.uit.cinemaportalapi.entity.Movie;
import com.uit.cinemaportalapi.entity.ShowTime;
import com.uit.cinemaportalapi.entity.Ticket;
import com.uit.cinemaportalapi.exception.BadRequestException;
import com.uit.cinemaportalapi.payload.dto.PaymentHistoryDTO;
import com.uit.cinemaportalapi.payload.dto.TicketInfoDTO;
import com.uit.cinemaportalapi.repository.SeatRepository;
import com.uit.cinemaportalapi.repository.ShowTimeRepository;
import com.uit.cinemaportalapi.repository.TicketRepository;
import com.uit.cinemaportalapi.service.TicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowTimeRepository showTimeRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Transactional
    @Override
    public TicketInfoDTO getTicketInfo(Long ticketId) {

        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);

        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            ShowTime showTime = ticket.getSeats().get(0).getShowtime();
            Movie movie = showTime.getMovie();
            Cinema cinema = showTime.getCinema();
            TicketInfoDTO ticketInfoDTO = new TicketInfoDTO();
            ticketInfoDTO.setQrCode(ticket.getQrCode());
            ticketInfoDTO.setMovieTitle(movie.getTitle());
            ticketInfoDTO.setShowDate(showTime.getStartTime());
            ticketInfoDTO.setShowTime(showTime.getStartTime());
            ticketInfoDTO.setCinemaName(cinema.getName());
            ticketInfoDTO.setBookingNumber(ticket.getBookingNumber());
            ticketInfoDTO.setPosterURL(movie.getPosterURL());

            ticketInfoDTO.setScreenName(showTime.getCinema().getName());

            ticketInfoDTO.setSubtotal(ticket.getSubtotal());
            ticketInfoDTO.setRating(movie.getRating());

            return ticketInfoDTO;
        }
       return  null;
    }

    @Transactional
    @Override
    public List<PaymentHistoryDTO> getTicketsByUserId(Long userId) {
        List<Ticket> tickets = ticketRepository.findByUserId(userId);

        return tickets.stream()
                .map(this::mapToTicketInfoDTO)
                .collect(Collectors.toList());
    }
    private PaymentHistoryDTO mapToTicketInfoDTO(Ticket ticket) {
        ShowTime showTime = ticket.getSeats().get(0).getShowtime();
        Movie movie = showTime.getMovie();
        Cinema cinema = showTime.getCinema();
        PaymentHistoryDTO paymentHistoryDTO = new PaymentHistoryDTO();
        paymentHistoryDTO.setTicketID(ticket.getId());
        paymentHistoryDTO.setMovieTitle(movie.getTitle());
        paymentHistoryDTO.setCinemaName(cinema.getName());
        paymentHistoryDTO.setShowDate(showTime.getStartTime());
        paymentHistoryDTO.setShowTime(showTime.getStartTime());
        paymentHistoryDTO.setEndTime(showTime.getEndTime());
        return paymentHistoryDTO;
    }
}
