package com.susandangol.softwaricaapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.susandangol.softwaricaapplication.R
import com.susandangol.softwaricaapplication.model.StudentModel
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter (

    val listStudent : ArrayList<StudentModel>,
    val context: Context
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val studentImage : CircleImageView
        val tvFullName: TextView
        val tvAge: TextView
        val tvAddress: TextView
        val delStudent: ImageView
        val tvGender: TextView

        init {
            studentImage = view.findViewById(R.id.studentImage)
            tvFullName = view.findViewById(R.id.tvFullName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            delStudent = view.findViewById(R.id.delStudent)
            tvGender = view.findViewById(R.id.tvGender)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val students = listStudent[position]

        Glide.with(context)
            .load(students.dp)
            .into(holder.studentImage)

        holder.tvFullName.text =students.fullName
        holder.tvAge.text =students.age
        holder.tvAddress.text =students.address
        holder.tvGender.text =students.gender

        holder.delStudent.setOnClickListener{
            deleteItem(position)
        }
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    fun deleteItem (index: Int) {
        listStudent.removeAt(index)
        notifyDataSetChanged()
    }

}