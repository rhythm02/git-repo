package com.assignment.examples.hotel_problem;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Request {
    Customer customerType;
    List<String> listDates = new ArrayList<String>();

    Request(Customer customerType, String[] dates){
        this.customerType = customerType;
        this.listDates = Arrays.asList(dates);
    }



}
