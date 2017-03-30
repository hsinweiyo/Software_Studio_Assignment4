package com.sslab.pokemon.guicomponent;

import com.sslab.pokemon.PokemonSprite;

import javax.swing.*;

/**
 * Created by jerry on 2017/3/26.
 */
public class PokemonLabel extends JLabel{

    public PokemonLabel()
    {
        setIcon(PokemonSprite.bushIcon());
    }

    public void Update()
    {
        //TODO setup a counter, if time up you may want to change to another state
    }

    public void popPokemon(){
        //TODO when a pokemon pop up
    }
    public void hidePokemon()
    {
        //TODO when the pokemon hide into the bushes
    }
    public void caught()
    {
        //TODO when player caught the pokemon
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
