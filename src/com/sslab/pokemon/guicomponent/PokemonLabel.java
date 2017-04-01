package com.sslab.pokemon.guicomponent;

import com.sslab.pokemon.PokemonSprite;

import javax.swing.*;
import java.util.Random;

/**
 * Created by jerry on 2017/3/26.
 */
public class PokemonLabel extends JLabel{
    private int counter = 0;
    private int timeup;
    public PokemonLabel() {
        setIcon(PokemonSprite.bushIcon());
        Random random = new Random();
        timeup = random.nextInt(20) + 10;
    }

    public void Update()
    {
        //TODO setup a counter, if time up you may want to change to another state
        if(counter == timeup) {
            switch (state) {
                case Caught: hidePokemon();
                case Hide: popPokemon();
                case Show: hidePokemon();
            }
        } else {
            counter++;
        }
    }

    public void popPokemon(){
        //TODO when a pokemon pop up
        Random random = new Random();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int index = random.nextInt(5);
                ImageIcon icon = new ImageIcon(PokemonSprite.getSprite(index));
                setIcon(icon);
                state = WhacPokemonState.Show;
            }
        });
        counter = 0;

    }
    public void hidePokemon()
    {
        //TODO when the pokemon hide into the bushes
        setIcon(PokemonSprite.bushIcon());
        state = WhacPokemonState.Hide;
        counter = 0;
    }
    public void caught()
    {
        //TODO when player caught the pokemon
        setIcon(PokemonSprite.pokeballIcon());
        state = WhacPokemonState.Caught;
        counter = 0;
    }

    public boolean isCatchable()
    {
        //a beautiful way to write it, no need to use if
        return state == WhacPokemonState.Show;
    }
    WhacPokemonState state = WhacPokemonState.Hide;

}
enum WhacPokemonState{
    Hide,Show,Caught
}
