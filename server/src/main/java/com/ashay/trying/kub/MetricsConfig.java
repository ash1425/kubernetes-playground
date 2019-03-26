package com.ashay.trying.kub;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.distribution.DistributionStatisticConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Value("${HOSTNAME}")
    private String hostname;

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> registryCustomizer() {
        return registry -> registry.config()
                .commonTags("service", "users", "hostname", hostname)
                .meterFilter(new MeterFilter() {
                    @Override
                    public DistributionStatisticConfig configure(Meter.Id id, DistributionStatisticConfig config) {
                        return config
                                .merge(DistributionStatisticConfig.builder()
                                        .percentilesHistogram(true)
                                        .percentiles(0.5, 0.75, 0.95, 0.99)
                                        .build());
                    }
                });
    }
}
