package com.capiter.base.ui.main.product

import android.os.Bundle
import com.capiter.base.databinding.ActivityConfirmOrderBinding
import com.capiter.base.utils.BaseActivity

class ConfirmOrderActivity : BaseActivity() {

    private lateinit var mBinding: ActivityConfirmOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityConfirmOrderBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.activity = this
    }


}