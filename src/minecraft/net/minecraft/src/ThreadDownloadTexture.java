package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.net.URL;

import net.minecraft.client.Minecraft;

//UMC Class

public class ThreadDownloadTexture extends Thread{

	private Minecraft mc;
	private File dir;

	public ThreadDownloadTexture(File minecraftDir, Minecraft mc) {
		this.mc = mc;
		this.dir = minecraftDir;
	}
public void run(){
	try{
		downloadResource(new URL("http://dl.dropbox.com/u/7562870/UMC%20Texture%20Pack.zip"),new File(dir.getAbsolutePath()+File.separator+"texturepacks","UMC TexturePack.zip"),0);
		mc.texturePackList.updateAvaliableTexturePacks();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
private void downloadResource(URL url, File file, long l)
		throws IOException
		{
	byte abyte0[] = new byte[4096];
	DataInputStream datainputstream = new DataInputStream(url.openStream());
	DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file));
	for (int i = 0; (i = datainputstream.read(abyte0)) >= 0;)
	{
		dataoutputstream.write(abyte0, 0, i);
		datainputstream.close();
		dataoutputstream.close();
	}
	
  }
}
