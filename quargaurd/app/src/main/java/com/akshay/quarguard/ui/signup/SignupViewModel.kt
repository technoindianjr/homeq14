package com.akshay.quarguard.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.akshay.quarguard.ui.base.BaseViewModel
import com.akshay.quarguard.utils.common.*
import com.akshay.quarguard.utils.network.NetworkHelper
import com.akshay.quarguard.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by akshaynandwana on
 * 14, November, 2019
 **/

class SignupViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val validationsList: MutableLiveData<List<Validation>> = MutableLiveData()

    val launchMain: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val launchLogin: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    val emailField: MutableLiveData<String> = MutableLiveData()
    val passwordField: MutableLiveData<String> = MutableLiveData()
    val nameField: MutableLiveData<String> = MutableLiveData()
    val signingUp: MutableLiveData<Boolean> = MutableLiveData()

    val emailValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.EMAIL)
    val passwordValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.PASSWORD)

    private fun filterValidation(field: Validation.Field) =
        Transformations.map(validationsList) {
            it.find { validation -> validation.field == field }
                ?.run { return@run this.resource }
                ?: Resource.unknown()
        }

    override fun onCreate() {}

    fun onEmailChange(email: String) = emailField.postValue(email)

    fun onPasswordChange(password: String) = passwordField.postValue(password)

    fun onNameChange(name: String) = nameField.postValue(name)

    fun onSignUp() {
        val email = emailField.value
        val password = passwordField.value
        val name = nameField.value

        val validations = Validator.validateLoginFields(email, password)
        validationsList.postValue(validations)

        if (validations.isNotEmpty() && email != null && password != null && name != null) {
            val successValidation = validations.filter { it.resource.status == Status.SUCCESS }
            if (successValidation.size == validations.size && checkInternetConnectionWithMessage()) {
                signingUp.postValue(true)
                compositeDisposable.addAll(
                    /* userRepository.doUserSignUp(email, password, name)
                         .subscribeOn(schedulerProvider.io())
                         .subscribe(
                             {
                                 userRepository.saveCurrentUser(it)
                                 signingUp.postValue(false)
                                 launchMain.postValue(Event(emptyMap()))
                             },
                             {
                                 handleNetworkError(it)
                                 signingUp.postValue(false)
                             }
                         )*/
                )
            }
        }
    }

    fun launchLogin() {
        launchLogin.postValue(Event(emptyMap()))
    }

    fun clearEmailField() {
        emailField.postValue("")
    }

}