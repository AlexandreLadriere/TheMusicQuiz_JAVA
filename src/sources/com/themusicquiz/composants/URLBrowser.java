/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-28 18:54:55 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-28 19:47:51
 */
package com.themusicquiz.composants;

import java.lang.Runtime;
import java.lang.StringBuffer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System;

public class URLBrowser {

    public URLBrowser() {}

    public void openWebPage(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.indexOf("win") >= 0) {
            openWebPage_Windows(url);
        }
        else if(os.indexOf("mac") >= 0) {
            openWebPage_Mac(url);
        }
        else if(os.indexOf("nix") >=0 || os.indexOf("nux") >=0) {
            openWebPage_Linux(url);
        }
    }

    private void openWebPage_Mac(String url) {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("open " + url);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void openWebPage_Windows(String url) {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler" + url);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void openWebPage_Linux(String url) {
        Runtime rt = Runtime.getRuntime();
        String[] browsers = { "epiphany", "firefox", "mozilla", "konqueror", "netscape", "opera", "links", "lynx" };
        
        StringBuffer cmd = new StringBuffer();
        for (int i = 0; i < browsers.length; i++) {
            if(i == 0)
                cmd.append(String.format(    "%s \"%s\"", browsers[i], url));
            else
                cmd.append(String.format(" || %s \"%s\"", browsers[i], url)); 
            // If the first didn't work, try the next browser and so on
        }
        try {
            rt.exec(new String[] { "sh", "-c", cmd.toString() });
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}