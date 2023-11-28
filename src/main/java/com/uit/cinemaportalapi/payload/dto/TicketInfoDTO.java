package com.uit.cinemaportalapi.payload.dto;


import com.uit.cinemaportalapi.entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketInfoDTO {
    private String qrCode;
    private String movieTitle;
    private Date showDate;
    private Date showTime;
    private String cinemaName;
    private String bookingNumber;
    private String posterURL;
    private String seatNumbers;
    private String screenName;
    private BigDecimal subtotal;
    private String rating;
}
