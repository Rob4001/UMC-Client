package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;

public class ChatHook
{
    private static ArrayList chatHooks = new ArrayList();

    public ChatHook()
    {
    }

    public static void addHook(ChatHookable chathookable)
    {
        chatHooks.add(chathookable);
    }

    public static void removeHook(ChatHookable chathookable)
    {
        chatHooks.remove(chathookable);
    }

    public static boolean checkChat(String s)
    {
        boolean flag = false;
        Iterator iterator = chatHooks.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ChatHookable chathookable = (ChatHookable)iterator.next();
            if (chathookable.checkIncomingChat(s))
            {
                flag = true;
            }
        }
        while (true);
        return flag;
    }
}
