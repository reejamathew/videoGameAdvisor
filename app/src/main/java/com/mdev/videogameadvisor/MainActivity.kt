package com.mdev.videogameadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findGames = findViewById<Button>(R.id.find_game)

        //
        findGames.setOnClickListener{
            val gameGenres = findViewById<Spinner>(R.id.games_genres)
            val genre = gameGenres.selectedItem
            val gamesList = getGames(genre.toString())
            val descText = getDescription(genre.toString())
            val reducedGamesList = gamesList.reduce { str, item ->str + '\n' + item }
            val games = findViewById<TextView>(R.id.games)
            games.text = reducedGamesList
            val descript = findViewById<TextView>(R.id.games_description)
            descript.text = descText
        }
    }

    //
    fun getGames(genre:String): List<String>{
        return when (genre){
            "Action"-> listOf("Legend of Zelda","GTA5")
            "Adventure"-> listOf("Final Fantasy","Elden Ring")
            "Strategy"-> listOf("Age of Empires","StarCraft")
            "Sports"-> listOf("FIFA22","NBA2K22")
            "RPG"-> listOf("Elder Scrolls 4","Fallout")
            else -> listOf("Super Mario", "Kirby")
        }
    }

    //
    fun getDescription(genre: String):String{
        return when (genre) {
            "Action" -> "Action games focus on physical challenges that require hand-eye coordination and quick reflexes"
            "Adventure" -> "In Adventure games player assumes the role of a protagonist in an interactive story driven by exploration and/or puzzle-solving"
            "Strategy" -> "Strategy games is in which the players' decison-making skills have a high significance in determining  the outcome"
            "Sports" -> "Sports have been recreated with a game, including team sports, track and field, extreme sports and combat sports"
            "RPG" -> "RPG stands for ROLE PLAYING GAME in which player assumes the role of a character set in a fictional setting"
            else -> "Here the player makes a character move through an environment with a series of action based moves like running, jumping etc"
        }
    }
}
