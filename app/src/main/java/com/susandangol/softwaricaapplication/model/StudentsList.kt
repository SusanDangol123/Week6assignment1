package com.susandangol.softwaricaapplication.model

private val studentsList = ArrayList<StudentModel>()

class StudentsList {

    fun addStudentInList(student: StudentModel) {
        studentsList.add(student)
    }

    fun printStudentList() {
        for (i in studentsList.indices) {
            println("============>list<==============")
            println(studentsList[i])
        }
    }

    fun getStudentList(): ArrayList<StudentModel> {
        return studentsList
    }
}