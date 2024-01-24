package com.nhnacademy.edu.springboot.account.management;


import io.micrometer.core.lang.Nullable;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="counter")
public class CounterEndpoint {

    private final AtomicLong counter = new AtomicLong(0L);

    @ReadOperation
    public Long read(){
        return counter.get();
    }

    @WriteOperation
    public Long increment(@Nullable Long delta){
        if(delta==null){
            return counter.incrementAndGet();
        }
        return counter.addAndGet(delta);
    }

    @DeleteOperation
    public Long reset(){
        counter.set(0);
        return counter.get();
    }
}
