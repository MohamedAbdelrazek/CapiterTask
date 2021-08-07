package com.capiter.base.ui.main.product

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.capiter.base.data.model.ProductItem
import com.capiter.base.data.repo.UserRepo
import com.capiter.base.databinding.ActivityProductBinding
import com.capiter.base.ui.adapter.ProductAdapter
import com.capiter.base.utils.*
import javax.inject.Inject
import javax.inject.Named


class ProductActivity : BaseActivity(), ProductAdapter.ProductListener {


    @Inject
    lateinit var userRepo: UserRepo

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

        mBinding.cartIV.click {
            openActivity<CartActivity>()
        }
        getProducts()
    }


    private fun getProducts() {
        viewModel.getProducts().subscribe(
            {
                mAdapter.addData(it, userRepo)
            },
            {
                Log.i("cap", "getProducts: " + it.message)

            }
        )

    }

    override fun onCartClicked(item: ProductItem) {
        viewModel.updateCart(item)
    }


    override fun onRestart() {
        super.onRestart()
        val intent = intent
        finish()
        startActivity(intent)
    }
}