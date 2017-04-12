104062111 資工19 游欣為

How does it work
	[Catch the Pokemon]
		- The pokemon will appear as long as the counter time up
		- Click the pokemon before it hide again
		- You should click the middle of the bush
		- You should NOT clicked the Diglett or Dugtrio, otherwise you will minus one point
		- You will add one point when you catch grass type pokemons

  [What's special]
		- There'll be chance of the appearance of fairy (ID: 845),
      you need to clicked it three times, it will metamorphosis twice
      until you catch it, and when you catch the special speicies
      you will catch all the grass type pokemon on the screen and also
      get extra 10 points!

Details
  - MouseListener for control the catcher
  - In the catch method, I set different action for the special fairy
  - The counter for {HIDE} {SHOW} {CATCH} is generated differently and randomly.
  - There's a Thread.sleep function to slow down the speed of the update rate
    in order to let the user has a clear look of the pokemon and even time to response

Problem Encounter
  - I first put the thread sleep inside the invokeLater method, and that crash the program,
    I found out that it will conflict after googling "invokeLater sleep"
    
