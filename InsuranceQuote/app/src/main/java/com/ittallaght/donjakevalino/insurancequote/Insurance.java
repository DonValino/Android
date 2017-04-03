package com.ittallaght.donjakevalino.insurancequote;

/**
 * Created by Jake Valino on 03/04/2017.
 */

enum InsuranceType { Comprehensive, TPFT, TP}

public class Insurance {
    private int age;
    private int numberOfAccidents;
    private boolean hasFullLicense;
    private InsuranceType coverageType;

    // Constructor
    public Insurance(int ageIn, int numberOfAccidentsIn, boolean hasFullLicenseIn, InsuranceType coverageTypeIn)
    {
        age = ageIn;
        numberOfAccidents = numberOfAccidentsIn;
        hasFullLicense = hasFullLicenseIn;
        coverageType = coverageTypeIn;
    }

    // Getters
    public int GetAge()
    {
        return age;
    }

    public int GetNumberOfAccidents()
    {
        return numberOfAccidents;
    }

    public boolean GetHasFullLicense()
    {
        return hasFullLicense;
    }

    public InsuranceType GetCoverageType()
    {
        return coverageType;
    }

    // Setters
    public void setAge(int ageIn)
    {
        age = ageIn;
    }

    public void setNumberOfAccidents(int numberOfAccidentsIn)
    {
        numberOfAccidents = numberOfAccidentsIn;
    }

    public void setHasFullLicense(boolean hasFullLicenseIn)
    {
        hasFullLicense = hasFullLicenseIn;
    }

    public void setCoverageType(InsuranceType coverageTypeIn)
    {
        coverageType = coverageTypeIn;
    }

    // Calculate Quote
    public double calculateQuote()
    {
        if(hasFullLicense == true && numberOfAccidents == 0 && age >= 25)
        {
            // Best Scenario - No Accident and old enough for cheap quotes
            if(coverageType == InsuranceType.Comprehensive)
            {
                return 1000;
            }else if(coverageType == InsuranceType.Comprehensive.TPFT)
            {
                return 850;
            }else
            {
                return 700;
            }
        }else if(hasFullLicense == true && numberOfAccidents >= 1 && age >= 25)
        {
            // Second Best Scenario - Has an accident but old enough for cheaper quotes
            // More Expensive By 50 Euro
            if(coverageType == InsuranceType.Comprehensive)
            {
                return 1050;
            }else if(coverageType == InsuranceType.Comprehensive.TPFT)
            {
                return 900;
            }else
            {
                return 750;
            }
        }else if(hasFullLicense == false && numberOfAccidents == 0 && age >= 25)
        {
            // No Full License, no accidents but old enough
            if(coverageType == InsuranceType.Comprehensive)
            {
                return 1100;
            }else if(coverageType == InsuranceType.Comprehensive.TPFT)
            {
                return 950;
            }else
            {
                return 800;
            }
        }else if(hasFullLicense == false && numberOfAccidents >= 1 && age >= 25)
        {
            // No Full License, has accidents but old enough
            if(coverageType == InsuranceType.Comprehensive)
            {
                return 1150;
            }else if(coverageType == InsuranceType.Comprehensive.TPFT)
            {
                return 900;
            }else
            {
                return 800;
            }
        }else if(hasFullLicense == true && numberOfAccidents == 0 && age < 25)
        {
            // Has Full License, Don't have an accident but is a young driver
            // No Full License, no accidents but old enough
            if(coverageType == InsuranceType.Comprehensive)
            {
                return 1300;
            }else if(coverageType == InsuranceType.Comprehensive.TPFT)
            {
                return 1150;
            }else
            {
                return 900;
            }
        }else if(hasFullLicense == true && numberOfAccidents >= 1 && age < 25)
        {
            // Has Full License, have an accident but is a young driver
            if(coverageType == InsuranceType.Comprehensive)
            {
                return 1700;
            }else if(coverageType == InsuranceType.Comprehensive.TPFT)
            {
                return 1350;
            }else
            {
                return 1200;
            }
        }else if(hasFullLicense == false && numberOfAccidents == 0 && age < 25)
        {
            // Has Full License, Don't have an accident but is a young driver
            if(coverageType == InsuranceType.Comprehensive)
            {
                return 2150;
            }else if(coverageType == InsuranceType.Comprehensive.TPFT)
            {
                return 1800;
            }else
            {
                return 1400;
            }
        }else
        {
            // Has Full License, have an accident but is a young driver
            // Worse Case
            if(coverageType == InsuranceType.Comprehensive)
            {
                return 3550;
            }else if(coverageType == InsuranceType.Comprehensive.TPFT)
            {
                return 3000;
            }else
            {
                return 2800;
            }
        }
    }

}
