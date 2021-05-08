package com.hacom.demo.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Autowired
    ConfigurationApp configuration;

    @Bean
    public MongoClient mongoClient() {

        return MongoClients.create(configuration.getMongodbUri());

    }

    @Autowired
    protected String getDatabaseName() {

        return configuration.getMongodbDatabase();

    }

    @Bean
    public MongoCustomConversions customConversions() {

        return new MongoCustomConversions(Arrays.asList(
                new DateToOffsetDateTimeConverter(),
                new OffsetDateTimeToDateConverter()
        ));

    }

    public class DateToOffsetDateTimeConverter implements Converter<Date, OffsetDateTime> {

        @Override
        public OffsetDateTime convert(Date source) {
            return source == null ? null : OffsetDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
        }

    }

    public class OffsetDateTimeToDateConverter implements Converter<OffsetDateTime, Date> {

        @Override
        public Date convert(OffsetDateTime source) {
            return source == null ? null : Date.from(source.toInstant());
        }

    }

}
