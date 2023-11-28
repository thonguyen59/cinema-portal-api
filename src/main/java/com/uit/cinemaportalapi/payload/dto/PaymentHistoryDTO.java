package com.uit.cinemaportalapi.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHistoryDTO {

    private Long ticketID;
    private String movieTitle;
    private String cinemaName;
    private Date showDate;
    private Date showTime;
    private Date endTime;




}
