package com.example.reproduccionaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play;
    SoundPool sp;
    int sonido_rep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.button2);
        //Maximo de reproducciones simultaneas, AudioManager y calidad de reproduccion
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC , 1);

        //Cargar pista de audio en el SoundPool
        //Load carga la pista a reproducir y prioridad (No se usa anymore)
        sonido_rep = sp.load(this, R.raw.sound_short , 1);
    }

    public void audioSoundPool (View view){
        //Reproducir la pista con play()
        //Id de pista de audio, volumen de canales por lado (1 y 1 es nivelado), Prioridad y repeticiones
        //-1 (Siempre repitiendo) , 0 (Solo 1 vez) y 1 (Se repetira una vez)
        //rate (Ultimo parametro) => velocidad o pitch de reproduccion, 0 es normal
        sp.play(sonido_rep, 1,1,1,1,0);
    }

    public void audioMediaPlayer(View view){
        //Context y ruta de pista
        MediaPlayer mp = MediaPlayer.create(this, R.raw.sound_long);
        //Iniciar reproduccion
        mp.start();
    }

}