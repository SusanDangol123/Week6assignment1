package com.susandangol.softwaricaapplication.fragments

import android.app.PendingIntent.getActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

import com.susandangol.softwaricaapplication.R
import com.susandangol.softwaricaapplication.model.StudentModel
import com.susandangol.softwaricaapplication.model.StudentsList



class StudentFragment : Fragment() {

    private lateinit var etFullName : EditText
    private lateinit var etAge : EditText
    private lateinit var rdoMale : RadioButton
    private lateinit var rdoFemale : RadioButton
    private lateinit var rdoOthers : RadioButton
    private lateinit var etAddress : EditText
    private lateinit var etDp : EditText
    private lateinit var btnSave : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student, container, false)

        val context = activity as AppCompatActivity

        etFullName = view.findViewById(R.id.etFullName)
        etAge = view.findViewById(R.id.etAge)
        rdoMale = view.findViewById(R.id.rdoMale)
        rdoFemale = view.findViewById(R.id.rdoFemale)
        rdoOthers = view.findViewById(R.id.rdoOthers)
        etAddress = view.findViewById(R.id.etAddress)
        etDp = view.findViewById(R.id.etDp)
        btnSave = view.findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            createStudent()

            val transaction = (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.linearContainer, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
            clearFields()

        }

        return view
    }

    private fun createStudent() {
        val fullname = etFullName.text.toString()
        val age = etAge.text.toString()
        var gender = ""
        val address = etAddress.text.toString()
        val dp = etDp.text.toString()

        when {
            rdoMale.isChecked -> {
                gender = "Male"
            }
            rdoFemale.isChecked -> {
                gender = "Female"
            }
            rdoOthers.isChecked -> {
                gender = "Others"
            }

        }

        val student = StudentModel(fullname, address, gender, age, dp)

        val studentToList = StudentsList()

        studentToList.addStudentInList(student)

        studentToList.printStudentList()
    }

    private fun clearFields() {
        etFullName.text.clear()
        etAge.text.clear()
        rdoMale.isChecked = false
        rdoFemale.isChecked = false
        rdoOthers.isChecked = false
        etAddress.text.clear()
        etDp.text.clear()
    }


}


