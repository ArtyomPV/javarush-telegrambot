package ru.prusov.jrtb.telegrambot.javarush_telegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static ru.prusov.jrtb.telegrambot.javarush_telegrambot.command.CommandName.STOP;
import static ru.prusov.jrtb.telegrambot.javarush_telegrambot.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
class StopCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}