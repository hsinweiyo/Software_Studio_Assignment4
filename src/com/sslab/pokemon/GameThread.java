package com.sslab.pokemon;

import com.sslab.pokemon.guicomponent.PokemonLabel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by jerry on 2017/3/26.
 */
public class GameThread implements Runnable {
    ArrayList<PokemonLabel> pokemons;
    private Thread thread;
        public GameThread(ArrayList<PokemonLabel> pokemonLabels){
            //TODO create and start the thread
            /* create a thread and start it */
            this.pokemons = pokemonLabels;
            thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run() {
            while(true)
            {
                /* sleep 100 millis per cycle */
                speedDown();

                /* use invokeLater to Update the JLabel simultaneously */
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        /* Update every Label with the for loop */
                        for(PokemonLabel pokemon : pokemons) {
                            pokemon.Update();
                        }
                    }
                });

            }
        }

        private void speedDown() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
