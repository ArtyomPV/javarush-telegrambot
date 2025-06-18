package ru.prusov.jrtb.telegrambot.javarush_telegrambot.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.command.CommandContainer;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.command.NoCommand;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.service.SendBotMessageServiceImpl;

import static ru.prusov.jrtb.telegrambot.javarush_telegrambot.command.CommandName.NO;

@Slf4j
@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {

    private static String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;
    @Value("${bot.username}")
    private  String username;
    @Value("${bot.token}")
    private  String token;

    public JavaRushTelegramBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("incoming update{}", update.getMessage().getText());
        if(update.hasMessage() && update.getMessage().hasText()){
            String chatId = update.getMessage().getChatId().toString();
            String message = update.getMessage().getText().trim();
            if(message.startsWith(COMMAND_PREFIX)){
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }



        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }


    @Override
    public String getBotToken() {
        return token;
    }
}
