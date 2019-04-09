package rekrutiv.om.zup

import org.json.JSONArray
import java.util.*

data class Item (val id:String, val client_reaction: String, val date:String,
                 val client_name: String,val client_contacts:String,val convert_status:String?,
                 val client_notes: ArrayList<String>?, val to_notes:String?, val to_notes_r:String?)