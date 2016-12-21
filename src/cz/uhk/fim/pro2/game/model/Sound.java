package cz.uhk.fim.pro2.game.model;


import java.net.MalformedURLException;
import java.net.URL;
import java.applet.*;

public class Sound {

    private URL soubor;

    public Sound(String cesta){
       try {
            soubor = new URL("file:"+cesta);
        } catch (MalformedURLException vyjimka) {
            System.err.println(vyjimka);
        }
        Applet.newAudioClip(soubor).play();
    }

}