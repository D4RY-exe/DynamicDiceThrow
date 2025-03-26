package edu.temple.dicethrow

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
    val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* TODO 1: Load fragment(s)
            - Show _only_ ButtonFragment if portrait
            - show _both_ fragments if Landscape
          */
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonFragment = ButtonFragment()

        if (savedInstanceState == null){
            if (!isLandscape) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, buttonFragment)
                    .commit()
            } else {
                val detailFragment = DetailFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_left, buttonFragment)
                    .replace(R.id.fragment_container_right, detailFragment)
                    .commit()
            }
        }
    }

    /* TODO 2: switch fragments if die rolled and in portrait (no need to switch fragments if Landscape)
        */
    // This callback function gets invoked when the child Fragment invokes it
    // Remember to place Fragment transactions on BackStack so then can be reversed
    override fun buttonClicked() {
        if (!isLandscape){
            val resultFragment = ResultFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, resultFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}