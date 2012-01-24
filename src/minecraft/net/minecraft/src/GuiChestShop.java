package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiChestShop extends GuiScreen{

	private static String allowedCharacters;
	private TileEntitySign entitySign;
	private int updateCounter;
	private String screenTitle;
	private GuiTextField item;
	private GuiTextField ia;
	private GuiTextField buy;
	private GuiTextField sell;

	public GuiChestShop(TileEntitySign entitySign) {
		this.entitySign = entitySign;
		screenTitle = "ChestShop GUI"; 

	}

	public void initGui()
    {
		controlList.add(new GuiButton(0,width / 2 - 50,height - 20,100,20,"Done"));
		item = new GuiTextField(this,fontRenderer, width / 2 - 50, 170,100,20,"");
		ia = new GuiTextField(this,fontRenderer, width / 2 - 50, 70,100,20,"");
		buy = new GuiTextField(this,fontRenderer, width / 2 -150, 120,100,20,"");
		sell = new GuiTextField(this,fontRenderer, width / 2 + 50, 120,100,20,"");

    }
	 protected void actionPerformed(GuiButton guibutton)
	    {
		 if(guibutton.id == 0){
			 entitySign.signText[0] = "";
			 entitySign.signText[1] = ia.getText();
			 entitySign.signText[2] = buy.getText()+":"+sell.getText();
			 entitySign.signText[3] = item.getText();
			 entitySign.onInventoryChanged();
	            mc.displayGuiScreen(null);
		 }
	    }
	  public void onGuiClosed()
	    {
	        Keyboard.enableRepeatEvents(false);
	        if(mc.theWorld.multiplayerWorld)
	        {
	            mc.getSendQueue().addToSendQueue(new Packet130UpdateSign(entitySign.xCoord, entitySign.yCoord, entitySign.zCoord, entitySign.signText));
	        }
	    }

	    public void updateScreen()
	    {
	        updateCounter++;
	    }

	    public void drawScreen(int i, int j, float f)
	    {
	        drawDefaultBackground();
	        drawCenteredString(fontRenderer, screenTitle, width / 2, 25, 0xffffff);
	        drawCenteredString(fontRenderer, "Item Amount", width / 2, 55, 0xffffff);
	        drawCenteredString(fontRenderer, "Buy                                            Sell", width / 2, 105, 0xffffff);
	        drawCenteredString(fontRenderer, "Item", width / 2, 155, 0xffffff);
	        item.drawTextBox();
	        ia.drawTextBox();
	        buy.drawTextBox();
	        sell.drawTextBox();
	        super.drawScreen(i, j, f);
	    }

	    static 
	    {
	        allowedCharacters = ChatAllowedCharacters.allowedCharacters;
	    }
	    protected void mouseClicked(int i, int j, int k)
	    {
	        super.mouseClicked(i, j, k);
	        item.mouseClicked(i, j, k);
	        ia.mouseClicked(i, j, k);
	        buy.mouseClicked(i, j, k);
	        sell.mouseClicked(i, j, k);

	    }
	    protected void keyTyped(char c, int i)
	    {
	        item.textboxKeyTyped(c, i);
	        ia.textboxKeyTyped(c, i);
	        buy.textboxKeyTyped(c, i);
	        sell.textboxKeyTyped(c, i);
	        if(c == '\r')
	        {
	            actionPerformed((GuiButton)controlList.get(0));
	        }
	        if(c == '\t'){
	        	if (ia.isFocused){
	        		ia.setFocused(false);
	        		buy.setFocused(true);
	        	}else if (buy.isFocused){
	        		buy.setFocused(false);
	        		sell.setFocused(true);
	        	}else if (sell.isFocused){
	        		sell.setFocused(false);
	        		item.setFocused(true);
	        	}else if (item.isFocused){
	        		item.setFocused(false);
	        		ia.setFocused(true);
	        	}
	        }
	    }

}