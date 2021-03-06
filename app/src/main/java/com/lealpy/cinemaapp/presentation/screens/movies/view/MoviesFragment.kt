package com.lealpy.cinemaapp.presentation.screens.movies.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
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

    private val adapter = MoviesAdapter(
        onChapterItemClicked = { chapterItem ->
            presenter.onChapterItemClicked(chapterItem)
        },
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
        initToolbar()
        presenter.onViewCreated()
    }

    override fun onDestroyView() {
        presenter.onViewDestroyed()
        super.onDestroyView()
    }

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

        val layoutManager = GridLayoutManager(context, CHAPTER_ITEMS_SPAN_SIZE)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)) {
                    MoviesAdapter.ViewType.CHAPTER_ITEM.ordinal -> {
                        CHAPTER_ITEMS_SPAN_SIZE
                    }
                    MoviesAdapter.ViewType.GENRE_ITEM.ordinal -> {
                        GENRE_ITEMS_SPAN_SIZE
                    }
                    MoviesAdapter.ViewType.MOVIE_ITEM.ordinal -> {
                        MOVIE_ITEMS_SPAN_SIZE
                    }
                    else -> {
                        CHAPTER_ITEMS_SPAN_SIZE
                    }
                }
            }

        }

        binding.recyclerView.layoutManager = layoutManager

        val itemDecoration = MoviesItemDecoration(
            adapter = adapter,
            verticalSpacing = requireContext().resources.getDimension(R.dimen.dimen_6_dp).toInt(),
            horizontalSpacing = requireContext().resources.getDimension(R.dimen.dimen_12_dp).toInt()
        )

        binding.recyclerView.addItemDecoration(itemDecoration)

        binding.swipeRefreshLayout.setOnRefreshListener {
            presenter.onSwipedRefresh()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun initToolbar() {
        setHasOptionsMenu(true)
        val appCompatActivity = (requireActivity() as? AppCompatActivity)
        appCompatActivity?.supportActionBar?.title = getString(R.string.movies_title)
        appCompatActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    companion object {
        private const val CHAPTER_ITEMS_SPAN_SIZE = 2
        private const val GENRE_ITEMS_SPAN_SIZE = 2
        private const val MOVIE_ITEMS_SPAN_SIZE = 1
    }

}
