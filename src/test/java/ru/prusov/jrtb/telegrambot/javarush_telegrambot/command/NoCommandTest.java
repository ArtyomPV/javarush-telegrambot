package ru.prusov.jrtb.telegrambot.javarush_telegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static ru.prusov.jrtb.telegrambot.javarush_telegrambot.command.CommandName.NO;
import static ru.prusov.jrtb.telegrambot.javarush_telegrambot.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
class NoCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}