package com.ittallaght.donjakevalino.m50tollprices;


import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jake Valino on 05/04/2017.
 */

enum VehicleType { Cars, Busses, HGV, Service}

public class M50Toll {

    // Variables
    private VehicleType vehicle;
    private Date date;
    private double cost;

    // Standard Cost - Weekdays
    private static double CAR_TOLL_COST = 3.50;
    private static double BUSSES_TOLL_COST = 4.50;
    private static double HGV_TOLL_COST = 5.50;
    private static double SERVICE_TOLL_COST = 1.50;

    // Constructors
    public M50Toll(VehicleType vehicleIn, Date dateIn)
    {
        vehicle = vehicleIn;
        date = dateIn;
    }

    // Getters
    public VehicleType getVehicle()
    {
        return vehicle;
    }

    public Date getDate()
    {
        return date;
    }

    public double getCost()
    {
        return cost;
    }

    // Setters
    public void setVehicle(VehicleType vehicleIn)
    {
        vehicle = vehicleIn;
    }

    public void setDate(Date dateIn)
    {
        date = dateIn;
    }

    public void setCost(double costIn)
    {
        cost = costIn;
    }

    public void calculate()
    {
        Calendar myDate = Calendar.getInstance();
        int dow = myDate.get (Calendar.DAY_OF_WEEK);
        boolean isWeekday = ((dow >= Calendar.MONDAY) && (dow <= Calendar.FRIDAY));

        if(isWeekday == true)
        {
            if (vehicle == VehicleType.Cars)
            {
                cost = CAR_TOLL_COST;
            }else if (vehicle == VehicleType.Busses)
            {
                cost = BUSSES_TOLL_COST;
            }else if(vehicle == VehicleType.HGV)
            {
                cost = HGV_TOLL_COST;
            }else
            {
                cost = SERVICE_TOLL_COST;
            }
        }else
        {
            // Weekend - Tolls Are Cheaper by 30%
            if (vehicle == VehicleType.Cars)
            {
                cost = (CAR_TOLL_COST - ((CAR_TOLL_COST / 100) * 30));
            }else if (vehicle == VehicleType.Busses)
            {
                cost = (BUSSES_TOLL_COST - ((BUSSES_TOLL_COST / 100) * 30));
            }else if(vehicle == VehicleType.HGV)
            {
                cost = (HGV_TOLL_COST - ((HGV_TOLL_COST / 100) * 30));
            }else
            {
                cost = (SERVICE_TOLL_COST - ((SERVICE_TOLL_COST / 100) * 30));
            }
        }
    }

}
