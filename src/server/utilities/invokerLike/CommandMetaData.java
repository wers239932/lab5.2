package server.utilities.invokerLike;

import server.commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommandMetaData {
    private static HashMap<Class<? extends Command>, ArrayList<Boolean>> metaData = new HashMap<>();

    public static void setMetaData()
    {
        metaData.put(Exit.class, new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false,false)));
        metaData.put(Help.class, new ArrayList<Boolean>(Arrays.asList(true,false,false,false,false,false)));
        metaData.put(Add.class, new ArrayList<Boolean>(Arrays.asList(false,false,false,true,true,false)));
        metaData.put(OutputCommand.class, new ArrayList<Boolean>(Arrays.asList(false,false,true,false,false,false)));
        metaData.put(Show.class, new ArrayList<Boolean>(Arrays.asList(false,false,false,false,true,false)));
        metaData.put(Save.class, new ArrayList<Boolean>(Arrays.asList(false,false,false,false,true,false)));
        metaData.put(Info.class, new ArrayList<Boolean>(Arrays.asList(false,false,false,false,true,false)));
        metaData.put(Update.class, new ArrayList<Boolean>(Arrays.asList(false,false,true,true,true,false)));
        metaData.put(ExecuteScript.class, new ArrayList<Boolean>(Arrays.asList(false,true,true,false,true,false)));
        metaData.put(RemoveById.class, new ArrayList<Boolean>(Arrays.asList(false,false,true,false,true,false)));
        metaData.put(Clear.class, new ArrayList<Boolean>(Arrays.asList(false,false,false,false,true,false)));
        metaData.put(RemoveFirst.class, new ArrayList<Boolean>(Arrays.asList(false,false,false,false,true,false)));
        metaData.put(RemoveGreater.class, new ArrayList<Boolean>(Arrays.asList(false,false,false,false,true,false)));
        metaData.put(RemoveLower.class, new ArrayList<Boolean>(Arrays.asList(false,false,false,false,true,false)));
        metaData.put(RemoveAllByCarCode.class, new ArrayList<Boolean>(Arrays.asList(false,false,true,false,true,false)));
        metaData.put(SumOfCarCode.class, new ArrayList<Boolean>(Arrays.asList(false,false,false,false,true,false)));
        metaData.put(CountGreaterThanCapital.class, new ArrayList<Boolean>(Arrays.asList(false,false,true,false,true,false)));
    }
    public static ArrayList<Boolean> getData(Class<? extends Command> commandClass)
    {
        return metaData.get(commandClass);
    }
    public static void addCommandData(Class<? extends Command> commandClass, ArrayList<Boolean> data)
    {
        metaData.put(commandClass,data);
    }
}
