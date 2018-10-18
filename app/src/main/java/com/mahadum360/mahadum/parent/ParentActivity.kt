package com.mahadum360.mahadum.parent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mahadum360.mahadum.Mahadum
import com.mahadum360.mahadum.R
import com.mahadum360.mahadum.parent.di.ParentActivityContextModule
import javax.inject.Inject

class ParentActivity : AppCompatActivity(), ParentContract.View {
    override fun hideProgress() {

    }

    override fun showProgress() {

    }

    override fun showComplete() {

    }

    override fun showError(call: String, message: String) {

    }

    override fun onAddKidSuccess(response: String) {

    }

    @Inject
    lateinit var presenter: ParentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
        (application as Mahadum)
                .appComponent
                .add(ParentActivityContextModule(this))
                .inject(this)
    }
}
