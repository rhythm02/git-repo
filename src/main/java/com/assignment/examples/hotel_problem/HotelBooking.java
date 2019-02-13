package com.assignment.examples.hotel_problem;

import java.util.*;

public class HotelBooking implements HotelService {


    private Hotel lakewood;
    private Hotel bridgewood;
    private Hotel ridgewood;
    List<Hotel> hotelList;

    HotelBooking() {
        Map<Category, Integer> mapLakewood = new HashMap<Category, Integer>();
        mapLakewood.put(new Category(Customer.REGULAR, Days.WEEKDAY), 110);
        mapLakewood.put(new Category(Customer.REGULAR, Days.WEEKEND), 90);
        mapLakewood.put(new Category(Customer.REWARD, Days.WEEKDAY), 80);
        mapLakewood.put(new Category(Customer.REWARD, Days.WEEKEND), 80);

        Map<Category, Integer> mapBridgewood = new HashMap<Category, Integer>();
        mapBridgewood.put(new Category(Customer.REGULAR, Days.WEEKDAY), 160);
        mapBridgewood.put(new Category(Customer.REGULAR, Days.WEEKEND), 60);
        mapBridgewood.put(new Category(Customer.REWARD, Days.WEEKDAY), 110);
        mapBridgewood.put(new Category(Customer.REWARD, Days.WEEKEND), 50);


        Map<Category, Integer> mapRidgewood = new HashMap<Category, Integer>();
        mapRidgewood.put(new Category(Customer.REGULAR, Days.WEEKDAY), 220);
        mapRidgewood.put(new Category(Customer.REGULAR, Days.WEEKEND), 150);
        mapRidgewood.put(new Category(Customer.REWARD, Days.WEEKDAY), 100);
        mapRidgewood.put(new Category(Customer.REWARD, Days.WEEKEND), 40);

        lakewood = new Hotel("Lakewood", 3, mapLakewood);
        bridgewood = new Hotel("Bridgewood", 4, mapBridgewood);
        ridgewood = new Hotel("Ridgewood", 4, mapBridgewood);

        hotelList = new ArrayList<Hotel>();
        hotelList.add(lakewood);
        hotelList.add(bridgewood);
        hotelList.add(ridgewood);

    }

    public Hotel findCheapestHotel(Request request) {


        ArrayList<Integer> al = new ArrayList<Integer>();

        for (int i = 0; i < hotelList.size(); i++) {
            int cost=0;
            int totalCost=0;
            Map<Category,Integer> map = hotelList.get(i).getMap();

            for (int j = 0; j < request.listDates.size(); j++) {

                int day = getDay(request.listDates.get(i));

                if(day >= Calendar.MONDAY && day <= Calendar.SUNDAY){
                    if(request.customerType.equals(Customer.REGULAR))
                        cost = map.get(new Category(Customer.REGULAR,Days.WEEKDAY));
                    else
                        cost = map.get(new Category(Customer.REWARD,Days.WEEKDAY));
                }
                else{
                    if(request.customerType.equals(Customer.REGULAR))
                        cost = map.get(new Category(Customer.REGULAR,Days.WEEKEND));
                    else
                        cost = map.get(new Category(Customer.REWARD,Days.WEEKEND));

                }
                totalCost = totalCost+cost;
                al.add(totalCost);
            }
        }
        return minCost(al);

    }

    public int getDay(String date){
        Calendar c = Calendar.getInstance();
        Date d = null;
        try {
            d = new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        c.setTime(d);

        return c.get(Calendar.DAY_OF_WEEK);
    }

    public Hotel minCost(ArrayList<Integer> al){
        int min = al.get(0);
        int index = 0;
        for(int i=0; i<al.size(); i++){
            if(min > al.get(i)){
                min = al.get(i);
                index = i;
            }

            if(min == al.get(i)){
                if(hotelList.get(index).getRating() > hotelList.get(i).getRating()) {
                    min = al.get(i);
                    index = i;
                }
                else
                    min = al.get(index);
            }

        }
        return hotelList.get(index);
    }

}


