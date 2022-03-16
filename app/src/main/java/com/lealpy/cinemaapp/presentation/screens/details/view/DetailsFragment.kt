package com.lealpy.cinemaapp.presentation.screens.details.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.lealpy.cinemaapp.R
import com.lealpy.cinemaapp.databinding.FragmentDetailsBinding
import com.lealpy.cinemaapp.domain.models.Movie
import com.lealpy.cinemaapp.presentation.screens.details.DetailsInterface
import com.lealpy.cinemaapp.presentation.utils.PresentationConst.MOVIE_ID_KEY
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details), DetailsInterface.DetailsViewInterface {

    private lateinit var binding: FragmentDetailsBinding

    @Inject
    lateinit var presenter: DetailsInterface.DetailsPresenterInterface

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        initViews()
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun updateMovie(movie: Movie) {
        binding.detailsName.text = movie.name

        binding.detailsDescription.text = movie.description

        binding.detailsRating.text = String.format(
            getString(R.string.rating_format),
            movie.rating.toString()
        )

        binding.detailsYear.text = String.format(
            getString(R.string.year_format),
            movie.year.toString()
        )

        Glide.with(requireContext())
            .load(movie.imageUrl)
            .placeholder(R.drawable.ic_baseline_sentiment_dissatisfied_24)
            .error(R.drawable.ic_baseline_sentiment_dissatisfied_24)
            .into(binding.detailsImage)
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }

    private fun initViews() {
        arguments?.getInt(MOVIE_ID_KEY)?.let { movieId ->
            presenter.viewIsReady(movieId = movieId)
        }
    }

}