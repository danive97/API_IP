package com.ufv.dis.final2022.DOV;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IP {
    @JsonProperty("ip_from")
    private long ip_from;

    @JsonProperty("country_code")
    private String country_code;

    @JsonProperty("region_name")
    private String region_name;

    @JsonProperty("zip_code")
    private String zip_code;
    @JsonProperty("time_zone")
    private String time_zone;


    public long getIp_from(Object o) {
        return ip_from;
    }

    public void setIp_from(long ip_from) {
        this.ip_from = ip_from;
    }


    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }



    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }


    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public IP() {

    }

    public IP(long ip_from, String country_code, String region_name, String zip_code, String time_zone) {
        this.ip_from = ip_from;
        this.country_code = country_code;
        this.region_name = region_name;
        this.zip_code = zip_code;
        this.time_zone = time_zone;
    }

    @Override
    public String toString() {
        return "IP{" +
                "ip_from=" + ip_from +
                ", country_code=" + country_code +
                ", region_name='" + region_name + '\'' +
                ", zip_code=" + zip_code +
                ", time_zone=" + time_zone +
                '}';
    }

}
