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
        timeup = WhacPokemonState.Hide.value + random.nextInt(35);
    }

    public void Update()
    {
        switch (state) {
            /* count down for the state */
            case Hide:
                if(counter == timeup) {
                    /* pop out the pokemon */
                    popPokemon();
                    /* reset the counter */
                    counter = 0;
                }
                break;
            case Show:
                if(counter == WhacPokemonState.Show.value) {
                    /* hide the pokemon and reset the counter */
                    hidePokemon();
                    counter = 0;
                }
                break;
            case Caught:
                if(counter == WhacPokemonState.Caught.value) {
                    /* hide the pokemon and reset the counter */
                    hidePokemon();
                    counter = 0;
                }
                break;
        }
        /* do the count */
        counter++;
    }

    public void popPokemon(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* arrange the probability of the pokemon shown up*/
                int target = (random.nextInt(11)) % 6;
                /* do the select of the pokemon */
                switch (target) {
                    case 3:
                        ID = 62;
                        break;
                    case 4:
                        ID = 64;
                        break;
                    case 5:
                        ID = 865;
                        break;
                    default:
                        ID = target;
                }
                /* set the icon */
                ImageIcon icon = new ImageIcon(PokemonSprite.getSprite(ID));
                setIcon(icon);
                /* change state to Show pokemon */
                state = WhacPokemonState.Show;
            }
        });
    }
    public void popPokemon(int ID) {
        /* show the pokemon by the id input */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageIcon icon = new ImageIcon(PokemonSprite.getSprite(ID));
                setIcon(icon);
                state = WhacPokemonState.Show;
            }
        });
    }
    public void hidePokemon()
    {
        setIcon(PokemonSprite.bushIcon());
        state = WhacPokemonState.Hide;
    }
    public void caught()
    {
        /* bonus pokemon, which will metamorphosis to its meta type */
        if(ID == 865)
            popPokemon(++ID);
        else if(ID == 866)
            popPokemon(++ID);
        else if(ID == 867)
            popPokemon(++ID);
        else {
            /* show the pokemon ball */
            setIcon(PokemonSprite.pokeballIcon());
            state = WhacPokemonState.Caught;
        }
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
    /* different state */
    Hide(45),Show(15),Caught(25);
    int value;

    WhacPokemonState(int v) {
        this.value = v;
    }
}
