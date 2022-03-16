package com.lealpy.cinemaapp.presentation.screens.movies.view

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lealpy.cinemaapp.R
import com.lealpy.cinemaapp.databinding.FragmentMoviesBinding
import com.lealpy.cinemaapp.presentation.models.RecyclerViewItem
import com.lealpy.cinemaapp.presentation.screens.movies.MoviesInterface
import com.lealpy.cinemaapp.presentation.utils.PresentationConst.MOVIE_ID_KEY
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesFragment : Fragment(R.layout.fragment_movies), MoviesInterface.MoviesViewInterface {

    private lateinit var binding: FragmentMoviesBinding

    @Inject
    lateinit var presenter: MoviesInterface.MoviesPresenterInterface

    private val adapter = MoviesAdapter (
        onGenreItemClicked = { genreItem ->
            presenter.onGenreItemClicked(genreItem)
        },
        onMovieItemClicked = { movieItem ->
            val args = bundleOf(MOVIE_ID_KEY to movieItem.id)
            findNavController().navigate(
                R.id.action_moviesFragment_to_detailsFragment,
                args,
            )
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoviesBinding.bind(view)
        initViews()
    }

//    override fun onDestroyView() {
//        presenter?.detachView()
//        super.onDestroyView()
//    }

    override fun updateRecyclerViewItems(recyclerViewItems: List<RecyclerViewItem>) {
        adapter.submitList(recyclerViewItems)
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }

    private fun initViews() {
        binding.recyclerView.adapter = adapter
        presenter.viewIsReady()
        binding.swipeRefreshLayout.setOnRefreshListener {
            presenter.onSwipedRefresh()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

}