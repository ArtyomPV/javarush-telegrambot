package ru.prusov.jrtb.telegrambot.javarush_telegrambot.bot.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "telegram-bot")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class TelegramProperties {
    String username;
    String token;
}
