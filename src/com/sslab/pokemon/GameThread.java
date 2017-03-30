package com.sslab.pokemon;

import com.sslab.pokemon.guicomponent.PokemonLabel;

import java.util.ArrayList;

/**
 * Created by jerry on 2017/3/26.
 */
public class GameThread implements Runnable {
    ArrayList<PokemonLabel> pokemons;
        public GameThread(ArrayList<PokemonLabel> pokemonLabels){
            //TODO create and start the thread

        }



        @Override
        public void run() {
            while(true)
            {
                //TODO Update the pokemonLabels
                //TODO use Thread.sleep to make the loop go slower

            }
        }

}
