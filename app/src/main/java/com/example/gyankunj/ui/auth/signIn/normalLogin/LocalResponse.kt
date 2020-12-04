package com.example.gyankunj.ui.auth.signIn.normalLogin

data class LocalResponse(var is_email_verified:Boolean, var email:String, var first_name:String, var lastName:String,
                         var image:String, var login_attempts:Int)