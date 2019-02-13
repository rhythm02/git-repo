package com.assignment.examples.hotel_problem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelBookingTest {

    String[] dates;
    Request request;
    @Before
    public  void init(){
        dates = {};
        request = new Request(Customer.REGULAR,dates);
    }

}