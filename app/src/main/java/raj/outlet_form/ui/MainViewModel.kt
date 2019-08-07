package raj.outlet_form.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.text.Editable
import android.util.Log
import raj.outlet_form.data.ElementRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val elementRepository: ElementRepository
    private var adapter: AdapterRecyclerViewImpl? = null
      var selected = MutableLiveData<Element>()
      val outletList = HashMap<String,String>()
      val outletSecondScreen = HashMap<Int,String>()
      var elementNode = MutableLiveData<Element>()
      var elementText = MutableLiveData<String>()
      var bottomList = MutableLiveData<String>()



    internal var elemnetList: MutableLiveData<List<Element>>

    init {
        elementRepository = ElementRepository(application)
        elemnetList = elementRepository.getElementList1()
    }

    fun getAllWords(screen: Int): LiveData<List<Element>> {
        if(screen == 1)
        {
            elemnetList = elementRepository.getElementList1()
        }
        else if(screen == 2)
        {
            elemnetList = elementRepository.getElementList2()
        }
        else if(screen == 3)
        {
            elemnetList = elementRepository.getElementList3()

        }
        return elemnetList
    }


    fun getBottomList(tag: String): LiveData<List<String>>
    {
        return elementRepository.getBottomList(toString())
    }


    fun setDropDownValue(value:String,viewname:String)
    {
        Log.d("method invoke", ": setDropDownValue")

        outletList.put(viewname,value)
    }


    fun onTextChanged(pos : Int , value : Editable, nameTag: CharSequence) {
        elementText.value = value.toString()
        var tag = nameTag
        outletList.put(tag.toString(), value.toString())
    }

    fun getText(value : CharSequence): String? {
            return outletList.get(value.toString())
    }

    fun onItemClick(index: Int?) {
        val db = getElementAtIndex(index)
        selected.value= db
    }




    fun getElementAtIndex(index: Int?): Element? {
        return if (elemnetList.getValue() != null &&
            index != null
        ) {
            elemnetList.value?.elementAt(index)
        } else null
    }


    fun checkonclick() {
        Log.d("method checkonclick", ": checkonclick")

    }












}