package com.sslab.pokemon.guicomponent;

import com.sslab.pokemon.PokemonSprite;

import javax.swing.*;
import java.util.Random;

/**
 * Created by jerry on 2017/3/26.
 */
public class PokemonLabel extends JLabel{
    private int timeup;

    int ID = 0;
    int counter = 0;
    Random random = new Random();
    public PokemonLabel() {
        setIcon(PokemonSprite.bushIcon());
        timeup = WhacPokemonState.Hide.value + random.nextInt(30);
    }

    public void Update()
    {
        //TODO setup a counter, if time up you may want to change to another state
        switch (state) {
            case Hide:
                if(counter == timeup) {
                    popPokemon();
                    counter = 0;
                }
                break;
            case Show:
                if(counter == WhacPokemonState.Show.value) {
                    hidePokemon();
                    counter = 0;
                }
                break;
            case Caught:
                if(counter == WhacPokemonState.Caught.value) {
                    hidePokemon();
                    counter = 0;
                }
                break;
        }
        counter++;
    }

    public void popPokemon(){
        //TODO when a pokemon pop up
        Random random = new Random();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ID = random.nextInt(5);
                ImageIcon icon = new ImageIcon(PokemonSprite.getSprite(ID));
                setIcon(icon);
                state = WhacPokemonState.Show;
            }
        });
    }
    public void hidePokemon()
    {
        //TODO when the pokemon hide into the bushes
        setIcon(PokemonSprite.bushIcon());
        state = WhacPokemonState.Hide;
    }
    public void caught()
    {
        //TODO when player caught the pokemon
        setIcon(PokemonSprite.pokeballIcon());
        state = WhacPokemonState.Caught;
    }

    public boolean isCatchable()
    {
        //a beautiful way to write it, no need to use if
        return state == WhacPokemonState.Show;
    }
    WhacPokemonState state = WhacPokemonState.Hide;

    public int getID() {
        return ID;
    }
}
enum WhacPokemonState{
    Hide(35),Show(15),Caught(25);

    int value;

    WhacPokemonState(int v) {
        this.value = v;
    }
}
