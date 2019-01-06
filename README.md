# Andriod Number Guessing Game
The  Number Guessing Game is my second Andriod application which is a remake of the number guessing Game I made in JavaFX. 

For this project, I learnt to implement more than one button and use multiple activities, and when the game player guess the correct number, they would be congratulated in another activity. I also learnt about Activity lifecycle which allowed me to save the array of higher or lower guessed numbers as well as the current random number that the game player would guess.  This is important otherwise there would be loss of game information for the session if the user exits the app or rotates the orientation of their android device. 

https://developer.android.com/guide/components/activities/activity-lifecycle

The Number Guessing Game has random numbers between 0 and a 100 that the game player would guess. Every time the player guesses a number, they lose 10 points from the score. Both the higher and lower guess than the number is displayed to make the game more user-friendly. The user can also use a hint and which the random range higher and lower is provided to the player, but they lose 20 points instantly everytime they use the hint

The java code for the project is below. 
