package rekrutiv.om.zup


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button



/**
 * A fragment with a Google +1 button.
 */
class CalendarFragment : Fragment() {
    // The URL to +1.  Must be a valid URL.


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)



        return view
    }

 

    companion object {

        // The request code must be 0 or greater.
        private val PLUS_ONE_REQUEST_CODE = 0
    }


}// Required empty public constructor
