package stronov.lab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<MainFragment>(R.id.fragment_container_view)
        }
    }
}

fun FragmentActivity.navigateToResultFragment(questionText: String, answerText: String) {
    val fragment = ResultFragment.newInstance(questionText, answerText)
    supportFragmentManager.commit {
        setReorderingAllowed(true)
        replace(R.id.fragment_container_view, fragment)
        addToBackStack(null)
    }
}