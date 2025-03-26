package edu.temple.dicethrow

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


/*
Our DieThrow application has been refactored to move the dieRoll() logic
into the ViewModel instead of the Fragment.
Study the DieViewModel, ButtonFragment, and DieFragment classes to
see the changes.

Follow the requirements below to have this app function
in both portrait and landscape configurations.
The Activity layout files for both Portrait and Landscape are already provided
*/

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {
    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        val buttonFragment = ButtonFragment()

        if (savedInstanceState == null){
            if (!isLandscape) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container1, buttonFragment)
                    .commit()
            } else {
                val dieFragment = DieFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container1, buttonFragment)
                    .replace(R.id.container2, dieFragment)
                    .commit()
            }
        }
    }

    override fun buttonClicked() {
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        if (!isLandscape){
            val dieFragment = DieFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, dieFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}