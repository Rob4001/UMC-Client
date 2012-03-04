package net.minecraft.src;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.Sys;

public class GuiTexturePacks extends GuiScreen
{
    protected GuiScreen guiScreen;
    private int refreshTimer;

    /** the absolute location of this texture pack */
    private String fileLocation;

    /**
     * the GuiTexturePackSlot that contains all the texture packs and their descriptions
     */
    private GuiTexturePackSlot guiTexturePackSlot;
    private ThreadDownloadTexture txtDownloadThread; //UMC
	public boolean downloading;//UMC

    public GuiTexturePacks(GuiScreen par1GuiScreen)
    {
        refreshTimer = -1;
        fileLocation = "";
        guiScreen = par1GuiScreen;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
  //UMC Start
    public void initGui()
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        controlList.add(new GuiSmallButton(5, width / 2 - 154, height - 48, stringtranslate.translateKey("texturePack.openFolder")));
        controlList.add(new GuiSmallButton(9, width / 2 + 4, height - 48, stringtranslate.translateKey("Update UMC Texture Pack")));
        controlList.add(new GuiSmallButton(6, width / 2 + 4, height - 24, stringtranslate.translateKey("gui.done")));
        mc.texturePackList.updateAvaliableTexturePacks();
        fileLocation = (new File(Minecraft.getMinecraftDir(), "texturepacks")).getAbsolutePath();
        guiTexturePackSlot = new GuiTexturePackSlot(this);
        guiTexturePackSlot.registerScrollButtons(controlList, 7, 8);
    }
    

    protected void actionPerformed(GuiButton guibutton)
    {
        if(!guibutton.enabled)
        {
            return;
        }
        if(guibutton.id == 5)
        {
            Sys.openURL((new StringBuilder()).append("file://").append(fileLocation).toString());
           
        } else
        if(guibutton.id == 6)
        {
            mc.renderEngine.refreshTextures();
            mc.displayGuiScreen(guiScreen);
        } else if(guibutton.id == 9){
        	txtDownloadThread = new ThreadDownloadTexture(mc.getMinecraftDir(),this);
        	txtDownloadThread.start();
        }else
        {
            guiTexturePackSlot.actionPerformed(guibutton);
        }
    }
  //UMC End

    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int par1, int par2, int par3)
    {
        super.mouseClicked(par1, par2, par3);
    }

    /**
     * Called when the mouse is moved or a mouse button is released.  Signature: (mouseX, mouseY, which) which==-1 is
     * mouseMove, which==0 or which==1 is mouseUp
     */
    protected void mouseMovedOrUp(int par1, int par2, int par3)
    {
        super.mouseMovedOrUp(par1, par2, par3);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        guiTexturePackSlot.drawScreen(par1, par2, par3);

        if (refreshTimer <= 0)
        {
            mc.texturePackList.updateAvaliableTexturePacks();
            refreshTimer += 20;
        }

        StringTranslate stringtranslate = StringTranslate.getInstance();
        drawCenteredString(fontRenderer, stringtranslate.translateKey("texturePack.title"), width / 2, 16, 0xffffff);
        drawCenteredString(fontRenderer, stringtranslate.translateKey("texturePack.folderInfo"), width / 2 - 77, height - 26, 0x808080);
        super.drawScreen(par1, par2, par3);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        refreshTimer--;
    }

    static Minecraft func_22124_a(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static Minecraft func_22126_b(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static Minecraft func_22119_c(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static Minecraft func_22122_d(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static Minecraft func_22117_e(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static Minecraft func_35307_f(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static Minecraft func_35308_g(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static Minecraft func_22118_f(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static Minecraft func_22116_g(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static Minecraft func_22121_h(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static Minecraft func_22123_i(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.mc;
    }

    static FontRenderer func_22127_j(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.fontRenderer;
    }

    static FontRenderer func_22120_k(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.fontRenderer;
    }

    static FontRenderer func_22125_l(GuiTexturePacks par0GuiTexturePacks)
    {
        return par0GuiTexturePacks.fontRenderer;
    }
}
