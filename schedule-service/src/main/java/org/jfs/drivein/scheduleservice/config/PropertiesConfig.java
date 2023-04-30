package org.jfs.drivein.scheduleservice.config;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "time")
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class PropertiesConfig {

    private String slotTimeA;
    private String slotTimeB;
    private String SlotTimeC;
}
