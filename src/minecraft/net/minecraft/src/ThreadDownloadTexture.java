package net.minecraft.src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

//UMC Class

public class ThreadDownloadTexture extends Thread{

	private File dir;
	private GuiTexturePacks tp;

	public ThreadDownloadTexture(File minecraftDir, GuiTexturePacks guiTexturePacks) {
		this.dir = minecraftDir;
		this.tp =  guiTexturePacks;
	}
public void run(){
	tp.downloading = true;
	try{
		downloadResource(new URL("http://dl.dropbox.com/u/7562870/UMC%20Texture%20Pack.zip"),new File(dir.getAbsolutePath()+File.separator+"texturepacks","UMCTexturePack.zip"));
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	tp.downloading = false;
	}
public void downloadResource(URL url,File save_to) {
    try {
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("content-type", "binary/data");
        InputStream in = conn.getInputStream();
        FileOutputStream out = new FileOutputStream(save_to );

        byte[] b = new byte[1024];
        int count;

        while ((count = in.read(b)) > 0) {
            out.write(b, 0, count);
        }
        out.close();
        in.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
