package raj.outlet_form.data

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import raj.outlet_form.ui.EditDropElement
import raj.outlet_form.ui.Element
import raj.outlet_form.ui.HeadingElement
import raj.outlet_form.ui.TextElement

class ElementRepository(application: Application)
    {


    private val list1 = MutableLiveData<List<Element>>()
    private val list2 = MutableLiveData<List<Element>>()
    private val list3 = MutableLiveData<List<Element>>()
        val confirmation_list: MutableList<Element> = ArrayList()

        val items = MutableLiveData<List<String>>()


        fun getBottomList(name : String) :  MutableLiveData<List<String>>{

            val temp_list: MutableList<String> = ArrayList()
            temp_list.add("Item 1")
            temp_list.add("Item 2")
            temp_list.add("Item 3")
           temp_list.add("Item 4")
           temp_list.add("Item 5")
            items.value = temp_list
            return items ;
        }

        init {
            addElement()
            addElement2()
        }

    fun getElementList1() : MutableLiveData<List<Element>>
    {
         return  list1
    }

        fun getElementList2() : MutableLiveData<List<Element>>
        {
            return  list2
        }


        fun getElementList3() : MutableLiveData<List<Element>>
        {
            list3.value = confirmation_list
            return   list3
        }

///////// DATA WILL BE FETCHED FROM THE SERVER BELOW IS THE DUMMY DATA TO CHECK THE ARCHITECTURE//////////







        fun addElement2()
        {
            val headingElement = HeadingElement("SHOP PROFILE")
            val textElement =  EditDropElement(Field("Channel", true, null))
            val textElement1 = EditDropElement(Field("Shop Type", true, null))
            val textElement2 = EditDropElement(Field("Segmentation ", true, null))
            val textElement3 = EditDropElement(Field("Distributor ", true, null))

            val temp_list1: MutableList<Element> = ArrayList()
            temp_list1.add(headingElement)
            temp_list1.add(textElement)
            temp_list1.add(textElement1)
            temp_list1.add(textElement2)
            temp_list1.add(textElement3)
            confirmation_list.addAll(temp_list1)
            list2.value = temp_list1
        }


     fun addElement()
     {
         val headingElement = HeadingElement("Beat Info")
         val textElement = TextElement(Field("Outlet Name", true, null))
         val textElement1 = TextElement(Field("Address", true, null))
         val textElement2 = TextElement(Field("Market ", true, null))
         val headingElement1 = HeadingElement("CONTACT INFORMATION")
         val textElement3 = TextElement(Field("Name", true, null))
         val textElement4 = TextElement(Field("Phone Number", true, null))
         val textElement5 = TextElement(Field("Email Id ", true, null))
         val headingElement2 = HeadingElement("TAX DETAILS")
         val textElement6 = TextElement(Field("GST Number", true, null))
         val textElement7 = TextElement(Field("Adhar Card Number", true, null))
         val textElement8 = TextElement(Field("PAN", true, null))
         val headingElement3 = HeadingElement("BANK DETAILS")
         val textElement9 = TextElement(Field("Account Owner Name", true, null))
         val textElement10 = TextElement(Field("Acount Number", true, null))
         val textElement11 = TextElement(Field("IFSC Code", true, null))





         val temp_list: MutableList<Element> = ArrayList()

         temp_list.add(headingElement)
         temp_list.add(textElement)
         temp_list.add(textElement1)
         temp_list.add(textElement2)
         temp_list.add(headingElement1)
         temp_list.add(textElement3)
         temp_list.add(textElement4)
         temp_list.add(textElement5)
         temp_list.add(headingElement2)
         temp_list.add(textElement6)
         temp_list.add(textElement7)
         temp_list.add(textElement8)
         temp_list.add(headingElement3)
         temp_list.add(textElement9 )
         temp_list.add(textElement10)
         temp_list.add(textElement11)
         confirmation_list.addAll(temp_list)

         list1.value = temp_list
     }









}