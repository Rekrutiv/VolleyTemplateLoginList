package rekrutiv.om.zup


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.app.AppCompatActivity

import com.android.volley.RequestQueue
import android.support.v7.widget.RecyclerView
import com.android.volley.toolbox.Volley


import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONArray
import com.android.volley.toolbox.JsonObjectRequest
import java.util.*
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_user_result.*


const val EXTRA_EID = "likes"
const val EXTRA_VIEWS = "views"
const val EXTRA_USER = "user"
const val EXTRA_PAGEURL = "pageURL"
const val EXTRA_CONTACTS= "client_contacts"
const val EXTRA_to_notes = "to_notes"
const val EXTRA_convert_status= "convert_status"
const val EXTRA_client_notes= "client_notes"
const val EXTRA_to_notes_r = "to_notes_r"


class UserResultFragment : Fragment(), ItemAdapter.OnItemClickListener  {
    private var mRecyclerView: RecyclerView? = null
    private var mExampleAdapter: ItemAdapter? = null
    private var mExampleList: ArrayList<Item>? = null
    private var mRequestQueue: RequestQueue? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_user_result,container,false)
        mRecyclerView=view.findViewById(R.id.recycler_view)
        mRecyclerView?.setHasFixedSize(true)
        mRecyclerView?.layoutManager = LinearLayoutManager(view.context)
        mExampleList = ArrayList()
        mRequestQueue = Volley.newRequestQueue(view.context)
        parseJSON()

        return view
    }

   private fun parseJSON() {
        val url = "http://dbonline.outsorcing.in.ua/riba_json/"
       val request = JsonObjectRequest(Request.Method.GET,
           url, null, Response.Listener<JSONObject> { response ->
               // fun onResponse(response: JSONObject) {
                    try {

                        val jsonArray = response.getJSONArray("userResult" )

                       for (i in 0 until jsonArray.length()) {
                            val user = jsonArray.getJSONObject(i)


                           val id = user.getString("eid")
                           val date = user.getString("client_lastresdate")
                           val client_reaction = user.getString("client_reaction")
                           val client_name = user.getString("client_name")
                           val client_contacts = user.getString("client_contacts")
                           val convert_status = user.getString("convert_status")
                          // val client_notes = user.getJSONArray("client_notes")
                           val to_notes = user.getString("taskResultCommentToNotes")
                           val to_notes_r = user.getString("taskResultCommentToNotesR")
//                           val client_note = ArrayList<String>()
//                           for (i in 0 until client_notes .length())
//                           {
//                               client_note.add(client_notes.getJSONObject(i).getString("name"))
//                           }
                           //Toast.makeText(this@MainActivity, "Its toast!", Toast.LENGTH_SHORT).show()

                            mExampleList!!.add(Item(id, client_reaction, date,
                                client_name,client_contacts,null,null, null,null))
                                //,client_note,to_notes,to_notes_r))
                      }

                        mExampleAdapter = ItemAdapter(view?.context, mExampleList)
                        mRecyclerView!!.setAdapter(mExampleAdapter)
                        mExampleAdapter!!.setOnItemClickListener(this@UserResultFragment)

                   } catch (e: JSONException) {
                        e.printStackTrace()
                   }

             //  }
            },  Response.ErrorListener {error->

                    error.printStackTrace()

            })

        mRequestQueue!!.add(request)
    }
//
    override fun onItemClick(position: Int) {
        val detailIntent = Intent(view?.context, All_listActivity::class.java)
        val clickedItem = mExampleList!!.get(position)

        detailIntent.putExtra(EXTRA_EID, clickedItem.id)
        detailIntent.putExtra(EXTRA_VIEWS, clickedItem.client_reaction)
        detailIntent.putExtra(EXTRA_USER, clickedItem.date)
        detailIntent.putExtra(EXTRA_PAGEURL, clickedItem.client_name)
        detailIntent.putExtra(EXTRA_CONTACTS, clickedItem.client_contacts)
//        detailIntent.putExtra(EXTRA_convert_status,clickedItem.convert_status)
//        detailIntent.putExtra(EXTRA_client_notes,clickedItem.client_notes)
//        detailIntent.putExtra(EXTRA_to_notes, clickedItem.to_notes)
//        detailIntent.putExtra(EXTRA_to_notes_r, clickedItem.to_notes_r)
       startActivity(detailIntent)
    }
}
