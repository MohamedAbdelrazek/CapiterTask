package com.capiter.base.ui.main.order

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.capiter.base.databinding.ActivityOrdersBinding
import com.capiter.base.ui.adapter.MainOrdersAdapter
import com.capiter.base.utils.AutoDisposable
import com.capiter.base.utils.BaseActivity
import com.capiter.base.utils.Constants
import javax.inject.Inject
import javax.inject.Named

class OrdersActivity : BaseActivity() {


    @Named(Constants.ViewModelNamedOrderActivity)
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var autoDisposable: AutoDisposable

    @Inject
    lateinit var mAdapter: MainOrdersAdapter

    private lateinit var viewModel: OrderViewModel
    private lateinit var mBinding: ActivityOrdersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityOrdersBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        appComponent.inject(this)
        autoDisposable.bindTo(this.lifecycle)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(OrderViewModel::class.java)
        mBinding.mMainOrdersRV.adapter = mAdapter
        getOrders()
    }


    private fun getOrders() {
        viewModel.getOrders().subscribe(
            {arrList->
                val map = arrList?.groupBy { it?.orderName }
                mAdapter.addData(map,map?.keys?.toTypedArray())
            },
            {
                Log.i("cap", "getProducts: " + it.message)

            }
        )

    }
}