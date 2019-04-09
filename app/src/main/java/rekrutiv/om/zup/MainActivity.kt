package rekrutiv.om.zup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*





class MainActivity : AppCompatActivity() {



    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.cloud -> {
                    val fragment = UserResultFragment()
                    addFragment(fragment)

                    return true
                }
//                R.id.crm -> {
//                    val fragment = CRMFragment()
//                    addFragment(fragment)
//                    return true
//                }
//                R.id.home -> {
//                      val fragment =LoginFragment.Companion.newInstance()
//                     addFragment(fragment)
//                }
                 //R.id.add_to -> {
//                    var fragment = FragmentNotification()
//                    addFragment(fragment)
//                    return true
//                }
                                R.id.event_note -> {
                    var fragment = CalendarFragment()
                    addFragment(fragment)
                    return true
                }
            }
            return false
        }

    }

    /**
     * add/replace fragment in container [framelayout]
     */
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            //.setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.all_container, fragment, fragment.javaClass.getSimpleName())
            .addToBackStack(fragment.javaClass.getSimpleName())
            .commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = LoginFragment.Companion.newInstance()
        addFragment(fragment)

}
}
