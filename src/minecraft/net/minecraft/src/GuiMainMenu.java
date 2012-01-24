package net.minecraft.src;

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


public class GuiMainMenu extends GuiScreen
{
    private static final Random rand = new Random();
    private float updateCounter;
    private String splashText;
    private GuiButton multiplayerButton;
    private int field_35357_f;
    private int viewportTexture;

    public GuiMainMenu()
    {
        updateCounter = 0.0F;
        field_35357_f = 0;
        splashText = "missingno";
        try
        {
            ArrayList arraylist = new ArrayList();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.GuiMainMenu.class).getResourceAsStream("/title/splashes.txt"), Charset.forName("UTF-8")));
            String s = "";
            do
            {
                String s1;
                if ((s1 = bufferedreader.readLine()) == null)
                {
                    break;
                }
                s1 = s1.trim();
                if (s1.length() > 0)
                {
                    arraylist.add(s1);
                }
            }
            while (true);
            do
            {
                splashText = (String)arraylist.get(rand.nextInt(arraylist.size()));
            }
            while (splashText.hashCode() == 0x77f432f);
        }
        catch (Exception exception) { }
        updateCounter = rand.nextFloat();
    }

    public void updateScreen()
    {
        field_35357_f++;
    }

    public boolean doesGuiPauseGame()
    {
        return false;
    }

    protected void keyTyped(char c, int i)
    {
    }

    public void initGui()
    {
        viewportTexture = mc.renderEngine.allocateAndSetupTexture(new java.awt.image.BufferedImage(256, 256, 2));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (calendar.get(2) + 0 == 11 && calendar.get(5) == 9)
        {
            splashText = "Happy birthday, ez!";
        } 
		else if (calendar.get(2) + 0 == 6 && calendar.get(5) == 1)
        {
            splashText = "Happy birthday, Notch!";
        }
        else if (calendar.get(2) + 0 == 12 && calendar.get(5) == 24)
        {
            splashText = "Merry X-mas!";
        }
        else if (calendar.get(2) + 0 == 1 && calendar.get(5) == 1)
        {
            splashText = "Happy new year!";
        }
        if (calendar.get(2) + 0 == 2 && calendar.get(5) == 12)
        {
            splashText = "Happy birthday Gravypod!";
        }
        if (calendar.get(2) + 0 == 8 && calendar.get(5) == 8)
        {
            splashText = "Happy birthday Ninjasauce1, 8/8/9001!";
        }
        if (calendar.get(2) + 0 == 7 && calendar.get(5) == 1)
        {
            splashText = "Happy birthday croozee!";
        }
        if (calendar.get(2) + 0 == 7 && calendar.get(5) == 25)
        {
            splashText = "Happy birthday gut155!";
        }
        if (calendar.get(2) + 0 == 9 && calendar.get(5) == 12)
        {
            splashText = "Happy talk like a pirate day! Arrr!";
        }
        if (calendar.get(2) + 0 == 31 && calendar.get(5) == 12)
        {
            splashText = "Happy birthday Max!";
        }
        StringTranslate stringtranslate = StringTranslate.getInstance();
        int i = height / 4 + 48;
        controlList.add(new GuiButton(1, 10, i+24,100,20, stringtranslate.translateKey("menu.singleplayer")));
        controlList.add(new GuiButton(2, 10, i + 48,100,20, stringtranslate.translateKey("Play on UMC")));
        controlList.add(new GuiButton(3, 10, i + 72,100,20, stringtranslate.translateKey("menu.mods")));
        controlList.add(new GuiButton(10, width - 110, i + 24, 100, 20, stringtranslate.translateKey("Other Server")));
        controlList.add(new GuiButton(8, width- 110, i + 48,100,20, stringtranslate.translateKey("UMC Website")));
        if (mc.hideQuitButton)
        {
            controlList.add(new GuiButton(0, 10,i+ 96,100,20, stringtranslate.translateKey("menu.options")));
        } else
        {
            controlList.add(new GuiButton(0, 10, i + 96, 100, 20, stringtranslate.translateKey("menu.options")));
            controlList.add(new GuiButton(4, width -110 , i + 96, 100, 20, stringtranslate.translateKey("menu.quit")));
        }
        if (mc.session == null)
        {
            multiplayerButton.enabled = false;
        }
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if (guibutton.id == 0)
        {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }
        if (guibutton.id == 5)
        {
            mc.displayGuiScreen(new GuiLanguage(this, mc.gameSettings));
        }
        if (guibutton.id == 1)
        {
            mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if (guibutton.id == 2)
        {
        	mc.displayGuiScreen(new GuiConnecting(mc, "www.ultimateminecraft.net", 25565));
        }
        if (guibutton.id == 3)
        {
            mc.displayGuiScreen(new GuiTexturePacks(this));
        }
        if (guibutton.id == 4)
        {
            mc.shutdown();
        }
		        if (guibutton.id == 8)
        {
            Sys.openURL("www.ultimateminecraft.net");
        }
        if (guibutton.id == 10)
        {
        	mc.displayGuiScreen(new GuiMultiplayer(this));
        }      
    }

    private void func_35355_b(int i, int j, float f)
    {
        Tessellator tessellator = Tessellator.instance;
        GL11.glMatrixMode(5889 /*GL_PROJECTION*/);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GLU.gluPerspective(120F, 1.0F, 0.05F, 10F);
        GL11.glMatrixMode(5888 /*GL_MODELVIEW0_ARB*/);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
        GL11.glDisable(2884 /*GL_CULL_FACE*/);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        int k = 8;
        for (int l = 0; l < k * k; l++)
        {
            GL11.glPushMatrix();
            float f1 = ((float)(l % k) / (float)k - 0.5F) / 64F;
            float f2 = ((float)(l / k) / (float)k - 0.5F) / 64F;
            float f3 = 0.0F;
            GL11.glTranslatef(f1, f2, f3);
            GL11.glRotatef(MathHelper.sin(((float)field_35357_f + f) / 400F) * 25F + 20F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-((float)field_35357_f + f) * 0.1F, 0.0F, 1.0F, 0.0F);
            for (int i1 = 0; i1 < 6; i1++)
            {
                GL11.glPushMatrix();
                if (i1 == 1)
                {
                    GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                }
                if (i1 == 2)
                {
                    GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                }
                if (i1 == 3)
                {
                    GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
                }
                if (i1 == 4)
                {
                    GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
                }
                if (i1 == 5)
                {
                    GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                }
                GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture((new StringBuilder()).append("/title/bg/panorama").append(i1).append(".png").toString()));
                //FIX: Add the path to UMC for Logo!
                tessellator.startDrawingQuads();
                tessellator.setColorRGBA_I(0xffffff, 255 / (l + 1));
                float f4 = 0.0F;
                tessellator.addVertexWithUV(-1D, -1D, 1.0D, 0.0F + f4, 0.0F + f4);
                tessellator.addVertexWithUV(1.0D, -1D, 1.0D, 1.0F - f4, 0.0F + f4);
                tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0F - f4, 1.0F - f4);
                tessellator.addVertexWithUV(-1D, 1.0D, 1.0D, 0.0F + f4, 1.0F - f4);
                tessellator.draw();
                GL11.glPopMatrix();
            }

            GL11.glPopMatrix();
            GL11.glColorMask(true, true, true, false);
        }

        tessellator.setTranslationD(0.0D, 0.0D, 0.0D);
        GL11.glColorMask(true, true, true, true);
        GL11.glMatrixMode(5889 /*GL_PROJECTION*/);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888 /*GL_MODELVIEW0_ARB*/);
        GL11.glPopMatrix();
        GL11.glDepthMask(true);
        GL11.glEnable(2884 /*GL_CULL_FACE*/);
        GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
    }

    private void rotateAndBlurSkybox(float f)
    {
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, viewportTexture);
        GL11.glCopyTexSubImage2D(3553 /*GL_TEXTURE_2D*/, 0, 0, 0, 0, 0, 256, 256);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glBlendFunc(770, 771);
        GL11.glColorMask(true, true, true, false);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        byte byte0 = 3;
        for (int i = 0; i < byte0; i++)
        {
            tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F / (float)(i + 1));
            int j = width;
            int k = height;
            float f1 = (float)(i - byte0 / 2) / 256F;
            tessellator.addVertexWithUV(j, k, zLevel, 0.0F + f1, 0.0D);
            tessellator.addVertexWithUV(j, 0.0D, zLevel, 1.0F + f1, 0.0D);
            tessellator.addVertexWithUV(0.0D, 0.0D, zLevel, 1.0F + f1, 1.0D);
            tessellator.addVertexWithUV(0.0D, k, zLevel, 0.0F + f1, 1.0D);
        }

        tessellator.draw();
        GL11.glColorMask(true, true, true, true);
    }

    private void renderSkybox(int i, int j, float f)
    {
        GL11.glViewport(0, 0, 256, 256);
        func_35355_b(i, j, f);
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        rotateAndBlurSkybox(f);
        rotateAndBlurSkybox(f);
        rotateAndBlurSkybox(f);
        rotateAndBlurSkybox(f);
        rotateAndBlurSkybox(f);
        rotateAndBlurSkybox(f);
        rotateAndBlurSkybox(f);
        rotateAndBlurSkybox(f);
        GL11.glViewport(0, 0, mc.displayWidth, mc.displayHeight);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        float f1 = width <= height ? 120F / (float)height : 120F / (float)width;
        float f2 = ((float)height * f1) / 256F;
        float f3 = ((float)width * f1) / 256F;
        GL11.glTexParameteri(3553 /*GL_TEXTURE_2D*/, 10241 /*GL_TEXTURE_MIN_FILTER*/, 9729 /*GL_LINEAR*/);
        GL11.glTexParameteri(3553 /*GL_TEXTURE_2D*/, 10240 /*GL_TEXTURE_MAG_FILTER*/, 9729 /*GL_LINEAR*/);
        tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
        int k = width;
        int l = height;
        tessellator.addVertexWithUV(0.0D, l, zLevel, 0.5F - f2, 0.5F + f3);
        tessellator.addVertexWithUV(k, l, zLevel, 0.5F - f2, 0.5F - f3);
        tessellator.addVertexWithUV(k, 0.0D, zLevel, 0.5F + f2, 0.5F - f3);
        tessellator.addVertexWithUV(0.0D, 0.0D, zLevel, 0.5F + f2, 0.5F + f3);
        tessellator.draw();
    }

    public void drawScreen(int i, int j, float f)
    {
        renderSkybox(i, j, f);
        Tessellator tessellator = Tessellator.instance;
        char c = '\u0112';
        int k = width / 2 - c / 2;
        byte titleHight = 50;
        drawGradientRect(0, 0, width, height, 0x80ffffff, 0xffffff);
        drawGradientRect(0, 0, width, height, 0, 0x80000000);
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture("/title/mclogo.png"));
        //FIX: Add the path to UMC for Logo!
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if ((double)updateCounter < 0.0001D)
        {
            drawTexturedModalRect(k + 0, titleHight + 0, 0, 0, 99, 44);
            drawTexturedModalRect(k + 99, titleHight + 0, 129, 0, 27, 44);
            drawTexturedModalRect(k + 99 + 26, titleHight + 0, 126, 0, 3, 44);
            drawTexturedModalRect(k + 99 + 26 + 3, titleHight + 0, 99, 0, 26, 44);
            drawTexturedModalRect(k + 155, titleHight + 0, 0, 45, 155, 44);
        } else
        {
            drawTexturedModalRect(k + 0, titleHight + 0, 0, 0, 155, 44);
            drawTexturedModalRect(k + 155, titleHight + 0, 0, 45, 155, 44);
        }
        tessellator.setColorOpaque_I(0xffffff);
        GL11.glPushMatrix();
        GL11.glTranslatef(width / 2 + 90, 70F, 0.0F);
        GL11.glRotatef(-20F, 0.0F, 0.0F, 1.0F);
        float f1 = 1.8F - MathHelper.abs(MathHelper.sin(((float)(System.currentTimeMillis() % 1000L) / 1000F) * 3.141593F * 2.0F) * 0.1F);
        f1 = (f1 * 100F) / (float)(fontRenderer.getStringWidth(splashText) + 32);
        GL11.glScalef(f1, f1, f1);
        drawCenteredString(fontRenderer, splashText, 0, -8, 0xffff00);
        GL11.glPopMatrix();
        drawString(fontRenderer, "UMC client V1", 2, height - 10, 0xffffff);
        String s = "Copyright Mojang AB and UMC Devs and Gravy!";
        drawString(fontRenderer, s, width - fontRenderer.getStringWidth(s) - 2, height - 10, 0xffffff);
        super.drawScreen(i, j, f);
    }
}
