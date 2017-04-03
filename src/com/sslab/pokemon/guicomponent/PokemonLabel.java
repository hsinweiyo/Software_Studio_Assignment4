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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int target = (random.nextInt(11)) % 6;
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
                ImageIcon icon = new ImageIcon(PokemonSprite.getSprite(ID));
                setIcon(icon);
                state = WhacPokemonState.Show;
            }
        });
    }
    public void popPokemon(int ID) {
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
        //TODO when the pokemon hide into the bushes
        setIcon(PokemonSprite.bushIcon());
        state = WhacPokemonState.Hide;
    }
    public void caught()
    {
        //TODO when player caught the pokemon
        if(ID == 865)
            popPokemon(++ID);
        else if(ID == 866)
            popPokemon(++ID);
        else if(ID == 867)
            popPokemon(++ID);
        else {
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
    Hide(45),Show(15),Caught(25);

    int value;

    WhacPokemonState(int v) {
        this.value = v;
    }
}
