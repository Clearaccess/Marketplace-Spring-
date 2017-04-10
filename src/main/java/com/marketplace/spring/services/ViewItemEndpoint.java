package com.marketplace.spring.services;

import com.marketplace.spring.controllers.HelperController;
import com.marketplace.spring.models.Item;
import com.marketplace.spring.views.entities.ViewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.Random;

/**
 * Created by Aleksandr_Vaniukov on 4/7/2017.
 */
@Endpoint
public class ViewItemEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8888/ws/schema";

    @Autowired
    private HelperController helperController;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ItemsRequest")
    @ResponsePayload
    public List<ViewItem> getCountry() {
        List<ViewItem>items=helperController.getViewItems();
        return items;
    }
}
