package org.mik.first.spring.component;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.NamingConvention;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Log4j2
@Endpoint(id=AppStatistics.BASE_NAME)
public class AppStatistics {
    public static final String BASE_NAME="app.stat";

    private final MeterRegistry meterRegistry;

    private final Map<String, AtomicLong> counters=new HashMap<>();

    @Autowired
    public AppStatistics(MeterRegistry meterRegistry){
        this.meterRegistry=meterRegistry;
        this.meterRegistry.config().namingConvention(NamingConvention.dot);
    }

    public void increment(String index){
        AtomicLong gauge = findItem(index);
        gauge.incrementAndGet();
    }

    public void set(String index, long v) {
        AtomicLong gauge = findItem(index);
        gauge.set(v);
    }

    private AtomicLong findItem(String index) {
        String idx=String.format("%s.%s", BASE_NAME, index);
        if(counters.containsKey(idx))
            return counters.get(idx);

        AtomicLong res = this.meterRegistry.gauge(idx, new AtomicLong());
        this.counters.put(idx, res);
        return res;
    }

}
