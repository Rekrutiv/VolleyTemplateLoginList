package rekrutiv.om.zup


import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONException
import org.json.JSONObject
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class LoginFragment : Fragment() {

    private var lRequestQueue: RequestQueue? = null
    private val REGISTER_URL = "https://dbonline.outsorcing.in.ua/office/"
    private val KEY_USERNAME = "usrlog"
    private val KEY_PASSWORD = "usrpsw"
    private val KEY_client_type = "client_type"
    private val TAG = "responselogin"



    companion object {
        fun newInstance(): LoginFragment {
            var fragmentHome = LoginFragment()
            var args = Bundle()
            fragmentHome.arguments = args
            return fragmentHome
        }}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_login,container,false)
        val login=v.findViewById(R.id.btn_login) as Button
        //val input_log=v.findViewById(R.id.input_login)
        lRequestQueue = Volley.newRequestQueue(v.context)
        login.setOnClickListener{
             LoginUser()

        }
        return v
    }

    private fun LoginUser() {
//        username = editTextUsername.getText().toString()
//        password = editTextPassword.getText().toString()
        val  username="242u2"
        val password="MhUlpJSO63u2"
        val client_type="mop_app"

//        val mapObject =  JSONObject()
//
//        mapObject.put(KEY_USERNAME, username)
//        mapObject.put(KEY_PASSWORD,password)
//        mapObject.put(KEY_client_type, client_type)


        val request =object : StringRequest(Request.Method.POST,
            REGISTER_URL,  Response.Listener<String> { response ->

                try {

                    Log.d(TAG, response.toString())
               Toast.makeText(view?.context, "Its toast!", Toast.LENGTH_SHORT).show()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

                //  }
            },  Response.ErrorListener { error->

                error.printStackTrace()

            }) {

            override
            fun getParams(): Map<String, String> =
                mapOf(KEY_USERNAME to username, KEY_PASSWORD to password, KEY_client_type to client_type)


         override fun parseNetworkResponse(response: NetworkResponse?): Response<String> {
                Log.i("response", response.toString())
                val cookiesInfo : java.util.TreeMap<String,String> = response?.headers as TreeMap<String, String>
                val cookie = response?.headers.toString()

           //  Toast.makeText(view?.context, cookie, Toast.LENGTH_SHORT).show()
             Log.d(TAG, cookie.toString())
                return super.parseNetworkResponse(response)
            }}
        lRequestQueue!!.add(request)
    }
}
