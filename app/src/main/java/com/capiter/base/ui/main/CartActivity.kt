package com.capiter.base.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.capiter.base.databinding.ActivityCartBinding
import com.capiter.base.ui.adapter.CartAdapter
import com.capiter.base.utils.AutoDisposable
import com.capiter.base.utils.BaseActivity
import com.capiter.base.utils.Constants
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class CartActivity : BaseActivity(), CartAdapter.CartListener {

    @Inject
    lateinit var mAdapter: CartAdapter

    @Named(Constants.ViewModelNamedProductActivity)
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var autoDisposable: AutoDisposable

    private lateinit var viewModel: ProductActivityViewModel
    private lateinit var mBinding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        appComponent.inject(this)
        autoDisposable.bindTo(this.lifecycle)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ProductActivityViewModel::class.java)

        mBinding.mProductRV.adapter = mAdapter

        mAdapter.attachListener(this)
        getCartItems()
    }

    private fun getCartItems() {
        viewModel.getCartItems()?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())?.subscribe({
                mAdapter.addData(it)
            }, {

            })
    }

    override fun removeItemFromCart(itemID: String) {
         viewModel.removeItemFromCart(itemID)
    }

}