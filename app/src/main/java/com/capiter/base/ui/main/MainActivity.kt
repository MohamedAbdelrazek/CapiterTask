package com.capiter.base.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.capiter.base.R
import com.capiter.base.data.repo.UserRepo
import com.capiter.base.ui.adapter.CustomAdapter
import com.capiter.base.utils.AutoDisposable
import com.capiter.base.utils.BaseActivity
import com.capiter.base.utils.Constants
import com.capiter.base.utils.addTo
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named


class MainActivity : BaseActivity() {
    @Inject
    lateinit var userRepo: UserRepo

    @Named(Constants.ViewModelNamedMainActivity)
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var autoDisposable: AutoDisposable

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
        autoDisposable.bindTo(this.lifecycle)


        recyclerView.adapter = CustomAdapter()

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainActivityViewModel::class.java)
        getAllCities()
    }

    private fun getAllCities() {
        viewModel.getAllCities().subscribe(
            {

            },
            {

            }
        ).addTo(autoDisposable)

    }


}
