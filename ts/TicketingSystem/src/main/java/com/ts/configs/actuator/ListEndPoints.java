package com.ts.configs.actuator;

import java.util.List;

import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

@Component
public class ListEndPoints extends AbstractEndpoint<List<Endpoint>> {

    private List<Endpoint> endpoints;

    public ListEndPoints(List<Endpoint> endpoints) {
        super("endpoints");
        this.endpoints = endpoints;
    }


    @Override
    public List<Endpoint> invoke() {
        return endpoints;
    }
}