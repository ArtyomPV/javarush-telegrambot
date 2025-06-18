package ru.prusov.jrtb.telegrambot.javarush_telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.service.SendBotMessageService;

public class NoCommand implements Command{

    private final SendBotMessageService service;
    public final static String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\n"
            + "Чтобы посмотреть список команд введите /help";

    public NoCommand(SendBotMessageService service) {
        this.service = service;
    }

    @Override
    public void execute(Update update) {
        service.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
