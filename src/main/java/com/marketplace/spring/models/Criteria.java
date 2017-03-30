package com.marketplace.spring.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

/**
 * Created by Aleksandr_Vaniukov on 3/23/2017.
 */
public class Criteria {
    @Min(0)
    private Long itemUID;
    private String title;
    private String description;
    @Min(1)
    private Double minPrice;
    @Min(1)
    private Double maxPrice;
    private Boolean onlyBuyItems;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Calendar startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Calendar expireDate;
    @Min(0)
    private Integer bidderCount;
    private SimpleDateFormat fmt;

    public Criteria(){
        this.onlyBuyItems=false;
    }

    public Criteria(Long itemUID, String title, String description, Double minPrice, Double maxPrice, Boolean onlyBuyItems, Calendar startDate, Calendar expireDate, Integer bidderCount) {
        this.itemUID = itemUID;
        this.title = title;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.onlyBuyItems = onlyBuyItems;
        this.startDate = startDate;
        this.expireDate = expireDate;
        this.bidderCount = bidderCount;
    }

    public Long getItemUID() {
        return itemUID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public Boolean getOnlyBuyItems() {
        return onlyBuyItems;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getExpireDate() {
        return expireDate;
    }

    public Integer getBidderCount() {
        return bidderCount;
    }

    public String getStartDateHtml5DateTimeLocale(){
        if(startDate!=null) {
            fmt = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm");
            return fmt.format(startDate.getTime());
        }

        return "";
    }

    public String getExpireDateHtml5DateTimeLocale(){
        if(expireDate!=null) {
            fmt = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm");
            return fmt.format(expireDate.getTime());
        }

        return "";
    }

    public void setItemUID(Long itemUID) {
        this.itemUID = itemUID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setOnlyBuyItems(Boolean onlyBuyItems) {
        this.onlyBuyItems = onlyBuyItems;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setExpireDate(Calendar expireDate) {
        this.expireDate = expireDate;
    }

    public void setBidderCount(Integer bidderCount) {
        this.bidderCount = bidderCount;
    }

}
