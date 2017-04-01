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
            this.pokemons = pokemonLabels;
            thread = new Thread(this);
            thread.start();
            System.out.println("thread start");
        }

        @Override
        public void run() {
            while(true)
            {
                //TODO Update the pokemonLabels
                //TODO use Thread.sleep to make the loop go slower
                speedDown();
                System.out.println("thread speed down");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        for(PokemonLabel pokemon : pokemons) {
                            System.out.println(pokemons.indexOf(pokemon) + "pokemonLabel updating");
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
