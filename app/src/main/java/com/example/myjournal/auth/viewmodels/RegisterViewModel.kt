package com.example.myjournal.auth.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myjournal.auth.event.AuthEvent
import com.example.myjournal.data.model.RegistrationRequest
import com.example.myjournal.data.model.Resource
import com.example.myjournal.data.remote.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val isFormValid : MutableLiveData<Boolean> = MutableLiveData(true)

    private val api = RetrofitBuilder.gossipCentralAPI

    fun onEvent(event:AuthEvent){
        when(event){
            is AuthEvent.RegistrationEvent->{
                val request= event.request
                if(
                            request.email.isEmpty()||
                            request.firstName.isEmpty()||
                            request.lastName.isEmpty()||
                            request.password.isEmpty()
                ){
                    isFormValid.value= false
                    return
                }
                register(request)
            }
        }
    }

    fun register(request: RegistrationRequest) =
    liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        val result = api.register(request)
        if(result.successful){
            emit(Resource.success(result.data))
        }
        else{
            Resource.error(data = null, message = result.data.first)
        }


    }



}