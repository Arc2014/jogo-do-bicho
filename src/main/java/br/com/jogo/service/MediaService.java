package br.com.jogo.service;

import br.com.jogo.model.Aposta;
import br.com.jogo.to.RelatorioMilharCentenaTO;
import br.com.jogo.util.FacesUtil;
import br.com.jogo.util.ObjectUtil;
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
        FileInputStream in = new FileInputStream(new File("C:/jogo-do-bicho/beep-aposta.wav"));
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

    public static boolean podeTocarAlarme(RelatorioMilharCentenaTO relatorioTO, Aposta aposta){
        if (aposta.isApostaValorSperior10()) {
            return true;
        } else if (aposta.getNumero().equals(relatorioTO.getNumero()) && ObjectUtil.isValidNumber(aposta.getValorApostaPrimeiroPremio()) && ObjectUtil.isValidNumber(relatorioTO.getValorTotalPrimeiroPremio())){
            return true;
        } else {
            return false;
        }
    }
}
