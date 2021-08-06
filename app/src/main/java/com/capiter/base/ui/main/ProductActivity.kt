package com.capiter.base.ui.main

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.capiter.base.data.model.ProductItem
import com.capiter.base.databinding.ActivityProductBinding
import com.capiter.base.ui.adapter.ProductAdapter
import com.capiter.base.utils.AutoDisposable
import com.capiter.base.utils.BaseActivity
import com.capiter.base.utils.Constants
import com.capiter.base.utils.addTo
import javax.inject.Inject
import javax.inject.Named


class ProductActivity : BaseActivity(), ProductAdapter.ProductListener {

    @Inject
    lateinit var mAdapter: ProductAdapter

    @Named(Constants.ViewModelNamedProductActivity)
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var autoDisposable: AutoDisposable

    private lateinit var viewModel: ProductActivityViewModel

    private lateinit var mBinding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        appComponent.inject(this)
        autoDisposable.bindTo(this.lifecycle)

        mBinding.mProductRV.adapter = mAdapter
        mAdapter.attachListener(this)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ProductActivityViewModel::class.java)
        getProducts()
    }

    private fun getProducts() {
        viewModel.getProducts().subscribe(
            {
                mAdapter.addData(it)
            },
            {
                Log.i("cap", "getProducts: " + it.message)

            }
        ).addTo(autoDisposable)

    }

    override fun onCartClicked(item: ProductItem) {
        viewModel.updateCart(item)
    }

}