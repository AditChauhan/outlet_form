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
    var elementNode = MutableLiveData<Element>()
    var elementText = MutableLiveData<String>()



    internal var elemnetList: MutableLiveData<List<Element>>


    init {
        Log.d("adit init", "init" )


        adapter = AdapterRecyclerViewImpl(this)
        elementRepository = ElementRepository(application)
        elemnetList = elementRepository.getElementList1()
    }

    fun getAllWords(screen: Int): LiveData<List<Element>> {
        Log.d("adit getAllWords", ""+ elemnetList)
        if(screen == 1)
        {
            elemnetList = elementRepository.getElementList1()
        }
        else if(screen == 2)
        {
            elemnetList = elementRepository.getElementList2()

        }

        return elemnetList
    }

    fun getAdapter() : AdapterRecyclerViewImpl?
    {
        return this!!.adapter
    }

    fun onTextChanged(pos : Int , value : Editable, nameTag: CharSequence) {
        elementText.value = value.toString()
        var tag = nameTag

        Log.d("adit onTextChanged ", ""+ tag)
        Log.d("adit onTextChanged", ""+ value.toString())

        outletList.put(tag.toString(), value.toString())
        Log.d("adit onTextChanged size of list", ""+ outletList.size)

    }

    fun getText(value : CharSequence): String? {
        Log.d("adit getText", ""+ value)

        Log.d("adit  getText size of list", ""+ outletList.size)

            return outletList.get(value.toString())
    }

    fun onItemClick(index: Int?) {
        Log.d("adit", ""+ index)
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









}