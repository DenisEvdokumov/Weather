package com.example.weaterm



/**
 * Created by Денис on 30.10.2017.
 */


object Model {
    data class Result(val current: Current)
    data class Current(val temp_c: Float,val condition :Icon)
    data class Icon (val icon: String)


    }
