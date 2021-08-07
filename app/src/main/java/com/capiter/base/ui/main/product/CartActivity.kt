package com.capiter.base.ui.main.product

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.capiter.base.data.model.OrderItem
import com.capiter.base.databinding.ActivityCartBinding
import com.capiter.base.ui.adapter.CartAdapter
import com.capiter.base.utils.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class CartActivity : BaseActivity(), CartAdapter.CartListener {

    private var mOrderName: String = ""

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

        mBinding.confirmOrderTV.click {
            mOrderName = mBinding.orderNameET.text.toString()
            if (mOrderName.isEmpty()) {
                mBinding.orderNameTIL.error = "الرجاء ادخال اسم الطلب"
            } else {
                mBinding.orderNameTIL.error = null
                prepareOrderForSubmission()
            }

        }
    }

    private fun prepareOrderForSubmission() {
        viewModel.getCartItems()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.concatMapSingle { list ->
            Observable.fromIterable(list).map {
                OrderItem(
                    orderName = mOrderName,
                    productId = it?.id,
                    productImageUrl = it?.imageUrl,
                    productName = it?.name,
                    productPrice = it?.price,
                    productQuantity = it?.productQuantity
                )
            }.toList()
        }?.take(1)?.subscribe({
            if (it?.isEmpty() == true) {
                showToast("اضف بعض المنتجات للاستمرار")
                mProgress.hide()
            } else {
                sendOrders(it)
            }


        },
            {
                Log.i("cap", "prepareOrderForSubmission: " + it?.message)
            })?.addTo(autoDisposable)

    }

    private fun sendOrders(orderList: List<OrderItem>) {
        mProgress.show()
        viewModel.sendOrders(orderList).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    clearCartAndNavigate()
                },
                {
                    mProgress.hide()
                    Log.i("cap", "sendOrders: Error " + it?.message)
                }
            ).addTo(autoDisposable)


    }

    private fun clearCartAndNavigate() {
        viewModel.deleteOrders().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                mProgress.hide()
                openActivity<ConfirmOrderActivity>()

            }, {
                mProgress.hide()
                Log.i("cap", "deleteOrders Error: " + it.message)
            }).addTo(autoDisposable)

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