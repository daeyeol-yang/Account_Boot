package com.nhnacademy.edu.springboot.account.management;

import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@EndpointWebExtension(endpoint = CounterEndpoint.class)
@Component
public class CounterWebEndPoint {
    private final CounterEndpoint target;
    public CounterWebEndPoint(CounterEndpoint target) {
        this.target = target;
    }
    @WriteOperation
    public WebEndpointResponse<Long> increment(@Nullable Long delta) {
        return new WebEndpointResponse<>(target.increment(delta));
    }
}
