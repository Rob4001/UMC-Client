// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.Sys;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiButton, StatCollector, GuiOptions, 
//            StatList, StatFileWriter, World, GuiMainMenu, 
//            GuiAchievements, GuiStats, MathHelper

public class GuiIngameMenu extends GuiScreen
{

    private int updateCounter2;
    private int updateCounter;

    public GuiIngameMenu()
    {
        updateCounter2 = 0;
        updateCounter = 0;
    }

    public void initGui()
    {
        updateCounter2 = 0;
        controlList.clear();
        byte byte0 = -16;
        controlList.add(new GuiButton(1, width / 2 - 100, height / 4 + 144 + byte0, "Save and quit to title"));
        if(mc.isMultiplayerWorld())
        {
            ((GuiButton)controlList.get(0)).displayString = "Disconnect";
        }
        controlList.add(new GuiButton(4, width / 2 - 100, height / 4 + 24 + byte0, "Back to game"));
        controlList.add(new GuiButton(0, width / 2 - 100, height / 4 + 120 + byte0, "Options..."));
        if (this.mc.isMultiplayerWorld())  controlList.add(new GuiButton(10, width / 2 - 100, height / 4 + 72 + byte0, "Reconnect"));
        controlList.add(new GuiButton(11, width / 2 - 100, height / 4 + 96 + byte0, "TexturePacks"));
        controlList.add(new GuiButton(5, width / 2 - 100, height / 4 + 48 + byte0, 98, 20, StatCollector.translateToLocal("gui.achievements")));
        controlList.add(new GuiButton(6, width / 2 + 2, height / 4 + 48 + byte0, 98, 20, StatCollector.translateToLocal("gui.stats")));
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 0)
        {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }
        if(guibutton.id == 1)
        {
            mc.statFileWriter.readStat(StatList.leaveGameStat, 1);
            if(mc.isMultiplayerWorld())
            {
                mc.theWorld.sendQuittingDisconnectingPacket();
            }
            mc.changeWorld1(null);
            mc.displayGuiScreen(new GuiMainMenu());
        }
        if(guibutton.id == 4)
        {
            mc.displayGuiScreen(null);
            mc.setIngameFocus();
        }
        if(guibutton.id == 5)
        {
            mc.displayGuiScreen(new GuiAchievements(mc.statFileWriter));
        }
        if(guibutton.id == 6)
        {
            mc.displayGuiScreen(new GuiStats(this, mc.statFileWriter));
        }
        if(guibutton.id == 10)
        {
            mc.statFileWriter.readStat(StatList.leaveGameStat, 1);
            if(mc.isMultiplayerWorld())
            {
                mc.theWorld.sendQuittingDisconnectingPacket();
            }
            mc.changeWorld1(null);
            mc.displayGuiScreen(new GuiConnecting(mc, mc.lastIP, mc.lastPort));
        }
        if(guibutton.id == 11)
        {
           mc.displayGuiScreen(new GuiTexturePacks(this));
        }
     }

	public void updateScreen()
    {
        super.updateScreen();
        updateCounter++;
    }

    public void drawScreen(int i, int j, float f)
    {
        drawDefaultBackground();
        boolean flag = !mc.theWorld.func_650_a(updateCounter2++);
        if(flag || updateCounter < 20)
        {
            float f1 = ((float)(updateCounter % 10) + f) / 10F;
            f1 = MathHelper.sin(f1 * 3.141593F * 2.0F) * 0.2F + 0.8F;
            int k = (int)(255F * f1);
            drawString(fontRenderer, "Saving level..", 8, height - 16, k << 16 | k << 8 | k);
        }
        drawCenteredString(fontRenderer, "Game menu", width / 2, 40, 0xffffff);
        super.drawScreen(i, j, f);
    }
}