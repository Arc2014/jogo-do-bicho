package br.com.jogo.service;

import br.com.jogo.util.FacesUtil;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.Clip;
import java.applet.Applet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class MediaService implements Serializable{
    ;

    private static AudioStream getMedia() throws Exception {
        FileInputStream in = new FileInputStream(new File("cantar_do_galo.mp3"));
        AudioStream as = new AudioStream(in);
        return as;
    }

    public static void play() {
        try {
            AudioPlayer.player.start(getMedia());
        } catch (Exception e) {
            FacesUtil.mostrarMensagemErro("mensagem.erro.alerta.inisistente");
            e.printStackTrace();
        }
    }

}
