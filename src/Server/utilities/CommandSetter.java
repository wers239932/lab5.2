package Server.utilities;

import Server.commands.*;
import Server.utilities.CommandArray;

/**
 * наполняет CommandArray начальными командами, позволяет добавлять новые
 */
public class CommandSetter {
    public static void setCommands(CommandArray commandArray)
    {
        commandArray.addCommand(new String[]{"exit"}, Exit.class);
        commandArray.addCommand(new String[]{"help"}, Help.class);
        commandArray.addCommand(new String[]{"add"}, Add.class);
        commandArray.addCommand(new String[]{"write"}, OutputCommand.class);
        commandArray.addCommand(new String[]{"show"}, Show.class);
        commandArray.addCommand(new String[]{"save"}, Save.class);
        commandArray.addCommand(new String[]{"info"}, Info.class);
        commandArray.addCommand(new String[]{"update"}, Update.class);
        commandArray.addCommand(new String[]{"execute_script"}, ExecuteScript.class);
        commandArray.addCommand(new String[]{"remove_by_id"}, RemoveById.class);
        commandArray.addCommand(new String[]{"clear"}, Clear.class);
        commandArray.addCommand(new String[]{"remove_first"}, RemoveFirst.class);
        commandArray.addCommand(new String[]{"remove_greater"}, RemoveGreater.class);
        commandArray.addCommand(new String[]{"remove_all_by_car_code"}, RemoveAllByCarCode.class);
        commandArray.addCommand(new String[]{"sum_of_car_code"}, SumOfCarCode.class);
        commandArray.addCommand(new String[]{"count_greater_than_capital"}, CountGreaterThanCapital.class);
    }
    public void addCommand(Class commandClass, CommandArray commandArray, String[] names)
    {
        commandArray.addCommand(names, commandClass);
    }
}
