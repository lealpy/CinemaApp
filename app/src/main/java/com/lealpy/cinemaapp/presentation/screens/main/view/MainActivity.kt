package com.lealpy.cinemaapp.presentation.screens.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.lealpy.cinemaapp.R
import com.lealpy.cinemaapp.databinding.ActivityMainBinding
import com.lealpy.cinemaapp.presentation.screens.main.MainInterface
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainInterface.MainViewInterface {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: MainInterface.MainPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        presenter.viewCreated()
    }

    override fun onDestroy() {
        presenter.viewDestroyed()
        super.onDestroy()
    }

    private fun initViews() {
        snackbar = Snackbar.make(
            binding.root,
            getString(R.string.no_internet),
            Snackbar.LENGTH_INDEFINITE,
        )
    }

    private var snackbar: Snackbar? = null

    override fun showMessageNoInternet() {
        snackbar?.show()
    }

    override fun hideMessageNoInternet() {
        snackbar?.dismiss()
    }

}
